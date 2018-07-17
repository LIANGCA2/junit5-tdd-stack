package com.thoughtworks.tdd;

import java.util.HashMap;
import java.util.UUID;

public class ParkingLot {
    private String id;
    private String name;
    private int size;
    private HashMap<Receipt,Car> parkCarMap = new HashMap<>();

    public ParkingLot(String name, int size) {

        this.name = name;
        this.size = size;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public HashMap<Receipt, Car> getParkCarMap() {
        return parkCarMap;
    }

    public void setParkCarMap(HashMap<Receipt, Car> parkCarMap) {
        this.parkCarMap = parkCarMap;
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
