package com.app.logintest.Ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.app.logintest.CommonUtils.Prefs;
import com.app.logintest.Model.Data;
import com.app.logintest.MyApp;
import com.app.logintest.R;

public class WelcomeActivity extends AppCompatActivity {
    private Data data;
    private TextView textView;
    private Button btnlogout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        data = MyApp.getUserDetail();
        textView = (TextView) findViewById(R.id.welcome);
        btnlogout = (Button) findViewById(R.id.btnlogout);
        textView.setText(String.valueOf(data.getRoll()));

        btnlogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Prefs.clear();
                Intent i = new Intent(WelcomeActivity.this, MainActivity.class);
                startActivity(i);
                finish();
            }
        });

    }
}