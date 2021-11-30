package com.example.myapplication.Dialog;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.Window;
import android.widget.Button;

import com.example.myapplication.Adapter.KeywordPostAdapter;
import com.example.myapplication.Adapter.TimeLinePostAdapter;
import com.example.myapplication.R;

public class TimeLinePostMenuDialog {
    Context context;
    Dialog dlg;
    ClickButton mylistener;
    TimeLinePostAdapter.TimeLinePostViewHolder holder;
    public interface ClickButton {
        void clickEdit(TimeLinePostAdapter.TimeLinePostViewHolder holder);
        void clickDel(TimeLinePostAdapter.TimeLinePostViewHolder holder);
    }

    public TimeLinePostMenuDialog(Context context, TimeLinePostAdapter.TimeLinePostViewHolder holder, ClickButton mylistener) {
        this.context = context;
        this.holder = holder;
        this.mylistener = mylistener;
    }
    public void callFunction() {
        dlg = new Dialog(context);


        dlg.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dlg.setContentView(R.layout.home_menu_dialog);
        dlg.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        dlg.show();

        Button editButton = (Button) dlg.findViewById(R.id.edit);
        Button deleteButton = (Button) dlg.findViewById(R.id.delete);

        editButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mylistener.clickEdit(holder);
                dlg.dismiss();
            }
        });
        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mylistener.clickDel(holder);
                dlg.dismiss();
            }
        });



    }
}
