package com.thoughtworks.tdd;

import java.util.ArrayList;

public class Entrance {


    public static void main(String[] args){
        ArrayList<ParkingLot> parkingLotArrayList = new ArrayList<>();
        parkingLotArrayList.add(new ParkingLot(1));
        parkingLotArrayList.add(new ParkingLot(3));
        ParkingLotController parkingLotController = new ParkingLotController(new ParkingBoy(parkingLotArrayList),new ParkingLotInputCommand(),new ParkingView());
        parkingLotController.start();
        parkingLotController.operate(new ParkingLotInputCommand());
    }
}
