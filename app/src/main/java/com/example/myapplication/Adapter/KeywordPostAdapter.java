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

import com.bumptech.glide.Glide;
import com.example.myapplication.Dialog.HomePostMenuDialog;
import com.example.myapplication.Model.KeywordPostModel;
import com.example.myapplication.R;

import java.util.ArrayList;

public class KeywordPostAdapter extends RecyclerView.Adapter<KeywordPostAdapter.KeywordPostViewHolder> implements HomePostMenuDialog.ClickButton {
    ArrayList<KeywordPostModel> posts;
    Context context;
    ClickButton clickButton;
    Boolean commentShow = false;
    public interface ClickButton {
        void clickComment();
    }
    public KeywordPostAdapter(ArrayList<KeywordPostModel> kewords,Context context,ClickButton clickButton) {
        this.posts = kewords;
        this.context = context;
        this.commentShow = false;
        this.clickButton = clickButton;
    }

    @NonNull
    @Override
    public KeywordPostViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        View view = LayoutInflater.from(context).inflate(R.layout.keyword_post, parent, false);
        KeywordPostViewHolder couponViewHolder = new KeywordPostViewHolder(view);
        return couponViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull KeywordPostViewHolder holder, int position) {
        KeywordPostModel post = posts.get(position);
        holder.user_name.setText(post.getName());
        holder.age.setText(post.getAge());
        holder.date.setText(post.getDate());
        holder.post_text.setText(post.getPost());
        holder.post_edit.setText(post.getPost());
        holder.comment_count.setText(""+post.getComment_count());
        holder.like_count.setText(""+post.getLike_count());
        menuBuilding(holder,position);
        commentBuilding(holder,position);
        if (post.getImage().length() >0){
            holder.imageView.setVisibility(View.VISIBLE);
            Glide.with(context).load(post.getImage()).into(holder.imageView);
        }else{
            holder.imageView.setVisibility(View.GONE);
        }
    }
    public void commentBuilding(KeywordPostViewHolder holder, int position) {
        holder.comment_count.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                if (!commentShow) {
//                    holder.comment.setVisibility(View.VISIBLE);
//                }else {
//                    holder.comment.setVisibility(View.GONE);
//                }
//                commentShow = !commentShow;
                clickButton.clickComment();

            }
        });
    }
    public void menuBuilding(KeywordPostViewHolder holder, int position){
        holder.menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                HomePostMenuDialog dialog = new HomePostMenuDialog(context, holder, new HomePostMenuDialog.ClickButton() {
                    @Override
                    public void clickEdit(KeywordPostViewHolder holder) {
                        if (holder.post_text.getVisibility() == View.VISIBLE) {
                            holder.post_text.setVisibility(View.GONE);
                            holder.post_edit.setVisibility(View.VISIBLE);
                            holder.post_edit.setText(holder.post_text.getText().toString());
                        }else{
                            holder.post_text.setVisibility(View.VISIBLE);
                            holder.post_edit.setVisibility(View.GONE);
                            holder.post_text.setText(holder.post_edit.getText().toString());
                        }
                    }

                    @Override
                    public void clickDel(KeywordPostViewHolder holder) {
                        posts.remove(position);
                        notifyDataSetChanged();
                    }
                });
                dialog.callFunction();

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
    public boolean onFailedToRecycleView(@NonNull KeywordPostAdapter.KeywordPostViewHolder holder) {
        return super.onFailedToRecycleView(holder);
    }

    @Override
    public void onViewAttachedToWindow(@NonNull KeywordPostAdapter.KeywordPostViewHolder holder) {
        super.onViewAttachedToWindow(holder);
    }

    @Override
    public void onViewRecycled(@NonNull KeywordPostAdapter.KeywordPostViewHolder holder) {
        super.onViewRecycled(holder);
    }



    @Override
    public void onViewDetachedFromWindow(@NonNull KeywordPostAdapter.KeywordPostViewHolder holder) {
        super.onViewDetachedFromWindow(holder);
    }

    @Override
    public void onAttachedToRecyclerView(@NonNull RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    @Override
    public void clickEdit(KeywordPostViewHolder holder) {
        if (holder.post_text.getVisibility() == View.VISIBLE) {
            holder.post_text.setVisibility(View.GONE);
            holder.post_edit.setVisibility(View.VISIBLE);
            holder.post_edit.setText(holder.post_text.getText().toString());
        }else{
            holder.post_text.setVisibility(View.VISIBLE);
            holder.post_edit.setVisibility(View.GONE);
            holder.post_text.setText(holder.post_edit.getText().toString());
        }
    }

    @Override
    public void clickDel(KeywordPostViewHolder holder) {

    }


    public class KeywordPostViewHolder extends RecyclerView.ViewHolder{
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

        public KeywordPostViewHolder(@NonNull View itemView) {
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
