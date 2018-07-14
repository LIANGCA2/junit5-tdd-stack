package com.thoughtworks.tdd;

import java.util.HashMap;
import java.util.UUID;

public class ParkingLot {
    private int size;
    private HashMap<Receipt,Car> parkCarMap = new HashMap<>();
    public ParkingLot(int size) {
        this.size = size;
    }

    public Receipt park(Car car) {
        if(!isFull()) {

            Receipt receipt = new Receipt(UUID.randomUUID().toString());

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
        Receipt key = findKeyFromParkCarMap(receipt);
        if(key!=null) {
            return parkCarMap.remove(key);
        }

        return null;
    }

    public Receipt findKeyFromParkCarMap(Receipt receipt) {
        for(Receipt key:parkCarMap.keySet()){
            if(key.getId().equals(receipt.getId())){
                return key;
            }
        }
        return null;
    }

    public boolean findCarByReceipt(Receipt receipt) {
        if(findKeyFromParkCarMap(receipt)!=null){
            return true;
        }else{
            return false;
        }
    }
}
