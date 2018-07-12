package com.thoughtworks.tdd;

import java.util.ArrayList;

public class ParkingBoy {
    private ArrayList<ParkingLot> parkingLotArrayList= new ArrayList<>();
    public void addParkingLot(ParkingLot parkingLot) {
        parkingLotArrayList.add(parkingLot);
    }

    public Receipt park(Car theCar) {
        for(int i = 0;i<parkingLotArrayList.size();i++){
            if(!parkingLotArrayList.get(i).isFull()||(parkingLotArrayList.get(i).isFull()&&i == parkingLotArrayList.size()-1))
            {
                return parkingLotArrayList.get(i).park(theCar);
            }
        }
        return null;
    }

    public ParkingLot findParkingLotByReceipt(Receipt receipt) {
        for(int i = 0;i<parkingLotArrayList.size();i++){
          if(parkingLotArrayList.get(i).findCarByReceipt(receipt)){
              return parkingLotArrayList.get(i);
          }
        }
        return null;
    }

    public Car unPark(Receipt receipt) {
        ParkingLot parkingLot = findParkingLotByReceipt(receipt);
        if(parkingLot != null) {
            return findParkingLotByReceipt(receipt).unPark(receipt);
        }
        return null;
    }
}
