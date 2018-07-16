package com.thoughtworks.tdd;

import java.io.ByteArrayOutputStream;

public class commandLineTest {
    private ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    private String systemOut() {
        return outContent.toString();
    }



//
//    @Test
//    public void should_printinValid_input_when_input_is_not_a_number(){
//        try {
//            ParkingBoy parkingBoy = new ParkingBoy();
//            parkingBoy.inputOperate("aaaaa");
//            fail("非法指令，程序终止");
//        }catch (ParkinglotException e){
//
//        }
//    }
//
//
//    @Test
//    public void should_print_reInput_when_input_is__a_number_but_not_1_and_2(){
//
//            ParkingBoy parkingBoy = new ParkingBoy();
//            assertThat(parkingBoy.inputOperate("3").getResult(),is("非法指令，请查证后再输"));
//    }
//
//    @Test
//    public void should_print_unpark_success_when_input_is_2_and_receipt_is_right(){
//        ArrayList<ParkingLot> parkingLotArrayList = new ArrayList<>();
//        ParkingLot parkingLot = new ParkingLot(1);
//        parkingLotArrayList.add(parkingLot);
//        ParkingBoy parkingBoy = new ParkingBoy(parkingLotArrayList);
//        Car car = mock(Car.class);
//        Receipt receipt = parkingBoy.park(car);
//        when(car.getLicensePlateNumber()).thenReturn("xxxxxx");
//        //parkingBoy.operateCarByInput(receipt.getId(),new Result("",2));
//        assertThat( parkingBoy.operateCarByInput(receipt.getId(),new Result("",2)).getResult(),is("xxxxxx"));
//    }
//
//
//    @Test
//    public void should_print_unpark_unsuccess_when_input_is_2_and_receipt_is_wrong(){
//        ArrayList<ParkingLot> parkingLotArrayList = new ArrayList<>();
//        ParkingLot parkingLot = new ParkingLot(1);
//        parkingLotArrayList.add(parkingLot);
//        ParkingBoy parkingBoy = new ParkingBoy(parkingLotArrayList);
//        Car car = mock(Car.class);
//        Receipt receipt = parkingBoy.park(car);
//        //parkingBoy.operateCarByInput(receipt.getId(),new Result("",2));
//        assertThat( parkingBoy.operateCarByInput("wwwww",new Result("",2)).getResult(),is(""));
//    }
//
//
//
//    @Test
//    public void should_print_park_success_when_input_is_1_and_parkinglot_is_not_full(){
//
//        ArrayList<ParkingLot> parkingLotArrayList = new ArrayList<>();
//        ParkingLot parkingLot = new ParkingLot(1);
//        parkingLotArrayList.add(parkingLot);
//        ParkingBoy parkingBoy = new ParkingBoy(parkingLotArrayList);
//        try {
//            parkingBoy.operateCarByInput("1111", new Result("", 1)).getResult();
//        }catch (ParkinglotException e){
//            fail("车停满了");
//        }
//    }
//
//
//    @Test
//    public void should_print_park_success_when_input_is_1_and_parkinglot_is_full(){
//
//        ArrayList<ParkingLot> parkingLotArrayList = new ArrayList<>();
//        ParkingLot parkingLot = new ParkingLot(0);
//        parkingLotArrayList.add(parkingLot);
//        ParkingBoy parkingBoy = new ParkingBoy(parkingLotArrayList);
//        try {
//            parkingBoy.operateCarByInput("1111", new Result("", 1)).getResult();
//            fail("车停满了");
//        }catch (ParkinglotException e){
//
//        }
//    }
//
//
//
//
//    @Test
//    public void should_print_parking_success_input_whenparkinglot_is_not_full_given_input_is_1(){
//        ParkingBoy parkingBoy = mock(ParkingBoy.class);
//        Result result = mock(Result.class);
//        ParkingLotInputCommand inputOperation = mock(ParkingLotInputCommand.class);
//        ParkingView parkingView = mock(ParkingView.class);
//        try {
//
//            ParkingLotController parkingLotController = new ParkingLotController(parkingBoy,inputOperation,parkingView);
//            when(inputOperation.input()).thenReturn("1","xxxxx");
//            when(parkingBoy.inputOperate(any())).thenReturn(result);
//            when(parkingView.showChooseInputResult(any())).thenReturn(false);
//            when(parkingBoy.operateCarByInput(any(),any())).thenReturn(result);
//            doThrow(new RuntimeException()).when(parkingView).showOperateCarResult(any());
//            parkingLotController.operate(inputOperation);
//        }catch (RuntimeException e){
//            verify(parkingBoy).inputOperate(any());
//            verify(parkingView).showChooseInputResult(any());
//            verify(parkingBoy).operateCarByInput(any(),any());
//            verify(parkingView).showOperateCarResult(any());
//        }
//
//    }
//
//
////
////    @Test
////    public void should_print_unPark_success_input_when_given_receipt_is_right(){
////        ParkingBoy parkingBoy = mock(ParkingBoy.class);
////        ParkingLotInputCommand inputOperation = mock(ParkingLotInputCommand.class);
////        int choice = 2;
////        ParkingLotController parkingLotController = new ParkingLotController(parkingBoy,inputOperation);
////        parkingLotController.enterDiffBranchByDiffChoice(choice);
////        assertThat(systemOut().contains("车已停满，请晚点再来"));
////    }
////
////    @Test
////    public void should_print_unPark_unsuccess_input_when_given_receipt_is_error(){
////        ParkingBoy parkingBoy = mock(ParkingBoy.class);
////        ParkingLotInputCommand inputOperation = mock(ParkingLotInputCommand.class);
////        int choice = 2;
////        ParkingLotController parkingLotController = new ParkingLotController(parkingBoy,inputOperation);
////        parkingLotController.enterDiffBranchByDiffChoice(choice);
////        when(inputOperation.input()).thenReturn("40b83c35-5465-47b4-8854-aaf3517b6f95");
////        when(parkingBoy.unPark())
////        assertThat(systemOut().contains("车已停满，请晚点再来"));
////    }
//

}
