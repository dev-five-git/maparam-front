package com.example.myapplication.Fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.myapplication.Activities.AddPostActivity;
import com.example.myapplication.Activities.HomeCommentDetailActivity;
import com.example.myapplication.Adapter.KeywordPostAdapter;
import com.example.myapplication.Dialog.KeywordDialog;
import com.example.myapplication.Model.KeywordPostModel;
import com.example.myapplication.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeFragment extends Fragment {
    private static String TAG = "HomeFragment";

    private View view;
    private Context context;
    ArrayList<KeywordPostModel> posts = new ArrayList<>();
    Button keywordButton;
    RecyclerView kewordPostRecycler;
    FloatingActionButton addPostBtn;
    KeywordPostAdapter adapter;
    Boolean init = true;
    public HomeFragment() {
    }
    public static HomeFragment newInstance(Context context) {
        HomeFragment fragment = new HomeFragment();
        fragment.context = context;
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.e(TAG,"D");
        if(!init){
            posts.add(0,new KeywordPostModel("ddd","zz","ddf","ddddddddddddddddd",
                    "https://maparam.s3.ap-northeast-2.amazonaws.com/6ce1e5f4-5d01-4bae-a3ba-e29b66a91060.png",0,0));
            Log.e("qq",posts.size()+"");
            adapter.notifyDataSetChanged();
        }else{
            init = false;
        }

    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view= inflater.inflate(R.layout.fragment_home,container,false);
        addPostBtn = view.findViewById(R.id.addPostBtn);
        keywordButton = view.findViewById(R.id.todayKeyword);
        kewordPostRecycler = view.findViewById(R.id.keywordPostRecycler);
        keywordButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pressKeyword();
            }
        });
        makingAdapter();
        buildingFloatingAction();

        return view;
    }
    public void makingAdapter(){
        posts = new ArrayList<>();
        for (int i = 0 ; i<15;i++) {
//            KeywordPostModel post = new KeywordPostModel(i+"",i+"",i+"",i+"","https://maparam.s3.ap-northeast-2.amazonaws.com/6ce1e5f4-5d01-4bae-a3ba-e29b66a91060.png",i,i);
            KeywordPostModel post = new KeywordPostModel(i+"",i+"",i+"",i+"",
                    "",i,i);
            posts.add(post);
        }
        adapter = new KeywordPostAdapter(posts, context, new KeywordPostAdapter.ClickButton() {
            @Override
            public void clickComment() {
//                getChildFragmentManager().beginTransaction().replace(R.id.topLevel,new CommunityFragment(context)).commit();
                getActivity().startActivity(new Intent(getActivity(), HomeCommentDetailActivity.class));
            }
        });
        kewordPostRecycler.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false));
        kewordPostRecycler.setAdapter(adapter);
    }
    public void pressKeyword() {
        KeywordDialog dialog = new KeywordDialog(context);
        dialog.callFunction();
    }
    public void buildingFloatingAction(){
        addPostBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                posts.add(0,new KeywordPostModel("ddd","zz","ddf","ddddddddddddddddd",
                        "https://maparam.s3.ap-northeast-2.amazonaws.com/6ce1e5f4-5d01-4bae-a3ba-e29b66a91060.png",0,0));
                Log.e("dd",posts.size()+"");
                adapter.notifyDataSetChanged();
                Intent intent = new Intent(context, AddPostActivity.class);
                context.startActivity(intent);
            }
        });
    }
}