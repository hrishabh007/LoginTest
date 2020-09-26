package com.app.logintest;

import android.app.Application;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.util.Base64;
import android.util.Log;

import com.app.logintest.CommonUtils.PrefKeys;
import com.app.logintest.CommonUtils.Prefs;
import com.app.logintest.Model.Data;
import com.facebook.FacebookSdk;
import com.facebook.appevents.AppEventsLogger;
import com.google.gson.Gson;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MyApp extends Application {

    public static MyApp myApp;


    @Override
    public void onCreate() {
        super.onCreate();
        FacebookSdk.sdkInitialize(getApplicationContext());
        AppEventsLogger.activateApp(this);
        myApp = this;
        new Prefs.Builder().
                setContext(this).
                setMode(Context.MODE_PRIVATE).
                setUseDefaultSharedPreference(true).build();
        printHashKey();
    }

    public void printHashKey() {
        // Add code to print out the key hash
        try {
            PackageInfo info = getPackageManager().getPackageInfo(
                    "com.app.logintest",
                    PackageManager.GET_SIGNATURES);
            for (Signature signature : info.signatures) {
                MessageDigest md = MessageDigest.getInstance("SHA");
                md.update(signature.toByteArray());
                Log.d("KeyHash:", Base64.encodeToString(md.digest(), Base64.DEFAULT));
            }
        } catch (PackageManager.NameNotFoundException e) {

        } catch (NoSuchAlgorithmException e) {

        }
    }

    public static Data getUserDetail() {
        try {
            return new Gson().fromJson(Prefs.getString(PrefKeys.PREF_USER_DETAIL, ""), Data.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static boolean isLogin() {
        return Prefs.getBoolean(PrefKeys.PREF_IS_LOGIN, false);
    }

    public static MyApp getMyApp() {
        return myApp;
    }
}
