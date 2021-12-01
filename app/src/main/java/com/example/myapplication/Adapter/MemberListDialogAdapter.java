package com.example.myapplication.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.Activities.MaparamGroupHeaderActivity;
import com.example.myapplication.R;

public class MemberListDialogAdapter extends RecyclerView.Adapter<MemberListDialogAdapter.MemberListViewHolder> {
    int num;
    int tier;
    public MemberListDialogAdapter(int num,int tier) {
        this.num = num;
        this.tier = tier;
    }

    @NonNull
    @Override
    public MemberListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        View view = LayoutInflater.from(context).inflate(R.layout.dialog_member_list_item, parent, false);
        MemberListViewHolder viewHolder = new MemberListViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MemberListViewHolder holder, int position) {
        if(tier == MaparamGroupHeaderActivity.TIER) {
            //holder.itemView.out;
            holder.outOfGroup.setVisibility(View.VISIBLE);
        }else{
            holder.outOfGroup.setVisibility(View.GONE);
        }
    }
    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }
    @Override
    public int getItemCount() {
        return num;
    }
    @Override
    public void onDetachedFromRecyclerView(@NonNull RecyclerView recyclerView) {
        super.onDetachedFromRecyclerView(recyclerView);
    }

    @Override
    public boolean onFailedToRecycleView(@NonNull MemberListViewHolder holder) {
        return super.onFailedToRecycleView(holder);
    }

    @Override
    public void onViewAttachedToWindow(@NonNull MemberListViewHolder holder) {
        super.onViewAttachedToWindow(holder);
    }

    @Override
    public void onViewRecycled(@NonNull MemberListViewHolder holder) {
        super.onViewRecycled(holder);
    }



    @Override
    public void onViewDetachedFromWindow(@NonNull MemberListViewHolder holder) {
        super.onViewDetachedFromWindow(holder);
    }

    @Override
    public void onAttachedToRecyclerView(@NonNull RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }



    public class MemberListViewHolder extends RecyclerView.ViewHolder{
        Button outOfGroup;
        public MemberListViewHolder(@NonNull View itemView) {
            super(itemView);
            outOfGroup = itemView.findViewById(R.id.outOfGroup);
        }
    }
}
