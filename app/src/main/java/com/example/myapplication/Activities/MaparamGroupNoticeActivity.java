package com.example.myapplication.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.myapplication.Adapter.KeywordPostAdapter;
import com.example.myapplication.Adapter.MaparamGroupPostAdapter;
import com.example.myapplication.Model.KeywordPostModel;
import com.example.myapplication.Model.MaparamGroupPostModel;
import com.example.myapplication.R;

import java.util.ArrayList;

public class MaparamGroupNoticeActivity extends AppCompatActivity {
    RecyclerView noticePostRecycler;
    ArrayList<MaparamGroupPostModel> posts = new ArrayList<>();
    MaparamGroupPostAdapter adapter;
    Button goBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maparam_group_notice);
        noticePostRecycler = findViewById(R.id.NoticePostRecycler);
        goBack = findViewById(R.id.goBack);
        makingAdapter();
    }
    public void goBack(View view){
        onBackPressed();
    }
    public void makingAdapter(){
        posts = new ArrayList<>();
        for (int i = 0 ; i<15;i++) {
//            KeywordPostModel post = new KeywordPostModel(i+"",i+"",i+"",i+"","https://maparam.s3.ap-northeast-2.amazonaws.com/6ce1e5f4-5d01-4bae-a3ba-e29b66a91060.png",i,i);
            MaparamGroupPostModel post = new MaparamGroupPostModel(i+"",i+"",i+"",i+"",
                    "",i,i);
            posts.add(post);
        }
        adapter = new MaparamGroupPostAdapter(posts, this, new MaparamGroupPostAdapter.ClickButton() {
            @Override
            public void clickComment() {
//                getChildFragmentManager().beginTransaction().replace(R.id.topLevel,new CommunityFragment(context)).commit();
                startActivity(new Intent(MaparamGroupNoticeActivity.this, MaparamGroupCommentActivity.class));
            }
        });
        noticePostRecycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        noticePostRecycler.setAdapter(adapter);
    }

}