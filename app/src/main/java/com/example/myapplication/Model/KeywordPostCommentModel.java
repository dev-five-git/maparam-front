package com.example.myapplication.Model;

public class KeywordPostCommentModel {
    private String Name;
    private String date;
    private String post;

    public KeywordPostCommentModel(String name, String date, String post) {
        Name = name;
        this.date = date;
        this.post = post;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }
}
