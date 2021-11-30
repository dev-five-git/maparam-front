package com.example.myapplication.Fragment;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.myapplication.Adapter.MaparamAdapter;
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
    ArrayList<MaparamModel> maparams;
    MaparamAdapter adapter;
   private View view;
   private Context context;
    public CommunityFragment(Context context) {
        this.context = context;
    }
    public static CommunityFragment newInstance(String param1, String param2,Context context) {
        CommunityFragment fragment = new CommunityFragment(context);
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
        buildingMakeGroupBtn();
        getData();
        return view;
    }

    private void buildingMakeGroupBtn() {
        
    }

    public void getData(){
        maparams = new ArrayList<>();
        for (int i =0;i<15;i++) {
            MaparamModel maparam = new MaparamModel("ㅇㄹ"+i,"강형민"+i,"werqwerqwer",i,i);
            maparams.add(maparam);
        }
        adapter = new MaparamAdapter(maparams);
        maparamGroupRecycler.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false));
        maparamGroupRecycler.setAdapter(adapter);
    }
}