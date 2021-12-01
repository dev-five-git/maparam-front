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
            KeywordPostModel post;
//            KeywordPostModel post = new KeywordPostModel(i+"",i+"",i+"",i+"","https://maparam.s3.ap-northeast-2.amazonaws.com/6ce1e5f4-5d01-4bae-a3ba-e29b66a91060.png",i,i);
            if (i % 2 == 0 ) {
                post = new KeywordPostModel("마파람",  "20대", "2021-12-01", "마파람 로고입니다",
                        "", i, i);
            }else{
                post = new KeywordPostModel("마파람", "20대", "2021-12-01", "마파람 로고입니다",
                    "https://postfiles.pstatic.net/MjAyMTEyMDFfMjEw/MDAxNjM4MzUwNTA1MDIx.G0T_h-dSZOCzEim1GHmXKKEGE3H825gARh6bEfGEcocg.aUZ5pX-u81tDGlP5dxcXdqiQUnaeqOrbndBiNcGMgrMg.PNG.xldi29/%EB%AC%BC%EA%B2%B0%EA%B3%A0%EB%9E%98.png?type=w966", i, i);
            }
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
                posts.add(0,new KeywordPostModel("마파람","20대","2021-12-01","마파람 로고입니다",
                        "https://postfiles.pstatic.net/MjAyMTEyMDFfMjEw/MDAxNjM4MzUwNTA1MDIx.G0T_h-dSZOCzEim1GHmXKKEGE3H825gARh6bEfGEcocg.aUZ5pX-u81tDGlP5dxcXdqiQUnaeqOrbndBiNcGMgrMg.PNG.xldi29/%EB%AC%BC%EA%B2%B0%EA%B3%A0%EB%9E%98.png?type=w966",0,0));

                adapter.notifyDataSetChanged();
                Intent intent = new Intent(context, AddPostActivity.class);
                context.startActivity(intent);
            }
        });
    }

}