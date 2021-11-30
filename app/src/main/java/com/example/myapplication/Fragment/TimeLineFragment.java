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
import android.widget.ImageView;
import android.widget.TextView;

import com.example.myapplication.Activities.HomeCommentDetailActivity;
import com.example.myapplication.Activities.TimeLineMapActivity;
import com.example.myapplication.Adapter.TimeLinePostAdapter;
import com.example.myapplication.Model.TimeLinePostModel;
import com.example.myapplication.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link TimeLineFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class TimeLineFragment extends Fragment {
    private static String TAG = "TimeLineFragment";
    ImageView map_icon;
    TextView tagList;
    TextView moreText;
    RecyclerView timeLinePostRecycler;
    FloatingActionButton addPostBtn;
    TimeLinePostAdapter adapter;
    private ArrayList<TimeLinePostModel> timeLinePostModels;
    private View view;
    private Context context;
    public TimeLineFragment(Context context) {
        this.context = context;
    }
    public static TimeLineFragment newInstance(String param1, String parma2,Context context) {
        TimeLineFragment fragment = new TimeLineFragment(context);
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
    public void onResume() {
        super.onResume();
        Log.e(TAG,"D");
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view= inflater.inflate(R.layout.fragment_time_line,container,false);
        map_icon = view.findViewById(R.id.map_icon);
        tagList = view.findViewById(R.id.tagList);
        moreText = view.findViewById(R.id.more_text);
        timeLinePostRecycler = view.findViewById(R.id.TimeLinePostRecycler);
        addPostBtn = view.findViewById(R.id.addPostBtn);
        makingAdapter();
        clickMapBuilding();
        return view;
    }

    public void makingAdapter(){
        timeLinePostModels = new ArrayList<>();
        for (int i = 0;i<15;i++){
            ArrayList<String> tagList = new ArrayList<>();
            for (int j = 0;j<5;j++){
                tagList.add(i+"번째");
            }
            TimeLinePostModel model = new TimeLinePostModel("dd"+i,"123","sdFsd","qwer","",i,i,tagList);
            timeLinePostModels.add(model);
        }
        adapter = new TimeLinePostAdapter(timeLinePostModels,context, new TimeLinePostAdapter.ClickButton() {
            @Override
            public void clickComment() {
                getActivity().startActivity(new Intent(getActivity(), HomeCommentDetailActivity.class));
            }
        });
        timeLinePostRecycler.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false));
        timeLinePostRecycler.setAdapter(adapter);
    }
    public void clickMapBuilding(){
        map_icon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, TimeLineMapActivity.class);
                startActivity(intent);
            }
        });
    }
}