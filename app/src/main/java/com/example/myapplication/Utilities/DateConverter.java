package com.example.myapplication.Utilities;

public class DateConverter {
    public DateConverter() {

    }
    public String convert(String date){
        String convertedDate = "";
        String[] tSplit = date.split("T");
        String[] hypenSplit = tSplit[0].split("-");
        String[] colonSplit = tSplit[1].split(":");
        convertedDate = hypenSplit[0]+"-"+hypenSplit[1]+"-" + hypenSplit[2]+" "
                + colonSplit[0]+":" + colonSplit[1];
        return convertedDate;
    }
}
