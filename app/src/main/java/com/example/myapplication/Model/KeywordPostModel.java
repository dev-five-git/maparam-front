package com.example.myapplication.Model;

public class KeywordPostModel {
    private String Name;
    private String age;
    private String date;
    private String post;
    private int comment_count;
    private int like_count;

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
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

    public int getComment_count() {
        return comment_count;
    }

    public void setComment_count(int comment_count) {
        this.comment_count = comment_count;
    }

    public int getLike_count() {
        return like_count;
    }

    public void setLike_count(int like_count) {
        this.like_count = like_count;
    }

    public KeywordPostModel(String name, String age, String date, String post, int comment_count, int like_count) {
        Name = name;
        this.age = age;
        this.date = date;
        this.post = post;
        this.comment_count = comment_count;
        this.like_count = like_count;
    }


}
