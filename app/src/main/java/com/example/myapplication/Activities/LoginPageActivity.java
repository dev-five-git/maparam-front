package com.example.myapplication.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.myapplication.Activities.AgreeActivity;
import com.example.myapplication.R;
import com.example.myapplication.Utilities.SF;
import com.example.myapplication.Utilities.UrlMaker;
import com.google.android.material.textfield.TextInputEditText;

import org.json.JSONObject;

import java.util.HashMap;

public class LoginPageActivity extends AppCompatActivity {
    private String TAG = "LoginPageActivity";
    TextInputEditText editText_id;
    TextInputEditText editText_pw;
    Button loginBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_page);
        loginBtn = findViewById(R.id.registerButton);
        editText_id = findViewById(R.id.editText_id);
        editText_pw = findViewById(R.id.editText_pw);
    }

    public void clickRegister(View view) {
        Intent intent = new Intent(this, AgreeActivity.class);
        startActivity(intent);
    }

    public void goMainPage(View view) {
        HashMap<String,String> hashMap = new HashMap<>();
        hashMap.put("id",editText_id.getText().toString());
        hashMap.put("pw",editText_pw.getText().toString());
        String url = new UrlMaker().UrlMake("/v1/login/login");
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST, url, new JSONObject(hashMap),
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        Log.e(TAG,response.toString());
                        SF sf = new SF(LoginPageActivity.this);
                        sf.createSF(editText_id.getText().toString());
                        HashMap<String,String> hashMap1 = new HashMap<>();
                        String dd = hashMap1.get(SF.KEY_USER_ID);
                        Log.e(TAG,dd);
                        Intent intent = new Intent(LoginPageActivity.this, MainActivity.class);
                        startActivity(intent);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e(TAG,error.toString());
                SF sf = new SF(LoginPageActivity.this);
                sf.createSF(editText_id.getText().toString());

                Intent intent = new Intent(LoginPageActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
        requestQueue.add(jsonObjectRequest);

    }
}