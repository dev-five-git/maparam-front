package com.example.myapplication.Utilities;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import java.util.HashMap;

public class SF {
    SharedPreferences usersDetailSession;
    SharedPreferences.Editor detailEditor;
    Context context;

    public static final String SESSION_REMEMMBERME = "rememberMe";


    public static final String KEY_USER_ID = "user_id";

    public SF(Context context) {
        this.context = context;
        usersDetailSession = context.getSharedPreferences(SESSION_REMEMMBERME, Context.MODE_PRIVATE);
        detailEditor = usersDetailSession.edit();
    }
    public HashMap<String, String> getUsersDetailFromSession() {
        HashMap<String, String> userData = new HashMap<String, String>();

        userData.put(KEY_USER_ID, usersDetailSession.getString(KEY_USER_ID, null));

        return userData;
    }
    public void clearDetailUserSession() {
        detailEditor.clear();
        detailEditor.commit();
    }
    public SharedPreferences getUsersDetailSession() {
        return usersDetailSession;
    }

    public SharedPreferences.Editor getDetailEditor() {
        return detailEditor;
    }

    public void createSF(String user_id) {
        detailEditor.putString(KEY_USER_ID, user_id);

        detailEditor.commit();
    }
}
