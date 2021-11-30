package com.example.myapplication.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.myapplication.Adapter.KeywordPostCommentAdapter;
import com.example.myapplication.Adapter.MaparamPostCommentAdapter;
import com.example.myapplication.Dialog.HomePostSoleMenuDialog;
import com.example.myapplication.Model.KeywordPostCommentModel;
import com.example.myapplication.Model.MaparamGroupPostCommentModel;
import com.example.myapplication.R;

import java.util.ArrayList;

public class MaparamGroupCommentActivity extends AppCompatActivity {
    ArrayList<MaparamGroupPostCommentModel> models = new ArrayList<>();
    TextView nameText;
    TextView dateText;
    TextView commentCount;
    TextView likeCount;
    TextView post_text;
    EditText post_edit;
    EditText comment;
    ImageView imageView;
    ImageView profile;
    Button back;
    ImageButton uploadComment;
    ImageButton menu;
    RecyclerView recyclerView;
    LinearLayout shell;

    MaparamPostCommentAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maparam_group_comment_detail);
        nameText = findViewById(R.id.user_name);
        dateText = findViewById(R.id.date);
        commentCount = findViewById(R.id.comment_count);
        likeCount = findViewById(R.id.like_count);
        imageView = findViewById(R.id.image);
        profile = findViewById(R.id.profile);
        back = findViewById(R.id.backBtn);
        recyclerView = findViewById(R.id.keywordPostCommentRecycler);
        post_text = findViewById(R.id.post_text);
        post_edit = findViewById(R.id.post_edit);
        menu = findViewById(R.id.menu);
        shell = findViewById(R.id.menu_shell);
        comment = findViewById(R.id.comment);
        uploadComment = findViewById(R.id.comment_upload);

        buildingMenu();
        buildingComment();
        setUploadComment();
        getCommentData();
        adapter = new MaparamPostCommentAdapter(models,this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        recyclerView.setAdapter(adapter);

    }
    public void setUploadComment(){
        uploadComment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                models.add(new MaparamGroupPostCommentModel("키루룩","ㄴㅇㅇ",comment.getText().toString()));
                adapter.notifyDataSetChanged();
                comment.setText("");
            }
        });
    }
    private void buildingComment() {
        commentCount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(comment.getVisibility() == View.GONE){
                    comment.setVisibility(View.VISIBLE);
                }else{
                    comment.setVisibility(View.GONE);
                }
            }
        });
    }

    public void getCommentData(){
        for (int i = 0; i<5;i++) {
            MaparamGroupPostCommentModel model = new MaparamGroupPostCommentModel("ㄴㅇㄹ","ㄴㅇㅇ","ㄴㅁㅇㄹㄴㅇ");
            models.add(model);
        }

    }
    public void buildingMenu(){
        shell.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                HomePostSoleMenuDialog dialog = new HomePostSoleMenuDialog(getApplicationContext(), new HomePostSoleMenuDialog.ClickButton() {

                    public void clickEdit() {

                        if (post_text.getVisibility() == View.VISIBLE) {
                            post_text.setVisibility(View.GONE);
                            post_edit.setVisibility(View.VISIBLE);
                            post_edit.setText(post_text.getText().toString());
                        }else{
                            post_text.setVisibility(View.VISIBLE);
                            post_edit.setVisibility(View.GONE);
                            post_text.setText(post_edit.getText().toString());
                        }
                    }

                    @Override
                    public void clickDel() {
                        onBackPressed();
                    }
                });
                dialog.callFunction();

            }
        });
        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                HomePostSoleMenuDialog dialog = new HomePostSoleMenuDialog(getApplicationContext(), new HomePostSoleMenuDialog.ClickButton() {

                    public void clickEdit() {

                        if (post_text.getVisibility() == View.VISIBLE) {
                            post_text.setVisibility(View.GONE);
                            post_edit.setVisibility(View.VISIBLE);
                            post_edit.setText(post_text.getText().toString());
                        }else{
                            post_text.setVisibility(View.VISIBLE);
                            post_edit.setVisibility(View.GONE);
                            post_text.setText(post_edit.getText().toString());
                        }
                    }

                    @Override
                    public void clickDel() {
                        onBackPressed();
                    }
                });
                dialog.callFunction();

            }
        });

    }
    public void pressBack(View view) {
        onBackPressed();
    }
}