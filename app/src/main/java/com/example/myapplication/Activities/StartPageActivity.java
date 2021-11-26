package com.example.myapplication.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;


public class StartPageActivity extends AppCompatActivity {
    Button loginBtn;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.startpage);

        loginBtn = findViewById(R.id.loginButton);
    }

    public void goLoginPage(View view) {
        Intent intent = new Intent(this, LoginPageActivity.class);
        startActivity(intent);
        finish();
    }
}
