package com.example.myapplication.Model;

public class MaparamModel {
    private String groupName;
    private String groupHeadName;
    private String since;
    private int maxMemberNum;
    private int memberNum;

    public MaparamModel(String groupName, String groupHeadName, String since, int maxMemberNum, int memberNum) {
        this.groupName = groupName;
        this.groupHeadName = groupHeadName;
        this.since = since;
        this.maxMemberNum = maxMemberNum;
        this.memberNum = memberNum;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getGroupHeadName() {
        return groupHeadName;
    }

    public void setGroupHeadName(String groupHeadName) {
        this.groupHeadName = groupHeadName;
    }

    public String getSince() {
        return since;
    }

    public void setSince(String since) {
        this.since = since;
    }

    public int getMaxMemberNum() {
        return maxMemberNum;
    }

    public void setMaxMemberNum(int maxMemberNum) {
        this.maxMemberNum = maxMemberNum;
    }

    public int getMemberNum() {
        return memberNum;
    }

    public void setMemberNum(int memberNum) {
        this.memberNum = memberNum;
    }
}
