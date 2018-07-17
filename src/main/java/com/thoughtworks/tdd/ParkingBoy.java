package com.thoughtworks.tdd;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ParkingBoy {
    private int parkingNumber = 0;

    private ArrayList<ParkingLot> parkingLotArrayList = new ArrayList<>();

    public ArrayList<ParkingLot> getParkingLotArrayList() {
        return parkingLotArrayList;
    }

    public void setParkingLotArrayList(ArrayList<ParkingLot> parkingLotArrayList) {
        this.parkingLotArrayList = parkingLotArrayList;
    }

    public ParkingBoy() {
    }

    public ParkingBoy(ArrayList<ParkingLot> parkingLotArrayList) {
        this.parkingLotArrayList = parkingLotArrayList;
    }
    public String getParkingNumber() {
        this.parkingNumber++;
        return String.format("%03d", this.parkingNumber);
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

    public Result deleteParkingLotById(String id) {
        Result result = new Result();
        List<ParkingLot> parkingLotList = parkingLotArrayList.stream().filter(parkingLot1 -> parkingLot1.getId().equals(id)).collect(Collectors.toList());
        if(parkingLotList.size()==0){
            result.setReason("此停车场不存在！");
            result.setStatus(false);
        }else if(parkingLotList.get(0).getParkCarMap().size()!=0){
            result.setReason("此停车场中，依然停有汽车，无法删除！");
            result.setStatus(false);
        }else{
            result.setStatus(true);
            parkingLotArrayList.remove(parkingLotList.get(0));
        }
        return result;
    }
}