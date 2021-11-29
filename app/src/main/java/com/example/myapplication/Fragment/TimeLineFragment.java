package com.example.myapplication.Fragment;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.myapplication.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link TimeLineFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class TimeLineFragment extends Fragment {

    ImageView map_icon;
    TextView tagList;
    TextView moreText;
    RecyclerView timeLinePostRecycler;
    FloatingActionButton addPostBtn;

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

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view= inflater.inflate(R.layout.fragment_time_line,container,false);
        map_icon = view.findViewById(R.id.map_icon);
        tagList = view.findViewById(R.id.tagList);
        moreText = view.findViewById(R.id.more_text);
        timeLinePostRecycler = view.findViewById(R.id.TimeLinePostRecycler);
        addPostBtn = view.findViewById(R.id.addPostBtn);

        for (int i = 0;i<15;i++){

        }
        return view;
    }
}