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

import com.example.myapplication.Activities.HomeCommentDetailActivity;
import com.example.myapplication.Adapter.AlarmAdapter;
import com.example.myapplication.Adapter.KeywordPostAdapter;
import com.example.myapplication.Model.AlarmModel;
import com.example.myapplication.Model.KeywordPostModel;
import com.example.myapplication.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link AlarmFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AlarmFragment extends Fragment {
    private static String TAG = "AlarmFragment";
    RecyclerView alarmRecycler;
    Button delete_all_button;
   private View view;
   private Context context;
   private ArrayList<AlarmModel> alarms;
   private AlarmAdapter adapter;
    public AlarmFragment() {

    }

    public static AlarmFragment newInstance(Context context) {
        AlarmFragment fragment = new AlarmFragment();
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
    public void onResume() {
        super.onResume();
        Log.e(TAG,"D");
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view= inflater.inflate(R.layout.fragment_alarm,container,false);
        alarmRecycler = view.findViewById(R.id.AlarmRecycler);
        delete_all_button = view.findViewById(R.id.delete_all_button);
        makingAdapter();
        makingDelteAllBtn();
        return view;
    }
    public void makingDelteAllBtn(){
        delete_all_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alarms.clear();
                adapter.notifyDataSetChanged();
            }
        });
    }
    public void makingAdapter(){
        alarms = new ArrayList<>();
        for (int i = 0 ; i<15;i++) {
            AlarmModel alarm = new AlarmModel(i+"",i+"",i);
            alarms.add(alarm);
        }
        adapter = new AlarmAdapter(alarms);
        alarmRecycler.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false));
        alarmRecycler.setAdapter(adapter);
    }
}