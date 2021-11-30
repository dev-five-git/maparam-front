package com.example.myapplication.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.Dialog.HomePostCommentMenuDialog;
import com.example.myapplication.Dialog.MaparamGroupCommentMenuDialog;
import com.example.myapplication.Model.KeywordPostCommentModel;
import com.example.myapplication.Model.MaparamGroupPostCommentModel;
import com.example.myapplication.R;

import java.util.ArrayList;

public class MaparamPostCommentAdapter extends RecyclerView.Adapter<MaparamPostCommentAdapter.MaparamPostCommentViewHolder> {
    ArrayList<MaparamGroupPostCommentModel> comments;
    Context context;
    public MaparamPostCommentAdapter(ArrayList<MaparamGroupPostCommentModel> comments, Context context) {
        this.comments = comments;
        this.context = context;
    }

    @NonNull
    @Override
    public MaparamPostCommentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        View view = LayoutInflater.from(context).inflate(R.layout.keyword_post_comment, parent, false);
        MaparamPostCommentViewHolder viewHolder = new MaparamPostCommentViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MaparamPostCommentViewHolder holder, int position) {
        MaparamGroupPostCommentModel post = comments.get(position);
        holder.user_name.setText(post.getName());
        holder.date.setText(post.getDate());
        holder.post_text.setText(post.getPost());
        holder.post_edit.setText(post.getPost());
        menuBuilding(holder,position);

    }
    public void menuBuilding(MaparamPostCommentViewHolder holder, int position){
        holder.menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MaparamGroupCommentMenuDialog dialog = new MaparamGroupCommentMenuDialog(context, holder, new MaparamGroupCommentMenuDialog.ClickButton() {


                    public void clickEdit(MaparamPostCommentViewHolder holder) {
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
                    public void clickDel(MaparamPostCommentViewHolder holder) {
                        comments.remove(position);
                        notifyDataSetChanged();
                    }
                });
                dialog.callFunction();

            }
        });
        holder.shell.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MaparamGroupCommentMenuDialog dialog = new MaparamGroupCommentMenuDialog(context, holder,  new MaparamGroupCommentMenuDialog.ClickButton() {


                    public void clickEdit(MaparamPostCommentViewHolder holder) {
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
                    public void clickDel(MaparamPostCommentViewHolder holder) {
                        comments.remove(position);
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
        return comments == null? 0 : comments.size();
    }
    @Override
    public void onDetachedFromRecyclerView(@NonNull RecyclerView recyclerView) {
        super.onDetachedFromRecyclerView(recyclerView);
    }

    @Override
    public boolean onFailedToRecycleView(@NonNull MaparamPostCommentViewHolder holder) {
        return super.onFailedToRecycleView(holder);
    }

    @Override
    public void onViewAttachedToWindow(@NonNull MaparamPostCommentViewHolder holder) {
        super.onViewAttachedToWindow(holder);
    }

    @Override
    public void onViewRecycled(@NonNull MaparamPostCommentViewHolder holder) {
        super.onViewRecycled(holder);
    }



    @Override
    public void onViewDetachedFromWindow(@NonNull MaparamPostCommentViewHolder holder) {
        super.onViewDetachedFromWindow(holder);
    }

    @Override
    public void onAttachedToRecyclerView(@NonNull RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    public class MaparamPostCommentViewHolder extends RecyclerView.ViewHolder{
        ImageView menu;
        ImageView profile;
        TextView user_name;
        TextView date;
        TextView post_text;
        EditText post_edit;
        LinearLayout shell;

        public MaparamPostCommentViewHolder(@NonNull View itemView) {
            super(itemView);
            menu = itemView.findViewById(R.id.menu);
            profile = itemView.findViewById(R.id.profile);
            user_name = itemView.findViewById(R.id.user_name);
            date = itemView.findViewById(R.id.date);
            post_text = itemView.findViewById(R.id.post_text);
            post_edit = itemView.findViewById(R.id.post_edit);
            shell = itemView.findViewById(R.id.menu_shell);

        }
    }

}
