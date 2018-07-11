package com.carol.tdd;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;

import static org.fest.assertions.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.fail;


public class Parking_simulation_systemTest {
    private ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    @Test
    public void should_return_1_when_parklot_is_empty_input_a_Car() throws Exception {
        //given
        Car car = new Car();
        ParkingLot parkingLot = new ParkingLot(3);
        //when
        Ticket ticket = parkingLot.parkCar(car);
        //then
        assertThat(ticket.getId()).isEqualTo(1);
    }
    @Test
    public void should_print_CarLotIsFull_when_parklot_is_full_input_a_Car() throws Exception {
        //given
        Car car = new Car();
        ParkingLot parkingLot = new ParkingLot(3);
        //when
        for(int i = 0;i<4;i++){
            parkingLot.parkCar(car);
        }
        //then
        assertThat(systemOut().contains("parkingLot is Full\n")).isTrue();
    }
    @Test
    public void should_return_1_when_take_car() throws Exception {
        //given
        Car car = new Car();
        ParkingLot parkingLot = new ParkingLot(3);
        parkingLot.parkCar(car);
        //when
        Ticket ticket = parkingLot.popCar(car);
        //then
        assertThat(ticket.getId()).isEqualTo(1);
    }
    @Test
    public void should_throw_Exception_when_parklot_is_full_input_a_Car()  {
        //given
        Car car = new Car();
        ParkingLot parkingLot = new ParkingLot(3);
        //when
        try {
            for(int i = 0;i<4;i++){
                parkingLot.parkCar(car);
            }
        }catch (ParkingLotFullException e){
            fail("parkingLot is full");
        }

        //then
        // assertThat();
    }
    private String systemOut() {
        return outContent.toString();
    }
}
