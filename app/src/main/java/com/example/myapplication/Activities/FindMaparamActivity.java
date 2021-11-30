package com.example.myapplication.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.myapplication.Adapter.MaparamAdapter;
import com.example.myapplication.Model.MaparamModel;
import com.example.myapplication.R;

import java.util.ArrayList;

public class FindMaparamActivity extends AppCompatActivity {
    ArrayList<MaparamModel> maparams;
    MaparamAdapter adapter;
    RecyclerView maparamGroupRecycler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_maparam);
        maparamGroupRecycler = findViewById(R.id.MaparamGroupRecycler);
        getData();
    }

    public void getData(){
        maparams = new ArrayList<>();
        for (int i =0;i<15;i++) {
            MaparamModel maparam = new MaparamModel("ㅇㄹ"+i,"강형민"+i,"werqwerqwer",i,i);
            maparams.add(maparam);
        }
        adapter = new MaparamAdapter(maparams,getApplicationContext());
        maparamGroupRecycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        maparamGroupRecycler.setAdapter(adapter);
    }
}