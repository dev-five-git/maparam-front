package com.example.myapplication.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.myapplication.Dialog.MemberListDialog;
import com.example.myapplication.R;

import java.lang.reflect.Member;

public class MaparamGroupHeaderActivity extends AppCompatActivity {
    public static int TIER = 2;
    Button backBtn;
    Button setting_group_member;
    ImageButton notice_btn;
    ImageButton timeLine_btn;
    TextView group_name;
    TextView description;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maparam_group_header);
        backBtn = findViewById(R.id.backBtn);
        setting_group_member = findViewById(R.id.setting_group_member);
        group_name = findViewById(R.id.group_name);
        description = findViewById(R.id.description);
        notice_btn = findViewById(R.id.notice_btn);
        timeLine_btn = findViewById(R.id.timeLine_btn);
        buildingButtons();
    }

    private void buildingButtons() {
        setting_group_member.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MemberListDialog dialog = new MemberListDialog(MaparamGroupHeaderActivity.this,TIER);
                dialog.callFunction();
            }
        });
        notice_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MaparamGroupHeaderActivity.this,MaparamGroupNoticeActivity.class);
                startActivity(intent);
            }
        });
        timeLine_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MaparamGroupHeaderActivity.this,MaparamGroupTimeLineActivity.class);
                startActivity(intent);
            }
        });
    }

    public void goBack(View view){
        onBackPressed();
    }
}