package com.carol.tdd;

import java.util.ArrayList;

public class ParkingLot {
    private ArrayList<Car> parkingSpaceList = new ArrayList<>();
    private Integer size;
    private Integer remainingSpace;

    public Integer getRemainingSpace() {
        return remainingSpace;
    }

    public void setRemainingSpace(Integer remainingSpace) {
        this.remainingSpace = remainingSpace;
    }

    public ParkingLot(Integer size) {
        this.size = size;
        this.remainingSpace = size;
    }

    public ArrayList<Car> getParkingSpaceList() {
        return parkingSpaceList;
    }

    public void setParkingSpaceList(ArrayList<Car> parkingSpaceList) {
        this.parkingSpaceList = parkingSpaceList;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public Ticket parkCar(Car car)  {
        if(getRemainingSpace()>0){
            getParkingSpaceList().add(car);
            setRemainingSpace(getRemainingSpace()-1);
            Ticket ticket =  generateTicket(parkingSpaceList);
            car.setParkingTicket(ticket);
            return ticket;
        }else{
            System.out.print("parkingLot is Full\n");

                throw new ParkingLotFullException();
            }

    }

    private Ticket generateTicket(ArrayList<Car> parkingSpaceList) {
        return new Ticket(parkingSpaceList.size());
    }

    public Ticket popCar(Car car) {
        Ticket ticket =  car.getParkingTicket();
        car.setParkingTicket(null);
        return ticket;
    }
}
