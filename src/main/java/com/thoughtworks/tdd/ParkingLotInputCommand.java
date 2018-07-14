package com.thoughtworks.tdd;

import java.util.Scanner;

public class ParkingLotInputCommand implements InputCommand{

    public ParkingLotInputCommand(){

    }


    @Override
    public String input() {
            Scanner scanner = new Scanner(System.in);
            return scanner.nextLine();
    }
}
