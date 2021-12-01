package com.example.myapplication.Dialog;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.myapplication.Activities.TimeLineCommentDetailActivity;
import com.example.myapplication.Adapter.KeywordAdapter;
import com.example.myapplication.Model.KeywordModel;
import com.example.myapplication.Model.MapTimeLineModel;
import com.example.myapplication.R;
import com.example.myapplication.Utilities.DateConverter;
import com.example.myapplication.Utilities.UrlMaker;

import java.util.ArrayList;
import java.util.Date;

public class MapMarkerClickDialog {
    Context context;
    Dialog dlg;
    ImageView profile;
    TextView nick;
    TextView before_time;
    TextView content;
    TextView comment_count;
    TextView like_count;
    MapTimeLineModel model;
    LinearLayout shell;
    public MapMarkerClickDialog(Context context,MapTimeLineModel model) {
        this.model = model;
        this.context = context;
    }
    public void callFunction() {
        dlg = new Dialog(context);
        dlg.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dlg.setContentView(R.layout.map_marker_click_dialog);
        dlg.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        dlg.setCanceledOnTouchOutside(true);
        dlg.setCancelable(true);
        dlg.show();

        profile = dlg.findViewById(R.id.profile);
        nick = dlg.findViewById(R.id.nick);
        before_time = dlg.findViewById(R.id.before_time);
        content = dlg.findViewById(R.id.content);
        comment_count = dlg.findViewById(R.id.comment_count);
        like_count = dlg.findViewById(R.id.like_count);
        shell = dlg.findViewById(R.id.shell);

        nick.setText(model.getWriter());
        before_time.setText(new DateConverter().convert(model.getCreated_at()));
        content.setText(model.getContent());
        like_count.setText(model.like+"");
        comment_count.setText(0+"");
        shell.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, TimeLineCommentDetailActivity.class);
                context.startActivity(intent);
            }
        });
    }
}
