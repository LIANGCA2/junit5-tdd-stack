package com.thoughtworks.tdd;

public class ParkingLotController {
    private final ParkingBoy parkingBoy;
    private final ParkingLotInputCommand parkingLotInputCommand;
    private final ParkingView parkingView;


    public ParkingLotController(ParkingBoy parkingBoy, ParkingLotInputCommand parkingLotInputCommand,ParkingView parkingView) {
        this.parkingBoy = parkingBoy;
        this.parkingLotInputCommand = parkingLotInputCommand;
        this.parkingView = parkingView;
    }


    public ParkingLotInputCommand getParkingLotInputCommand() {
        return parkingLotInputCommand;
    }
    public ParkingBoy getParkingBoy() {
        return parkingBoy;
    }




    public void start() {
        parkingView.showBeginView();
    }


    public void operate(InputCommand inputCommand){
       Result result=  parkingBoy.inputOperate(inputCommand.input());
       Boolean restartStatus = parkingView.showChooseInputResult(result);
       if (restartStatus){
           operate(inputCommand);
       }else{
           Result operateCarResult = parkingBoy.operateCarByInput(inputCommand.input(),result);
           parkingView.showOperateCarResult(operateCarResult);
           operate(inputCommand);
       }

    }

}
