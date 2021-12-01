package com.example.myapplication.Activities;

import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.Adapter.ProfileBelongGroupAdapter;
import com.example.myapplication.R;

public class ProfileSomeonesActivity extends AppCompatActivity {
    RecyclerView maparam_I_have_recycler;
    Button inviteMyMaparam;
    ProfileBelongGroupAdapter adapter;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_profile);
        maparam_I_have_recycler = findViewById(R.id.maparam_I_have_recycler);
        inviteMyMaparam = findViewById(R.id.edit_profile);
        inviteMyMaparam.setText("내 마파람으로 초대하기");
        adapter = new ProfileBelongGroupAdapter(false);
        maparam_I_have_recycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        maparam_I_have_recycler.setAdapter(adapter);
    }
}
