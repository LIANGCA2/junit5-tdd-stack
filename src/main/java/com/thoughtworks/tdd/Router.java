package com.thoughtworks.tdd;

public class Router {
    private final ParkingLotController parkingLotController;
    private String currentPage;
    private Request request;
    private Response response;

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
