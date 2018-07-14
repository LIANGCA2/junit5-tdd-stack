package com.thoughtworks.tdd;

import java.util.ArrayList;

public class ParkingBoy {
    private ArrayList<ParkingLot> parkingLotArrayList = new ArrayList<>();

    public ParkingBoy() {
    }

    public ParkingBoy(ArrayList<ParkingLot> parkingLotArrayList) {
        this.parkingLotArrayList = parkingLotArrayList;
    }

    public void addParkingLot(ParkingLot parkingLot) {
        parkingLotArrayList.add(parkingLot);
    }

    public Receipt park(Car theCar) {
        ParkingLot parkingLot = findNotFullParkingLot();
        if (parkingLot != null) {
            return parkingLot.park(theCar);
        } else {
            throw new ParkinglotException();
        }
    }

    public ParkingLot findParkingLotByReceipt(Receipt receipt) {
        for (int i = 0; i < parkingLotArrayList.size(); i++) {
            if (parkingLotArrayList.get(i).findCarByReceipt(receipt)) {
                return parkingLotArrayList.get(i);
            }
        }
        return null;
    }

    public Car unPark(Receipt receipt) {
        ParkingLot parkingLot = findParkingLotByReceipt(receipt);
        if (parkingLot != null) {
            return parkingLot.unPark(receipt);
        }
        return null;
    }

    public Boolean checkParkingLotFullStatus() {
        if (findNotFullParkingLot() == null) {
            return true;
        } else {
            return false;
        }
    }

    public ParkingLot findNotFullParkingLot() {
        for (int i = 0; i < parkingLotArrayList.size(); i++) {
            if (!parkingLotArrayList.get(i).isFull()) {
                return parkingLotArrayList.get(i);
            }
        }
        return null;
    }

    public Result inputOperate(String input) {

        return  checkInput(input);
    }

    public Result checkInput(String input) {
        int choice = 0;
        try {
            choice = Integer.parseInt(input);
        } catch (Exception e) {
            System.out.println("非法指令，程序终止");
           throw  new ParkinglotException();
        }
        return enterDiffBranchByDiffChoice(choice);
    }

    public Result enterDiffBranchByDiffChoice(int choice) {
        //Result result = new Result();
        if (!(choice == 1 || choice == 2)) {
            return new Result("非法指令，请查证后再输", choice);
        } else {
            if (choice == 1) {
                return new Result("停车", choice,checkParkingLotFullStatus());
            } else {
                return new Result("取车", choice);
            }
        }
    }


    public Result operateCarByInput(String input, Result result) {
        if(result.getChoice()==1){
            Car car = new Car(input);
           return new Result(park(car).getId(),result.getChoice());
        }else{
            Car car = unPark(new Receipt(input));
            if(car != null){
                return new Result(car.getLicensePlateNumber(),result.getChoice());
            }else{
                return new Result("",result.getChoice());
            }
        }
    }
}