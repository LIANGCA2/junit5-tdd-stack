package com.thoughtworks.tdd.controller;

import com.thoughtworks.tdd.ParkingBoy;
import com.thoughtworks.tdd.ParkingView;
import com.thoughtworks.tdd.Request;

public class ParkingServiceDetailController implements Controllor {
    private ParkingBoy parkingBoy;
    private ParkingView parkingView;
    private Request request;
    private String path;
    public ParkingServiceDetailController(ParkingBoy parkingBoy, ParkingView parkingView) {
        this.parkingBoy = parkingBoy;
        this.parkingView = parkingView;
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
        if(request.getCommand().equals("1")){
            if(parkingBoy.checkParkingLotFullStatus()) {
                parkingView.showParkingLotFullStatus();
               return "forward:main";
            }else {
                parkingView.showInputCarLicensePlateNumber();
                return "main/1";
            }

        }else if(request.getCommand().equals("2")){
        return null;



        }else{
return null;
        }
    }
}
