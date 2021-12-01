package com.example.myapplication.Fragment;

import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;

import com.example.myapplication.Activities.FindMaparamActivity;
import com.example.myapplication.Adapter.MaparamAdapter;
import com.example.myapplication.Dialog.MakeMyMaparamDialog;
import com.example.myapplication.Model.MaparamModel;
import com.example.myapplication.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CommunityFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CommunityFragment extends Fragment {
    private static String TAG = "CommunityFragment";
    RecyclerView maparamGroupRecycler;
    Button makeGroupBtn;
    ImageButton searchBtn;
    ArrayList<MaparamModel> maparams;
    MaparamAdapter adapter;
   private View view;
   private Context context;
    public CommunityFragment() {

    }
    public static CommunityFragment newInstance(Context context) {
        CommunityFragment fragment = new CommunityFragment();
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
        view= inflater.inflate(R.layout.fragment_community,container,false);
        maparamGroupRecycler = view.findViewById(R.id.MaparamGroupRecycler);
        makeGroupBtn = view.findViewById(R.id.makeGroup);
        searchBtn = view.findViewById(R.id.searchBtn);
        buildingMakeGroupBtn();
        buildingSearchBtn();
        getData();
        return view;
    }

    private void buildingMakeGroupBtn() {
        makeGroupBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MakeMyMaparamDialog dialog = new MakeMyMaparamDialog(context);
                dialog.callFunction();
            }
        });
    }
    private void buildingSearchBtn(){
        searchBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, FindMaparamActivity.class);
                startActivity(intent);
            }
        });
    }

    public void getData(){
        maparams = new ArrayList<>();
        for (int i =2;i<=4;i++) {
            MaparamModel maparam = new MaparamModel("독서를 좋아하는 사람들의 모임 (독좋사)","강형민","2021-10-15",i,i-1);
            maparams.add(maparam);
        }
        adapter = new MaparamAdapter(maparams,context);
        maparamGroupRecycler.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false));
        maparamGroupRecycler.setAdapter(adapter);
    }
}