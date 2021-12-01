package com.example.myapplication.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.Model.KeywordModel;
import com.example.myapplication.R;

import java.util.ArrayList;

public class ProfileBelongGroupAdapter extends RecyclerView.Adapter<ProfileBelongGroupAdapter.ProfileBelongGroupViewHolder> {
    ArrayList<KeywordModel> keywords;
    Boolean isMe;

    public ProfileBelongGroupAdapter(Boolean  isMe) {
        this.isMe = isMe;
    }

    @NonNull
    @Override
    public ProfileBelongGroupViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        View view = LayoutInflater.from(context).inflate(R.layout.profile_belong_group_item, parent, false);
        ProfileBelongGroupViewHolder viewHolder = new ProfileBelongGroupViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ProfileBelongGroupViewHolder holder, int position) {
        if (isMe) {
            holder.join_requestBtn.setVisibility(View.GONE);
        }else{
            holder.join_requestBtn.setVisibility(View.VISIBLE);
        }

    }
    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }
    @Override
    public int getItemCount() {
        return 3;
    }
    @Override
    public void onDetachedFromRecyclerView(@NonNull RecyclerView recyclerView) {
        super.onDetachedFromRecyclerView(recyclerView);
    }

    @Override
    public boolean onFailedToRecycleView(@NonNull ProfileBelongGroupViewHolder holder) {
        return super.onFailedToRecycleView(holder);
    }

    @Override
    public void onViewAttachedToWindow(@NonNull ProfileBelongGroupViewHolder holder) {
        super.onViewAttachedToWindow(holder);
    }

    @Override
    public void onViewRecycled(@NonNull ProfileBelongGroupViewHolder holder) {
        super.onViewRecycled(holder);
    }



    @Override
    public void onViewDetachedFromWindow(@NonNull ProfileBelongGroupViewHolder holder) {
        super.onViewDetachedFromWindow(holder);
    }

    @Override
    public void onAttachedToRecyclerView(@NonNull RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }



    public class ProfileBelongGroupViewHolder extends RecyclerView.ViewHolder{
        Button join_requestBtn;
        Button edit_profile;
        public ProfileBelongGroupViewHolder(@NonNull View itemView) {
            super(itemView);
            join_requestBtn = itemView.findViewById(R.id.join_requestBtn);
            edit_profile = itemView.findViewById(R.id.edit_profile);

        }
    }
}
