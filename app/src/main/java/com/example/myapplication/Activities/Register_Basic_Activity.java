package com.example.myapplication.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.myapplication.R;
import com.google.android.material.textfield.TextInputEditText;

import java.util.ArrayList;

public class Register_Basic_Activity extends AppCompatActivity {
    Spinner spinner ;
    TextInputEditText id_input;
    TextInputEditText nick_input;
    TextInputEditText pw_input;
    TextInputEditText pw_verify_input;
    TextInputEditText email_input;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register__basic_);
        spinner = findViewById(R.id.email_spinner);
        id_input = findViewById(R.id.id_input);
        nick_input = findViewById(R.id.nick_input);
        pw_input = findViewById(R.id.pw_input);
        pw_verify_input = findViewById(R.id.pw_verify_input);
        email_input = findViewById(R.id.email_input);

        String[] emailDatas = getResources().getStringArray(R.array.email_spinner_data);
        ArrayAdapter spinnerAdapter = new ArrayAdapter(this,R.layout.support_simple_spinner_dropdown_item,emailDatas);
        spinner.setAdapter(spinnerAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
               ; //nothing to do
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
               ; //nothing to do
            }
        });
    }
    public void weGoingToTheNextLevel(View view){
        if(id_input.getText().toString().equals("")){
            Toast.makeText(this,R.string.id_reject,Toast.LENGTH_LONG).show();
            return;
        }
        if(nick_input.getText().toString().equals("")){
            Toast.makeText(this,R.string.id_reject,Toast.LENGTH_LONG).show();
            return;
        }if(pw_input.getText().toString().equals("")){
            Toast.makeText(this,R.string.id_reject,Toast.LENGTH_LONG).show();
            return;
        }if(pw_verify_input.getText().toString().equals("")){
            Toast.makeText(this,R.string.id_reject,Toast.LENGTH_LONG).show();
            return;
        }if(email_input.getText().toString().equals("")){
            Toast.makeText(this,R.string.id_reject,Toast.LENGTH_LONG).show();
            return;
        }
        if(spinner.getSelectedItem().toString().length() == 0) {
            Toast.makeText(this,R.string.email_reject,Toast.LENGTH_LONG).show();
            return;
        }
        Intent intent = new Intent(this,Register_Addition_Activity.class);
        startActivity(intent);
        finish();

    }
}