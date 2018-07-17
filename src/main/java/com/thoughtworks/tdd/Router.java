package com.thoughtworks.tdd;

public class Router {
    private  ParkingLotController parkingLotController;
    private String currentPage;
    private Request request;
    private Response response;
   // private HashMap<String,Controllor> routeToControllerMap = new HashMap<>();

    public Router() {
    }

    public Router(String currentPage) {
        this.currentPage = currentPage;
    }

    public String getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(String currentPage) {
        this.currentPage = currentPage;
    }

    public Router(ParkingLotController parkingLotController) {

        this.parkingLotController = parkingLotController;
    }

    public String choosePage(String currentPage, Request request) {
        switch (currentPage) {
            case "main":
                this.currentPage = parkingLotController.handleMainCommand(request);
                break;
            case "parkingService":
                this.currentPage = parkingLotController.handleParkingServiceCommand(request);
                break;
            case "parkingManage":
                this.currentPage = parkingLotController.handleParkManageCommand(request);
                break;
            case "addParkingLot":
                this.currentPage = parkingLotController.handleAddParkingLotCommand(request);
                break;
            case "deleteParkingLot":
                this.currentPage = parkingLotController.handleDeleteParkingLotCommand(request);
                break;
            case "park":
                this.currentPage = parkingLotController.handleParkCommand(request);
                break;
            case "unpark":
                this.currentPage = parkingLotController.handleUnparkCommand(request);
                break;
        }
        return this.currentPage;
    }


}
