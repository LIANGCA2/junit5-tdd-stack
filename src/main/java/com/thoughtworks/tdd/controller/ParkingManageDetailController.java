package com.thoughtworks.tdd.controller;

import com.thoughtworks.tdd.ParkingBoy;
import com.thoughtworks.tdd.ParkingView;
import com.thoughtworks.tdd.Request;

public class ParkingManageDetailController implements Controllor {
    private ParkingBoy parkingBoy;
    private ParkingView parkingView;
    private Request request;
    private String path;
    public ParkingManageDetailController(ParkingBoy parkingBoy, ParkingView parkingView) {
    }
    @Override
    public void setPath(String path) {
        this.path = path;
    }
    @Override
    public void setRequest(Request request) {
        this.request = request;
    }

    @Override
    public String process() {
return null;
    }
}
