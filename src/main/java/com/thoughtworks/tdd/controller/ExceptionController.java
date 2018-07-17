package com.thoughtworks.tdd.controller;

import com.thoughtworks.tdd.ParkingView;
import com.thoughtworks.tdd.Request;

public class ExceptionController implements Controllor {
    private ParkingView parkingView;
    private Request request;
    public ExceptionController(ParkingView parkingView) {
    }

    @Override
    public void setRequest(Request request) {
        this.request = request;
    }

    @Override
    public String process() {
        return null;
    }

    @Override
    public void setPath(String path) {

    }

    public void process(Exception e){

    }
}
