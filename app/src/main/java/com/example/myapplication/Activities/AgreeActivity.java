package com.example.myapplication.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Toast;

import com.example.myapplication.R;

public class AgreeActivity extends AppCompatActivity {
    CheckBox agree_1;
    CheckBox agree_2;
    CheckBox agree_3;
    CheckBox agree_all ;
    Button nextButton ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agree);

        agree_1 = findViewById(R.id.agree_1);
        agree_2 = findViewById(R.id.agree_2);
        agree_3 = findViewById(R.id.agree_3);
        agree_all = findViewById(R.id.agree_all);
        nextButton = findViewById(R.id.next_step);

        agree_all.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                agree_1.setChecked(b);
                agree_2.setChecked(b);
                agree_3.setChecked(b);
            }
        });

    }
    public void weGoingToTheNextLevel(View view){
        if (agree_1.isChecked() && agree_2.isChecked() && agree_3.isChecked()) {
            Intent intent = new Intent(this, Register_Basic_Activity.class);
            startActivity(intent);
            finish();
        }else {
            Toast.makeText(this,R.string.please_agree_all,Toast.LENGTH_LONG).show();
        }
    }
}