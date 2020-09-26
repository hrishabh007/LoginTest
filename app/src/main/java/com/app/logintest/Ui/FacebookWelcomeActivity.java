package com.app.logintest.Ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.app.logintest.CommonUtils.DownloadImage;
import com.app.logintest.CommonUtils.Prefs;
import com.app.logintest.R;
import com.facebook.login.LoginManager;
import com.facebook.share.widget.ShareDialog;

public class FacebookWelcomeActivity extends AppCompatActivity {
    private ShareDialog mShareDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_facebook_welcome);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Bundle inBundle = getIntent().getExtras();
        /*String name = inBundle.get("name").toString();
        String surname = inBundle.get("surname").toString();
//        String email = inBundle.get("email").toString();
        String imageUrl = inBundle.get("imageUrl").toString()*/
        ;

        // Toast.makeText(FacebookWelcomeActivity.this,""+email,Toast.LENGTH_LONG).show();
        String name = Prefs.getString("name","");
        String surname = Prefs.getString("surname","");
//        String email = inBundle.get("email").toString();
        String imageUrl = Prefs.getString("imageUrl","");
        TextView nameView = (TextView) findViewById(R.id.nameAndSurname);
        nameView.setText("" + name + " " + surname);

        mShareDialog = new ShareDialog(this);
        new DownloadImage((ImageView) findViewById(R.id.profileImage)).execute(imageUrl);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_login, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            logout();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void logout() {
        LoginManager.getInstance().logOut();
        Prefs.clear();
        Intent login = new Intent(FacebookWelcomeActivity.this, MainActivity.class);
        startActivity(login);
        finish();
    }
}