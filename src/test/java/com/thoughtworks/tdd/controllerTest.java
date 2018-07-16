package com.thoughtworks.tdd;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class controllerTest {
    @Test
    public void should_return_main_when_command_is_park_and_parkingLot_is_full() {
        Request request = mock(Request.class);
        ParkingBoy parkingBoy = mock(ParkingBoy.class);
        ParkingView parkingView = mock(ParkingView.class);
        when(request.getCommand()).thenReturn("1");
        when(parkingBoy.checkParkingLotFullStatus()).thenReturn(true);
        ParkingLotController parkingLotController = new ParkingLotController(parkingBoy,parkingView);
        assertThat(parkingLotController.handleMainCommand(request),is("main"));
        verify(parkingView).showParkingLotFullStatus();
    }


    @Test
    public void should_return_park_when_command_is_park_and_parkingLot_is_not_full() {
        Request request = mock(Request.class);
        ParkingBoy parkingBoy = mock(ParkingBoy.class);
        ParkingView parkingView = mock(ParkingView.class);
        when(request.getCommand()).thenReturn("1");
        when(parkingBoy.checkParkingLotFullStatus()).thenReturn(false);
        ParkingLotController parkingLotController = new ParkingLotController(parkingBoy,parkingView);
        assertThat(parkingLotController.handleMainCommand(request),is("park"));
    }

    @Test
    public void should_return_unpark_when_command_is_unpark() {
        Request request = mock(Request.class);
        ParkingBoy parkingBoy = mock(ParkingBoy.class);
        ParkingView parkingView = mock(ParkingView.class);
        when(request.getCommand()).thenReturn("2");
        ParkingLotController parkingLotController = new ParkingLotController(parkingBoy,parkingView);
        assertThat(parkingLotController.handleMainCommand(request),is("unpark"));
    }

    @Test
    public void should_return_main_when_command_is_invaild() {
        Request request = mock(Request.class);
        ParkingBoy parkingBoy = mock(ParkingBoy.class);
        ParkingView parkingView = mock(ParkingView.class);
        when(request.getCommand()).thenReturn("3");
        ParkingLotController parkingLotController = new ParkingLotController(parkingBoy,parkingView);
        assertThat(parkingLotController.handleMainCommand(request),is("main"));
        verify(parkingView).showErrorInputInfomation();
    }



}
