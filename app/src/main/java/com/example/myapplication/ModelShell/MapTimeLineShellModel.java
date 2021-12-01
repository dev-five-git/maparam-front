package com.example.myapplication.ModelShell;

import com.example.myapplication.Model.MapTimeLineModel;

import java.util.ArrayList;

public class MapTimeLineShellModel {
    public ArrayList<MapTimeLineModel> board_list;

    public ArrayList<MapTimeLineModel> getBoard_list() {
        return board_list;
    }

    public void setBoard_list(ArrayList<MapTimeLineModel> board_list) {
        this.board_list = board_list;
    }

    public MapTimeLineShellModel(ArrayList<MapTimeLineModel> board_list) {
        this.board_list = board_list;
    }
}
