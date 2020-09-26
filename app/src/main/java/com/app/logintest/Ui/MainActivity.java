package com.app.logintest.Ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.StrictMode;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.app.logintest.CommonUtils.CommonMethods;
import com.app.logintest.CommonUtils.KeyboardUtils;
import com.app.logintest.CommonUtils.PrefKeys;
import com.app.logintest.CommonUtils.Prefs;
import com.app.logintest.Model.Login;
import com.app.logintest.MyApp;
import com.app.logintest.R;
import com.app.logintest.Retrofit.ApiInterface;
import com.app.logintest.Retrofit.RestAdapter;
import com.app.logintest.databinding.ActivityMainBinding;
import com.facebook.AccessToken;
import com.facebook.AccessTokenTracker;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.Profile;
import com.facebook.ProfileTracker;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.google.gson.Gson;
import com.squareup.picasso.Picasso;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Arrays;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding activityMainBinding;
    private ProgressDialog dialog;
    private CallbackManager callbackManager;
    private AccessTokenTracker accessTokenTracker;
    private ProfileTracker profileTracker;
    private ImageView btn_fb_login;
    private LinearLayout linearbutton;

    //Facebook login button
    private FacebookCallback<LoginResult> callback = new FacebookCallback<LoginResult>() {
        @Override
        public void onSuccess(LoginResult loginResult) {
            Profile profile = Profile.getCurrentProfile();

            if (profile != null) {
                Prefs.putString("name", profile.getFirstName());
                Prefs.putString("surname", profile.getLastName());
                Prefs.putString("imageUrl", profile.getProfilePictureUri(200, 200).toString());
            }

            nextActivity(profile);
        }

        @Override
        public void onCancel() {
        }

        @Override
        public void onError(FacebookException e) {
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        LoginButton loginButton = (LoginButton) findViewById(R.id.login_button);
      //  btn_fb_login = (ImageView) findViewById(R.id.btn_fb_login);

        linearbutton = (LinearLayout) findViewById(R.id.linearbutton);
        FacebookSdk.sdkInitialize(getApplicationContext());
        activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        callbackManager = CallbackManager.Factory.create();
        accessTokenTracker = new AccessTokenTracker() {
            @Override
            protected void onCurrentAccessTokenChanged(AccessToken oldToken, AccessToken newToken) {
            }
        };

        profileTracker = new ProfileTracker() {
            @Override
            protected void onCurrentProfileChanged(Profile oldProfile, Profile newProfile) {

                if (newProfile != null) {
                    Prefs.putString("name", newProfile.getFirstName());
                    Prefs.putString("surname", newProfile.getLastName());
                    Prefs.putString("imageUrl", newProfile.getProfilePictureUri(200, 200).toString());
                }

                nextActivity(newProfile);
            }
        };
        accessTokenTracker.startTracking();
        profileTracker.startTracking();


        callback = new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                AccessToken accessToken = loginResult.getAccessToken();
                Profile profile = Profile.getCurrentProfile();
                nextActivity(profile);
                Toast.makeText(getApplicationContext(), "Logging in...", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onCancel() {
            }

            @Override
            public void onError(FacebookException e) {
            }
        };
        loginButton.setReadPermissions("user_friends");
        loginButton.registerCallback(callbackManager, callback);

        if (MyApp.isLogin() && Prefs.getString("log", "1").equals("1")) {
            Intent intent = new Intent(getBaseContext(), WelcomeActivity.class);
            startActivity(intent);
            finish();

        }
        if (MyApp.isLogin() && Prefs.getString("log", "1").equals("2")) {
            Intent intent = new Intent(getBaseContext(), FacebookWelcomeActivity.class);
            startActivity(intent);
            finish();

        }


        activityMainBinding.btnsubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = activityMainBinding.edtemail.getText().toString().trim();
                String password = activityMainBinding.edtpassword.getText().toString().trim();
                if (CommonMethods.isEmpty(email)) {
                    activityMainBinding.edtemail.setError("Email should not be blank");
                } else if (CommonMethods.isEmpty(password)) {
                    activityMainBinding.edtpassword.setError("password should not be blank");
                } else if (!CommonMethods.isValidEmail(email)) {
                    activityMainBinding.edtemail.setError("Enter valid Mail");
                } else {
                    login(email, password);
                }

            }
        });

        activityMainBinding.btnFbLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activityMainBinding.loginButton.performClick();
              //  Toast.makeText(getApplicationContext(), "Logging in...", Toast.LENGTH_SHORT).show();
            }
        });

    }


    private void login(String email, String password) {

        setProgress();
        ApiInterface apiInterface = RestAdapter.createAPI();

        Call<Login> loginCall = apiInterface.login(email, password);
        loginCall.enqueue(new Callback<Login>() {
            @Override
            public void onResponse(Call<Login> call, Response<Login> response) {
                dismisDialog();
                if (response.body().getSuccess().equals("1")) {
                    Gson gson = new Gson();
                    String favData = gson.toJson(response.body().getData());

                    Prefs.putString(PrefKeys.PREF_USER_DETAIL, favData);
                    Prefs.putBoolean(PrefKeys.PREF_IS_LOGIN, true);
                    Prefs.putString("log", "1");
                    KeyboardUtils.hideSoftInput(MainActivity.this);
                    Intent i = new Intent(MainActivity.this, WelcomeActivity.class);
                    i.putExtra("key", "1");
                    startActivity(i);
                    finish();
                }

            }

            @Override
            public void onFailure(Call<Login> call, Throwable t) {
                dismisDialog();
            }
        });
    }


    private void setProgress() {
        try {
            dialog = new ProgressDialog(MainActivity.this);
            dialog.setMessage("Please wait...");
            dialog.setCancelable(false);
            dialog.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void dismisDialog() {
        if (dialog != null && dialog.isShowing()) {
            dialog.dismiss();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int responseCode, Intent intent) {
        super.onActivityResult(requestCode, responseCode, intent);
        //Facebook login
        callbackManager.onActivityResult(requestCode, responseCode, intent);
    }

    private void nextActivity(Profile profile) {

        if (profile != null) {
            Prefs.putString("log", "2");
            Prefs.putBoolean(PrefKeys.PREF_IS_LOGIN, true);
            Intent main = new Intent(MainActivity.this, FacebookWelcomeActivity.class);
         /*   main.putExtra("name", profile.getFirstName());
            main.putExtra("email", profile.getId());
            main.putExtra("surname", profile.getLastName());
            main.putExtra("imageUrl", profile.getProfilePictureUri(200, 200).toString());*/

            main.putExtra("name", Prefs.getString("name", ""));
            main.putExtra("surname", Prefs.getString("surname", ""));
            main.putExtra("imageUrl", Prefs.getString("imageUrl", ""));
            startActivity(main);
        }
    }


}