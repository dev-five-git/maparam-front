package com.example.myapplication.Model;

public class MapTimeLineModel {
    public int index;
    public String writer;
    public String image;
    public int like;
    public String created_at;
    public double location_latitude;
    public double location_longitude;
    public String content;
    public int hashtag;
    public int updated_at;
    public UserInfoModel user;

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getLike() {
        return like;
    }

    public void setLike(int like) {
        this.like = like;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public double getLocation_latitude() {
        return location_latitude;
    }

    public void setLocation_latitude(double location_latitude) {
        this.location_latitude = location_latitude;
    }

    public double getLocation_longitude() {
        return location_longitude;
    }

    public void setLocation_longitude(double location_longitude) {
        this.location_longitude = location_longitude;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getHashtag() {
        return hashtag;
    }

    public void setHashtag(int hashtag) {
        this.hashtag = hashtag;
    }

    public int getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(int updated_at) {
        this.updated_at = updated_at;
    }

    public UserInfoModel getUser() {
        return user;
    }

    public void setUser(UserInfoModel user) {
        this.user = user;
    }

    public MapTimeLineModel(int index, String writer, String image, int like, String created_at, double location_latitude, double location_longitude, String content, int hashtag, int updated_at, UserInfoModel user) {
        this.index = index;
        this.writer = writer;
        this.image = image;
        this.like = like;
        this.created_at = created_at;
        this.location_latitude = location_latitude;
        this.location_longitude = location_longitude;
        this.content = content;
        this.hashtag = hashtag;
        this.updated_at = updated_at;
        this.user = user;
    }
}
