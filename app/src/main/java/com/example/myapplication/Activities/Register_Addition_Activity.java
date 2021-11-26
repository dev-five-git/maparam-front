package com.example.myapplication.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.myapplication.R;
import com.google.android.material.textfield.TextInputEditText;

public class Register_Addition_Activity extends AppCompatActivity {
    Spinner ageSpinner ;
    TextInputEditText tag_input;
    CheckBox agree_all;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register__addition_);

        ageSpinner = findViewById(R.id.age_spinner);
        tag_input = findViewById(R.id.tag_input);
        agree_all = findViewById(R.id.agree_all);

        String[] ageDatas = getResources().getStringArray(R.array.age_spinner_data);
        ArrayAdapter spinnerAdapter = new ArrayAdapter(this,R.layout.support_simple_spinner_dropdown_item,ageDatas);
        ageSpinner.setAdapter(spinnerAdapter);

    }

    public void weGoingToTheNextLevel(View view){
        if(tag_input.getText().toString().equals("")){
            Toast.makeText(this,R.string.require_tag_string,Toast.LENGTH_LONG).show();
            return;
        }
        if (!(agree_all.isChecked())) {
            Toast.makeText(this,R.string.please_agree_policy,Toast.LENGTH_LONG).show();
            return;
        }
    }
}