package com.example.myapplication.Model;

public class AlarmModel {
    private String title;
    private String content;
    private int time;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public AlarmModel(String title, String content, int time) {
        this.title = title;
        this.content = content;
        this.time = time;
    }
}
