package com.thoughtworks.tdd;

import java.util.ArrayList;

public class Entrance {


    public static void main(String[] args) {
        ArrayList<ParkingLot> parkingLotArrayList = new ArrayList<>();
        parkingLotArrayList.add(new ParkingLot(1));
        ParkingView parkingView = new ParkingView();
        ParkingLotController parkingLotController = new ParkingLotController(new ParkingBoy(parkingLotArrayList), parkingView);
        Router router = new Router(parkingLotController);
        InputCommand inputCommand = new ParkingLotInputCommand();
        Request request = new Request();
        String currentPage = "main";
        while (true) {
            String command = inputCommand.input();
            request.setCommand(command);
            currentPage = router.choosePage(currentPage, request);
        }

//        parkingLotController.start();
//        parkingLotController.operate(new ParkingLotInputCommand());
    }
}
