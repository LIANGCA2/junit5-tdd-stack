package com.thoughtworks.tdd;

import java.util.HashMap;

public class ParkingLot {
    private int size;
    private HashMap<Receipt,Car> parkCarMap = new HashMap<>();
    public ParkingLot(int size) {
        this.size = size;
    }

    public Receipt park(Car car) {
        if(!isFull()) {

            Receipt receipt = new Receipt();

            parkCarMap.put(receipt,car);
            return receipt;
        }else{
            throw new ParkinglotException();
        }
    }

    public  boolean isFull() {
        return parkCarMap.size()==size;
    }

    public Car unPark(Receipt receipt) {
        return parkCarMap.remove(receipt);
    }
}