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
           parkingView.showParkingSevice();
           return "parkingService";
       }else if(request.getCommand().equals("2")){
           parkingView.showParkingManage();
           return "parkingManage";
       }else{
           parkingView.showErrorInputInfomation();
           parkingView.showBeginView();
           return "main";
       }
    }

    public String handleParkingServiceCommand(Request request) {
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
        parkingView.showParkingSuccessfully(receipt.getId());
        parkingView.showBeginView();
        return "main";
    }

    public String handleUnparkCommand(Request request) {
        Receipt receipt = new Receipt(request.getCommand());
        Car car = parkingBoy.unPark(receipt);
        if(car!= null){
            parkingView.showUnparkSuccessfully(car.getLicensePlateNumber());
        }else{
            parkingView.showInvaildReceipt();
        }
        parkingView.showBeginView();
        return "main";
    }

    public String handleParkManageCommand(Request request) {
        if(request.getCommand().equals("1")){
            parkingView.showParkingDetail(parkingBoy.getParkingLotArrayList());
            parkingView.showBeginView();
            return "main";
            }else if(request.getCommand().equals("2")){
            parkingView.showInputParkingLotInfomation();
            return "addParkingLot";
        }else if(request.getCommand().equals("3")){
            parkingView.showInputParkingLotId();
            return "deleteParkingLot";
        }else{
            parkingView.showErrorInputInfomation();
            parkingView.showBeginView();
            return "main";
        }
    }

    public String handleAddParkingLotCommand(Request request) {
        boolean addParkingLotStatus = addParkingLot(request);
        if(addParkingLotStatus){
            parkingView.showAddParkingLotSuccessfully();
            parkingView.showBeginView();
            return "main";
        }else{
            parkingView.showBeginView();
            return "main";
        }
    }

    private boolean addParkingLot(Request request) {
        String[] info = request.getCommand().split("，");
        if(info.length<2){
            return false;
        }
        try {
            int size = Integer.parseInt(info[1]);
        }catch (Exception e){
            return false;
        }
        ParkingLot parkingLot = new ParkingLot(info[0],Integer.parseInt(info[1]));
        parkingLot.setId(parkingBoy.getParkingNumber());
        parkingBoy.addParkingLot(parkingLot);
        return true;
    }

    public String handleDeleteParkingLotCommand(Request request) {
        Result result =  parkingBoy.deleteParkingLotById(request.getCommand());
        if(result.getStatus()){
            parkingView.showDeleteParkingLotSuccessfully();
            parkingView.showBeginView();
            return "main";
        }else{
          parkingView.showDeleteParkingLotUnsucessfully(result.getReason());
            parkingView.showBeginView();
            return "main";
        }
    }
}
