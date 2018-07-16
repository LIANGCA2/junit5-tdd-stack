package com.thoughtworks.tdd;


public class Parking_simulation_systemTest {
//   @Test
//   public void should_park_successfully_when_parkinglot_is_not_full(){
//      ParkingLot parkingLot = new ParkingLot(1);
//
//      try {
//         parkingLot.park(new Car());
//      }catch (ParkinglotException e){
//         fail("parkingLot is full.");
//      }
//   }
//
//   @Test
//   public void should_park_unsuccessfully_when_parkinglot_is_full(){
//      ParkingLot parkingLot = new ParkingLot(0);
//
//      try {
//         parkingLot.park(new Car());
//         fail("parkingLot is full.");
//      }catch (ParkinglotException e){
//
//      }
//   }
//   @Test
//   public void should_get_specific_car_when_call_unpark_given_receipt_is_right(){
//      ParkingLot parkingLot = new ParkingLot(1);
//     Car theCar = new Car();
//     Receipt receipt =  parkingLot.park(theCar);
//      assertThat(parkingLot.unPark(receipt),is(theCar));
//   }
//
//
//   @Test
//   public void should_get_specific_car_when_call_unpark_given_receipt_is_wrong(){
//      ParkingLot parkingLot = new ParkingLot(1);
//      Car theCar = new Car();
//      Receipt receipt =  parkingLot.park(theCar);
//      Receipt anotherReceipt = new Receipt();
//      assertThat(parkingLot.unPark(anotherReceipt),not(theCar));
//   }
//
//   @Test
//   public void should_be_true_when_call_isFull_given_parking_lot_is_full(){
//      ParkingLot parkingLot = new ParkingLot(0);
//
//      assertThat(parkingLot.isFull(),is(true));
//   }
//   @Test
//   public void should_be_false_when_call_isFull_given_parking_lot_is_not_full(){
//      ParkingLot parkingLot = new ParkingLot(1);
//      assertThat(parkingLot.isFull(),is(false));
//   }
//   @Test
//   public void should_be_false_when_call_isFull_given_a_full_parking_lot_take_out_a_car(){
//      ParkingLot parkingLot = new ParkingLot(1);
//
//      Car theCar = new Car();
//      Receipt receipt = parkingLot.park(theCar);
//      parkingLot.unPark(receipt);
//
//      assertThat(parkingLot.isFull(), is(false));
//   }
//    @Test
//    public void should_park_successfullly_when_call_park_again_given_a_full_parking_lot_take_out_a_car(){
//        ParkingLot parkingLot = new ParkingLot(1);
//
//        Car theCar = new Car();
//        Receipt receipt = parkingLot.park(theCar);
//        parkingLot.unPark(receipt);
//
//        try {
//            parkingLot.park(new Car());
//        } catch (ParkinglotException exception) {
//            fail("should park successfully");
//        }
//    }
//
//
//    @Test
//    public void should_park_success_when_call_park_car_given_a_not_full_parking_lot(){
//        ParkingBoy parkingBoy = new ParkingBoy();
//        ParkingLot parkingLot = mock(ParkingLot.class);
//        Car car = mock(Car.class);
//        Receipt receipt = mock(Receipt.class);
//        parkingBoy.addParkingLot(parkingLot);
//        when(parkingLot.isFull()).thenReturn(false);
//        when(parkingLot.park(car)).thenReturn(receipt);
//        parkingBoy.park(car);
//        verify(parkingLot).park(car);
//
//    }
//
//
//    @Test
//    public void should_unpark_success_when_taken_car(){
//        ParkingBoy parkingBoy = new ParkingBoy();
//        ParkingLot parkingLot = new ParkingLot(1);
//        Car car = mock(Car.class);
//        parkingBoy.addParkingLot(parkingLot);
//        Receipt receipt = parkingBoy.park(car);
//        assertThat(parkingBoy.unPark(receipt),is(car));
//    }
//
//    @Test
//    public void should_unpark_fail_when_taken_car_by_error_receipt(){
//        ParkingBoy parkingBoy = new ParkingBoy();
//        ParkingLot parkingLot = new ParkingLot(1);
//        Car car = mock(Car.class);
//        parkingBoy.addParkingLot(parkingLot);
//        Receipt receipt = parkingBoy.park(car);
//        Receipt anotherReceipt = mock(Receipt.class);
//        assertThat(parkingBoy.unPark(anotherReceipt),not(car));
//    }
//
//
//
//    @Test
//    public void should_park_first_parklot_when_call_park_car_given_a_not_full_parking_lot_(){
//       ParkingBoy parkingBoy = new ParkingBoy();
//        ParkingLot parkingLot = mock(ParkingLot.class);
//        ParkingLot anotherParkingLot =  mock(ParkingLot.class);
//        parkingBoy.addParkingLot(parkingLot);
//        parkingBoy.addParkingLot(anotherParkingLot);
//        Car theCar = new Car();
//        when(parkingLot.isFull()).thenReturn(false);
//        Receipt receipt = mock(Receipt.class);
//        when(parkingLot.park(theCar)).thenReturn(receipt);
//        parkingBoy.park(theCar);
//        verify(parkingLot).park(theCar);
//
//    }
//
//    @Test
//    public void should_park_second_parklot_when_call_park_car_given_a_full_parking_lot_(){
//
//        ParkingBoy parkingBoy = new ParkingBoy();
//        ParkingLot parkingLot = mock(ParkingLot.class);
//        ParkingLot anotherParkingLot =  mock(ParkingLot.class);
//        parkingBoy.addParkingLot(parkingLot);
//        parkingBoy.addParkingLot(anotherParkingLot);
//        Car theCar =mock(Car.class);
//        when(parkingLot.isFull()).thenReturn(true);
//        when(anotherParkingLot.isFull()).thenReturn(false);
//        Receipt receipt = mock(Receipt.class);
//        when(anotherParkingLot.park(theCar)).thenReturn(receipt);
//        parkingBoy.park(theCar);
//        verify(anotherParkingLot).park(theCar);
//
//    }
//
//
//    @Test
//    public void should_park_first_parklot_when_call_park_car_given_a_full_parking_lot_take_out_car(){
//        ParkingBoy parkingBoy = new ParkingBoy();
//        ParkingLot parkingLot = new ParkingLot(1);
//        ParkingLot anotherParkingLot = new ParkingLot(1);
//        parkingBoy.addParkingLot(parkingLot);
//        parkingBoy.addParkingLot(anotherParkingLot);
//        Car theCar = mock(Car.class);
//        Receipt receipt = parkingBoy.park(theCar);
//        parkingBoy.unPark(receipt);
//        Car anotherCar = mock(Car.class);
//        Receipt receipt1 = parkingBoy.park(anotherCar);
//        assertThat(parkingBoy.findParkingLotByReceipt(receipt1),is(parkingLot));
//    }
//    @Test
//    public void should_Fail_when_call_park_car_given_a_full_parking_lot(){
//        ParkingBoy parkingBoy = new ParkingBoy();
//        ParkingLot parkingLot = new ParkingLot(0);
//        parkingBoy.addParkingLot(parkingLot);
//        Car theCar = mock(Car.class);
//        try {
//            parkingBoy.park(theCar);
//            fail("parkingLot is full.");
//        }catch (ParkinglotException e){
//        }
//    }






}
