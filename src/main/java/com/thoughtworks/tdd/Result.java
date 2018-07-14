package com.thoughtworks.tdd;

public class Result {
    private  String result;
    private  Integer choice;
    private  Boolean parkingLotFullStatus;

    public Result(String result, Integer choice) {
        this.result = result;
        this.choice = choice;
    }


    public Result(String result) {
        this.result = result;
    }



    public void setResult(String result) {
        this.result = result;
    }

    public void setChoice(Integer choice) {
        this.choice = choice;
    }

    public void setParkingLotFullStatus(Boolean parkingLotFullStatus) {
        this.parkingLotFullStatus = parkingLotFullStatus;
    }

    public Boolean getParkingLotFullStatus() {
        return parkingLotFullStatus;
    }

    public Integer getChoice() {
        return choice;
    }

    public String getResult() {
        return result;
    }

    public Result(String result, Integer choice, Boolean parkingLotFullStatus) {
        this.result = result;
        this.choice = choice;
        this.parkingLotFullStatus = parkingLotFullStatus;
    }
}
