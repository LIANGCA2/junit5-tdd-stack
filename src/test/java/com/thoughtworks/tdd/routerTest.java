package com.thoughtworks.tdd;

import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class routerTest {
    @Test
    public void should_enter_main_branch_when_currentPage_is_main(){
    String currentPage = "main";
    ParkingLotController parkingLotController = mock(ParkingLotController.class);
    Request request = mock(Request.class);
    Router router = new Router(parkingLotController);
    when(parkingLotController.handleMainCommand(request)).thenReturn("");
    router.choosePage(currentPage,request);
    verify(parkingLotController).handleMainCommand(request);
    }


    @Test
    public void should_enter_park_branch_when_currentPage_is_park(){
        String currentPage = "park";
        ParkingLotController parkingLotController = mock(ParkingLotController.class);
        Request request = mock(Request.class);
        Router router = new Router(parkingLotController);
        when(parkingLotController.handleParkCommand(request)).thenReturn("");
        router.choosePage(currentPage,request);
        verify(parkingLotController).handleParkCommand(request);
    }



    @Test
    public void should_enter_unpark_branch_when_currentPage_is_unpark(){
        String currentPage = "unpark";
        ParkingLotController parkingLotController = mock(ParkingLotController.class);
        Request request = mock(Request.class);
        Router router = new Router(parkingLotController);
        when(parkingLotController.handleUnparkCommand(request)).thenReturn("");
        router.choosePage(currentPage,request);
        verify(parkingLotController).handleUnparkCommand(request);
    }
}
