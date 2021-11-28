package com.example.myapplication.Fragment;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.myapplication.Adapter.KeywordAdapter;
import com.example.myapplication.Adapter.KeywordPostAdapter;
import com.example.myapplication.Dialog.KeywordDialog;
import com.example.myapplication.Model.KeywordModel;
import com.example.myapplication.Model.KeywordPostModel;
import com.example.myapplication.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeFragment extends Fragment {
    private View view;
    private Context context;
    ArrayList<KeywordPostModel> posts = new ArrayList<>();
    Button keywordButton;
    RecyclerView kewordPostRecycler;
    public HomeFragment(Context context) {
        this.context = context;
    }
    public static HomeFragment newInstance(String param1, String param2,Context context) {
        HomeFragment fragment = new HomeFragment(context);
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
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view= inflater.inflate(R.layout.fragment_home,container,false);
        keywordButton = view.findViewById(R.id.todayKeyword);
        kewordPostRecycler = view.findViewById(R.id.keywordPostRecycler);
        keywordButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pressKeyword();
            }
        });
        posts = new ArrayList<>();
        for (int i = 0 ; i<15;i++) {
            KeywordPostModel post = new KeywordPostModel(i+"",i+"",i+"",i+"",i,i);
            posts.add(post);
        }
        KeywordPostAdapter adapter = new KeywordPostAdapter(posts);
        kewordPostRecycler.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false));
        kewordPostRecycler.setAdapter(adapter);

        return view;
    }
    public void pressKeyword() {
        KeywordDialog dialog = new KeywordDialog(context);
        dialog.callFunction();
    }
}