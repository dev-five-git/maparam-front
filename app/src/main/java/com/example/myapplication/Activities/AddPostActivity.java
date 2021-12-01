package com.example.myapplication.Activities;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.myapplication.R;

public class AddPostActivity extends AppCompatActivity {
    Button addPostBtn;
    TextView asking;
    TextView addImageText;
    EditText type_post;
    ImageView image;
    ImageButton addImageBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_post);
        addPostBtn = findViewById(R.id.addPostBtn);
        asking = findViewById(R.id.asking);
        addImageText = findViewById(R.id.addImageText);
        type_post = findViewById(R.id.type_post);
        image = findViewById(R.id.image);
        addImageBtn = findViewById(R.id.addImageBtn);
        findImage();
        setAddPostBtn();

    }
    public void setAddPostBtn(){
        addPostBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
    }
    public void findImage(){
        addImageBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(intent,0);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 0) {
            if(resultCode == RESULT_OK){
                Glide.with(image).load(data.getData()).into(image);
                Log.e("kk",data.getData().toString());
                addImageText.setVisibility(View.INVISIBLE);
            }else{
                addImageText.setVisibility(View.VISIBLE);
            }
        }
    }
}