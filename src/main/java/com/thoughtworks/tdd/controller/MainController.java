package com.thoughtworks.tdd.controller;

import com.thoughtworks.tdd.ParkingView;
import com.thoughtworks.tdd.Request;

public class MainController implements Controllor{
    private ParkingView parkingView;
    private Request request;
    private String path;
    public MainController(ParkingView parkingView) {
        this.parkingView = parkingView;
    }

    @Override
    public void setRequest(Request request) {
        this.request = request;
    }

    @Override
    public String process() {
        if(request!=null ){
            parkingView.showErrorInputInfomation();
            request = null;
            return "forward:main";
        }
        parkingView.showBeginView();
        return "main";
    }

    @Override
    public void setPath(String path) {
        this.path = path;
    }
}
