package com.thoughtworks.tdd;

import java.io.ByteArrayOutputStream;

public class ParkingViewTest {


    private ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private String systemOut() {
        return outContent.toString();
    }


//    @Test
//    public void should_print_user_interface(){
//        ParkingView parkingView = new ParkingView();
//        parkingView.showBeginView();
//        assertThat(systemOut().contains("1. 停车\\n\" +\n" +
//                "                \"2. 取车 \\n\" +\n" +
//                "                \"请输入您要进行的操作："));
//    }
//
//    @Test
//    public void should_print_ParkingLot_is_full_when_Result_full_status_is_true(){
//        ParkingView parkingView = new ParkingView();
//   Result result = mock(Result.class);
//   when(result.getChoice()).thenReturn(1);
//        when(result.getParkingLotFullStatus()).thenReturn(true);
//   parkingView.showChooseInputResult(result);
//   assertThat(systemOut().contains("车已停满，请晚点再来"));
//    }
//    @Test
//    public void should_print_input_carLisence_when_Result_full_status_is_false(){
//        ParkingView parkingView = new ParkingView();
//        Result result = mock(Result.class);
//        when(result.getChoice()).thenReturn(1);
//        when(result.getParkingLotFullStatus()).thenReturn(false);
//        parkingView.showChooseInputResult(result);
//        assertThat(systemOut().contains("请输入车牌号:"));
//    }
//
//    @Test
//    public void should_print_input_receipt_number_when_choose_unpark_car(){
//        ParkingView parkingView = new ParkingView();
//        Result result = mock(Result.class);
//        when(result.getChoice()).thenReturn(2);
//        parkingView.showChooseInputResult(result);
//        assertThat(systemOut().contains("请输入小票编号："));
//    }
//
//
//    @Test
//    public void should_print_error_info_when_choose_not_1_and_2(){
//        ParkingView parkingView = new ParkingView();
//        Result result = mock(Result.class);
//        when(result.getChoice()).thenReturn(3);
//        parkingView.showChooseInputResult(result);
//        assertThat(systemOut().contains("非法指令，请查证后再输"));
//    }
//
//
//    @Test
//    public void should_print_parking_success_when_choose_1(){
//        ParkingView parkingView = new ParkingView();
//        Result result = mock(Result.class);
//        when(result.getChoice()).thenReturn(1);
//        parkingView.showOperateCarResult(result);
//        assertThat(systemOut().contains("停车成功，您的小票是"));
//    }
//
//    @Test
//    public void should_print_unparking_success_when_Result_result_is_not_null(){
//        ParkingView parkingView = new ParkingView();
//        Result result = mock(Result.class);
//        when(result.getResult()).thenReturn("40b83c35-5465-47b4-8854-aaf3517b6f95");
//        parkingView.showOperateCarResult(result);
//        assertThat(systemOut().contains("车已取出，您的车牌号是: "));
//    }
//
//
//    @Test
//    public void should_print_unparking_success_when_Result_result_is_null(){
//        ParkingView parkingView = new ParkingView();
//        Result result = mock(Result.class);
//        when(result.getResult()).thenReturn("");
//        parkingView.showOperateCarResult(result);
//        assertThat(systemOut().contains("非法小票，无法取出车，请查证后再输"));
//    }
}
