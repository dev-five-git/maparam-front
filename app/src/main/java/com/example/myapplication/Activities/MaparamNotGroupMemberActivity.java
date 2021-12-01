package com.example.myapplication.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.myapplication.R;

public class MaparamNotGroupMemberActivity extends AppCompatActivity {
    Button backBtn;
    TextView group_name;
    TextView description;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maparam_not_group_member);
        backBtn = findViewById(R.id.backBtn);
        group_name = findViewById(R.id.group_name);
        description = findViewById(R.id.description);
    }
    public void goBack(View view){
        onBackPressed();
    }
}