package com.example.myapplication.Dialog;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.FrameLayout;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.myapplication.Adapter.KeywordAdapter;
import com.example.myapplication.Model.KeywordModel;
import com.example.myapplication.R;
import com.example.myapplication.Utilities.UrlMaker;

import java.util.ArrayList;

public class MaparamImInDialog {
    Context context;
    Dialog dlg;
    FrameLayout closeFrame;
    Button button;
    RecyclerView maparamRecycler;
    public MaparamImInDialog(Context context) {
        this.context = context;
    }
    public void callFunction() {
        dlg = new Dialog(context);


        dlg.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dlg.setContentView(R.layout.dialog_maparam_im_in);
        dlg.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        dlg.setCanceledOnTouchOutside(false);
        dlg.setCancelable(false);
        dlg.show();

        closeFrame = dlg.findViewById(R.id.buttonFrame);
        button = dlg.findViewById(R.id.button);
        maparamRecycler = dlg.findViewById(R.id.maparamRecycler);
        closeFrame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dlg.dismiss();
            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dlg.dismiss();
            }
        });


    }
    public void requestKeyword() {
        String url = new UrlMaker().UrlMake();
        RequestQueue requestQueue = Volley.newRequestQueue(context);
        StringRequest request = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.i("type", "error");
                    }
                });
        requestQueue.add(request);
    }

}
