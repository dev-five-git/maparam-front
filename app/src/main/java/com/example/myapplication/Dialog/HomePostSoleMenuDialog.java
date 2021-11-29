package com.example.myapplication.Dialog;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.Window;
import android.widget.Button;

import com.example.myapplication.Adapter.KeywordPostCommentAdapter;
import com.example.myapplication.R;

public class HomePostSoleMenuDialog {
    Context context;
    Dialog dlg;
    ClickButton mylistener;
    public interface ClickButton {
        void clickEdit();
        void clickDel();
    }

    public HomePostSoleMenuDialog(Context context,  ClickButton mylistener) {
        this.context = context;
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
                mylistener.clickEdit();
                dlg.dismiss();
            }
        });
        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mylistener.clickDel();
                dlg.dismiss();
            }
        });



    }
}
