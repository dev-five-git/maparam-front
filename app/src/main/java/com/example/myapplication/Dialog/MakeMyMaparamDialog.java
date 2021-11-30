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

public class MakeMyMaparamDialog {
    Context context;
    Dialog dlg;
    FrameLayout closeFrame;
    Button button;
    Button createMaparam;
    RecyclerView keywordRecyclerView;
    ArrayList<KeywordModel> keywords = new ArrayList<>();
    public MakeMyMaparamDialog(Context context) {
        this.context = context;
    }
    public void callFunction() {
        dlg = new Dialog(context);


        dlg.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dlg.setContentView(R.layout.make_maparam_dialog);
        dlg.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        dlg.setCanceledOnTouchOutside(false);
        dlg.setCancelable(false);
        dlg.show();

        closeFrame = dlg.findViewById(R.id.buttonFrame);
        button = dlg.findViewById(R.id.button);
        createMaparam = dlg.findViewById(R.id.createMaparam);

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
        createMaparam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dlg.dismiss();
            }
        });
    }
}
