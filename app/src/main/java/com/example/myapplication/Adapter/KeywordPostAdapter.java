package com.example.myapplication.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.Model.KeywordPostModel;
import com.example.myapplication.R;

import java.util.ArrayList;

public class KeywordPostAdapter extends RecyclerView.Adapter<KeywordPostAdapter.KeywordViewHolder> {
    ArrayList<KeywordPostModel> posts;

    public KeywordPostAdapter(ArrayList<KeywordPostModel> kewords) {
        this.posts = kewords;
    }

    @NonNull
    @Override
    public KeywordViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        View view = LayoutInflater.from(context).inflate(R.layout.keyword_post, parent, false);
        KeywordViewHolder couponViewHolder = new KeywordViewHolder(view);
        return couponViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull KeywordViewHolder holder, int position) {
        KeywordPostModel post = posts.get(position);
        holder.user_name.setText(post.getName());
        holder.age.setText(post.getAge());
        holder.date.setText(post.getDate());
        holder.post_text.setText(post.getPost());
        holder.post_edit.setText(post.getPost());
        holder.comment_count.setText(""+post.getComment_count());
        holder.like_count.setText(""+post.getLike_count());
        holder.menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (holder.post_text.getVisibility() == View.VISIBLE) {
                    holder.post_text.setVisibility(View.INVISIBLE);
                    holder.post_edit.setVisibility(View.VISIBLE);
                }else{
                    holder.post_text.setVisibility(View.VISIBLE);
                    holder.post_edit.setVisibility(View.INVISIBLE);
                }
            }
        });

    }
    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }
    @Override
    public int getItemCount() {
        return posts == null? 0 : posts.size();
    }
    @Override
    public void onDetachedFromRecyclerView(@NonNull RecyclerView recyclerView) {
        super.onDetachedFromRecyclerView(recyclerView);
    }

    @Override
    public boolean onFailedToRecycleView(@NonNull KeywordPostAdapter.KeywordViewHolder holder) {
        return super.onFailedToRecycleView(holder);
    }

    @Override
    public void onViewAttachedToWindow(@NonNull KeywordPostAdapter.KeywordViewHolder holder) {
        super.onViewAttachedToWindow(holder);
    }

    @Override
    public void onViewRecycled(@NonNull KeywordPostAdapter.KeywordViewHolder holder) {
        super.onViewRecycled(holder);
    }



    @Override
    public void onViewDetachedFromWindow(@NonNull KeywordPostAdapter.KeywordViewHolder holder) {
        super.onViewDetachedFromWindow(holder);
    }

    @Override
    public void onAttachedToRecyclerView(@NonNull RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }



    public class KeywordViewHolder extends RecyclerView.ViewHolder{
        ImageView menu;
        ImageView profile;
        TextView user_name;
        TextView age;
        TextView date;
        TextView post_text;
        EditText post_edit;
        TextView comment_count;
        TextView like_count;
        ImageView imageView;

        public KeywordViewHolder(@NonNull View itemView) {
            super(itemView);
            menu = itemView.findViewById(R.id.menu);
            profile = itemView.findViewById(R.id.profile);
            user_name = itemView.findViewById(R.id.user_name);
            age = itemView.findViewById(R.id.age);
            date = itemView.findViewById(R.id.date);
            post_text = itemView.findViewById(R.id.post_text);
            post_edit = itemView.findViewById(R.id.post_edit);
            comment_count = itemView.findViewById(R.id.comment_count);
            like_count = itemView.findViewById(R.id.like_count);
            imageView = itemView.findViewById(R.id.image);
        }
    }
}
