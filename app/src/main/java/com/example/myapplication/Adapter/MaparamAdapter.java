package com.example.myapplication.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.Model.AlarmModel;
import com.example.myapplication.Model.MaparamModel;
import com.example.myapplication.R;

import java.util.ArrayList;

public class MaparamAdapter extends RecyclerView.Adapter<MaparamAdapter.MaparmViewHolder> {
    ArrayList<MaparamModel> maparams;

    public MaparamAdapter(ArrayList<MaparamModel> maparams) {
        this.maparams = maparams;
    }

    @NonNull
    @Override
    public MaparmViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        View view = LayoutInflater.from(context).inflate(R.layout.maparam_list, parent, false);
        MaparmViewHolder couponViewHolder = new MaparmViewHolder(view);
        return couponViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MaparmViewHolder holder, int position) {
        MaparamModel maparam = maparams.get(position);
        holder.group_name.setText(maparam.getGroupName());
        holder.description.setText("인원수 "+maparam.getMemberNum()+"/"+maparam.getMaxMemberNum()+", 파람장:"+maparam.getGroupHeadName()+", 생성일자:"+maparam.getSince());
    }
    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }
    @Override
    public int getItemCount() {
        return maparams == null? 0 : maparams.size();
    }
    @Override
    public void onDetachedFromRecyclerView(@NonNull RecyclerView recyclerView) {
        super.onDetachedFromRecyclerView(recyclerView);
    }

    @Override
    public boolean onFailedToRecycleView(@NonNull MaparmViewHolder holder) {
        return super.onFailedToRecycleView(holder);
    }

    @Override
    public void onViewAttachedToWindow(@NonNull MaparmViewHolder holder) {
        super.onViewAttachedToWindow(holder);
    }

    @Override
    public void onViewRecycled(@NonNull MaparmViewHolder holder) {
        super.onViewRecycled(holder);
    }



    @Override
    public void onViewDetachedFromWindow(@NonNull MaparmViewHolder holder) {
        super.onViewDetachedFromWindow(holder);
    }

    @Override
    public void onAttachedToRecyclerView(@NonNull RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }



    public class MaparmViewHolder extends RecyclerView.ViewHolder{
       TextView group_name;
       TextView description;
        public MaparmViewHolder(@NonNull View itemView) {
            super(itemView);
            group_name = itemView.findViewById(R.id.group_name);
            description = itemView.findViewById(R.id.description);
        }
    }
}
