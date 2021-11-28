package com.example.myapplication.Utilities;

public class UrlMaker {
    private String serverUrl = "https://9o45f5aasg.execute-api.ap-northeast-2.amazonaws.com/release/dummy/list";

    public UrlMaker(){}

    public String UrlMake() {return serverUrl;}

    public String UrlMake(String lastUrl){
        return serverUrl + lastUrl;
    }

}

