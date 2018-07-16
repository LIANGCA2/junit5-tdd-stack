package com.thoughtworks.tdd;

public class ParkingLotController {
    private final ParkingBoy parkingBoy;
    private  ParkingLotInputCommand parkingLotInputCommand;
    private final ParkingView parkingView;
    private String currentPage;

    public ParkingLotController(ParkingBoy parkingBoy, ParkingLotInputCommand parkingLotInputCommand,ParkingView parkingView) {
        this.parkingBoy = parkingBoy;
        this.parkingLotInputCommand = parkingLotInputCommand;
        this.parkingView = parkingView;
    }

    public ParkingLotController(ParkingBoy parkingBoy, ParkingView parkingView) {
        this.parkingBoy = parkingBoy;
        this.parkingView = parkingView;

    }

    public ParkingLotInputCommand getParkingLotInputCommand() {
        return parkingLotInputCommand;
    }
    public ParkingBoy getParkingBoy() {
        return parkingBoy;
    }




    public String handleMainCommand(Request request) {
        if(request.getCommand().equals("1")){
            if(parkingBoy.checkParkingLotFullStatus()){
                parkingView.showParkingLotFullStatus();
                parkingView.showBeginView();
                return "main";
            }else{
                parkingView.showInputCarLicensePlateNumber();
                return "park";
            }
        }else if(request.getCommand().equals("2")){
            parkingView.showInputReceiptNumber();
            return "unpark";
        }else{
            parkingView.showErrorInputInfomation();
            parkingView.showBeginView();
            return "main";
        }
    }

    public String handleParkCommand(Request request) {
        Car car = new Car(request.getCommand());
        Receipt receipt = parkingBoy.park(car);
        parkingView.showParkingSuccess(receipt.getId());
        parkingView.showBeginView();
        return "main";
    }

    public String handleUnparkCommand(Request request) {
        Receipt receipt = new Receipt(request.getCommand());
        Car car = parkingBoy.unPark(receipt);
        if(car!= null){
            parkingView.showUnparkSuccess(car.getLicensePlateNumber());
        }else{
            parkingView.showInvaildReceipt();
        }
        parkingView.showBeginView();
        return "main";
    }
}
