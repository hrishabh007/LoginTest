package com.app.logintest.CommonUtils;

import android.text.TextUtils;
import android.util.Patterns;

public class CommonMethods
{
    public static boolean isEmpty(String str) {
        return str == null || str.trim().equals("") || str.trim().toLowerCase().equalsIgnoreCase("null");
    }

    public static boolean isValidEmail(String email) {
        return !TextUtils.isEmpty(email) && Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }

}
