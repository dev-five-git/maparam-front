package com.example.myapplication.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.Adapter.MaparamGroupPostAdapter;
import com.example.myapplication.Model.KeywordPostModel;
import com.example.myapplication.Model.MaparamGroupPostModel;
import com.example.myapplication.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class BlankActivity extends AppCompatActivity {
    RecyclerView TimeLinePostRecycler;
    ArrayList<MaparamGroupPostModel> posts = new ArrayList<>();
    MaparamGroupPostAdapter adapter;
    Button goBack;
    FloatingActionButton addPostBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maparam_group_timeline);
        TimeLinePostRecycler = findViewById(R.id.TimeLinePostRecycler);
        goBack = findViewById(R.id.goBack);
        addPostBtn = findViewById(R.id.addPostBtn);
        makingAdapter();
        buildingFloatingAction();
    }
    public void goBack(View view){
        onBackPressed();
    }
    public void makingAdapter(){
        posts = new ArrayList<>();
        for (int i = 0 ; i<15;i++) {
            MaparamGroupPostModel post = new MaparamGroupPostModel(i+"",i+"",i+"",i+"",
                    "",i,i);
            posts.add(post);
        }
        adapter = new MaparamGroupPostAdapter(posts, this, new MaparamGroupPostAdapter.ClickButton() {
            @Override
            public void clickComment() {
                startActivity(new Intent(getApplicationContext(), HomeCommentDetailActivity.class));
            }
        });
        TimeLinePostRecycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        TimeLinePostRecycler.setAdapter(adapter);
    }
    public void buildingFloatingAction(){
        addPostBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                posts.add(0, new MaparamGroupPostModel("ddd","zz","ddf","ddddddddddddddddd",
                        "https://maparam.s3.ap-northeast-2.amazonaws.com/6ce1e5f4-5d01-4bae-a3ba-e29b66a91060.png",0,0));
                Log.e("dd",posts.size()+"");
                adapter.notifyDataSetChanged();
                Intent intent = new Intent(BlankActivity.this, AddPostActivity.class);
                BlankActivity.this.startActivity(intent);
            }
        });
    }
}