package com.example.myapplication.Model;

public class KeywordModel {
    private String date;
    private String keyword;

    public KeywordModel(String date, String keyword) {
        this.date = date;
        this.keyword = keyword;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }
}
