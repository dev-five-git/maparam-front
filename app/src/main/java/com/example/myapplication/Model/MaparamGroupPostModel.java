package com.example.myapplication.Model;

import java.util.ArrayList;

public class MaparamGroupPostModel {
    private String Name;
    private String age;
    private String date;
    private String post;
    private String image;
    private int comment_count;
    private int like_count;
    ArrayList<MaparamGroupPostModel> commentData;

    public MaparamGroupPostModel(String name, String age, String date, String post, String image, int comment_count, int like_count) {
        Name = name;
        this.age = age;
        this.date = date;
        this.post = post;
        this.image = image;
        this.comment_count = comment_count;
        this.like_count = like_count;
        this.commentData = new ArrayList<>();
    }

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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
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

    public ArrayList<MaparamGroupPostModel> getCommentData() {
        return commentData;
    }

    public void setCommentData(ArrayList<MaparamGroupPostModel> commentData) {
        this.commentData = commentData;
    }
}
