package com.thoughtworks.tdd;

public class Car {
    private String LicensePlateNumber;

    public Car(){

    }

    public Car(String licensePlateNumber) {
        LicensePlateNumber = licensePlateNumber;
    }

    public String getLicensePlateNumber() {
        return LicensePlateNumber;
    }

    public void setLicensePlateNumber(String licensePlateNumber) {
        LicensePlateNumber = licensePlateNumber;
    }


}
