package com.thoughtworks.tdd;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.mockito.Mockito.mock;

public class parkingBoyTest {

    @Test
    public void should_return_Receipt_when_parkingLot_is_not_full(){
        Car car = mock(Car.class);
        ParkingLot parkingLot = mock(ParkingLot.class);
        ArrayList<ParkingLot> parkingLotArrayList = new ArrayList<>();
        ParkingBoy parkingBoy = new ParkingBoy(parkingLotArrayList);

    }


}
