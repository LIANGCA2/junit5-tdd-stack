package com.thoughtworks.tdd;


import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsNot.not;
import static org.junit.jupiter.api.Assertions.fail;


public class Parking_simulation_systemTest {
   @Test
   public void should_park_successfully_when_parkinglot_is_not_full(){
      ParkingLot parkingLot = new ParkingLot(1);

      try {
         parkingLot.park(new Car());
      }catch (ParkinglotException e){
         fail("parkingLot is full.");
      }
   }

   @Test
   public void should_park_unsuccessfully_when_parkinglot_is_full(){
      ParkingLot parkingLot = new ParkingLot(0);

      try {
         parkingLot.park(new Car());
         fail("parkingLot is full.");
      }catch (ParkinglotException e){

      }
   }
   @Test
   public void should_get_specific_car_when_call_unpark_given_receipt_is_right(){
      ParkingLot parkingLot = new ParkingLot(1);
     Car theCar = new Car();
     Receipt receipt =  parkingLot.park(theCar);
      assertThat(parkingLot.unPark(receipt),is(theCar));
   }


   @Test
   public void should_get_specific_car_when_call_unpark_given_receipt_is_wrong(){
      ParkingLot parkingLot = new ParkingLot(1);
      Car theCar = new Car();
      Receipt receipt =  parkingLot.park(theCar);
      Receipt anotherReceipt = new Receipt();
      assertThat(parkingLot.unPark(anotherReceipt),not(theCar));
   }

   @Test
   public void should_be_true_when_call_isFull_given_parking_lot_is_full(){
      ParkingLot parkingLot = new ParkingLot(0);

      assertThat(parkingLot.isFull(),is(true));
   }
   @Test
   public void should_be_false_when_call_isFull_given_parking_lot_is_not_full(){
      ParkingLot parkingLot = new ParkingLot(1);
      assertThat(parkingLot.isFull(),is(false));
   }
   @Test
   public void should_be_false_when_call_isFull_given_a_full_parking_lot_take_out_a_car(){
      ParkingLot parkingLot = new ParkingLot(1);

      Car theCar = new Car();
      Receipt receipt = parkingLot.park(theCar);
      parkingLot.unPark(receipt);

      assertThat(parkingLot.isFull(), is(false));
   }
    @Test
    public void should_park_successfullly_when_call_park_again_given_a_full_parking_lot_take_out_a_car(){
        ParkingLot parkingLot = new ParkingLot(1);

        Car theCar = new Car();
        Receipt receipt = parkingLot.park(theCar);
        parkingLot.unPark(receipt);

        try {
            parkingLot.park(new Car());
        } catch (ParkinglotException exception) {
            fail("should park successfully");
        }
    }

    @Test
    public void should_park_first_parklot_when_call_park_car_given_a_not_full_parking_lot_(){
       ParkingBoy parkingBoy = new ParkingBoy();
        ParkingLot parkingLot = new ParkingLot(1);
        ParkingLot anotherParkingLot = new ParkingLot(1);
        parkingBoy.addParkingLot(parkingLot);
        parkingBoy.addParkingLot(anotherParkingLot);
        Car theCar = new Car();
        Receipt receipt = parkingBoy.park(theCar);
        assertThat(parkingBoy.findParkingLotByReceipt(receipt),is(parkingLot));

    }

    @Test
    public void should_park_second_parklot_when_call_park_car_given_a_full_parking_lot_(){
        ParkingBoy parkingBoy = new ParkingBoy();
        ParkingLot parkingLot = new ParkingLot(0);
        ParkingLot anotherParkingLot = new ParkingLot(1);
        parkingBoy.addParkingLot(parkingLot);
        parkingBoy.addParkingLot(anotherParkingLot);
        Car theCar = new Car();
        Receipt receipt = parkingBoy.park(theCar);
        assertThat(parkingBoy.findParkingLotByReceipt(receipt),is(anotherParkingLot));
    }


    @Test
    public void should_park_first_parklot_when_call_park_car_given_a_full_parking_lot_take_out_car(){
        ParkingBoy parkingBoy = new ParkingBoy();
        ParkingLot parkingLot = new ParkingLot(1);
        ParkingLot anotherParkingLot = new ParkingLot(1);
        parkingBoy.addParkingLot(parkingLot);
        parkingBoy.addParkingLot(anotherParkingLot);
        Car theCar = new Car();
        Receipt receipt = parkingBoy.park(theCar);
        parkingBoy.unPark(receipt);
        Car anotherCar = new Car();
        Receipt receipt1 = parkingBoy.park(anotherCar);
        assertThat(parkingBoy.findParkingLotByReceipt(receipt1),is(parkingLot));
    }
    @Test
    public void should_Fail_when_call_park_car_given_a_full_parking_lot(){
        ParkingBoy parkingBoy = new ParkingBoy();
        ParkingLot parkingLot = new ParkingLot(0);
        parkingBoy.addParkingLot(parkingLot);
        Car theCar = new Car();
        try {
            parkingLot.park(theCar);
            fail("parkingLot is full.");
        }catch (ParkinglotException e){
        }
    }


}
