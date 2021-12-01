package com.example.myapplication.Model;

public class UserInfoModel {
    public String introduce;
    public String name;
    public String profile_img;
    public  String id;
    public String pw;
    public String email;
    public int age;
    public String hashtag;
    public String created_at;

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProfile_img() {
        return profile_img;
    }

    public void setProfile_img(String profile_img) {
        this.profile_img = profile_img;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPw() {
        return pw;
    }

    public void setPw(String pw) {
        this.pw = pw;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getHashtag() {
        return hashtag;
    }

    public void setHashtag(String hashtag) {
        this.hashtag = hashtag;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public UserInfoModel(String introduce, String name, String profile_img, String id, String pw, String email, int age, String hashtag, String created_at) {
        this.introduce = introduce;
        this.name = name;
        this.profile_img = profile_img;
        this.id = id;
        this.pw = pw;
        this.email = email;
        this.age = age;
        this.hashtag = hashtag;
        this.created_at = created_at;
    }
}
