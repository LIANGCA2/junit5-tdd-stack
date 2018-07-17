package com.thoughtworks.tdd;

import java.util.Scanner;

public class ParkingLotInputCommand implements InputCommand{
    private Scanner scanner = new Scanner(System.in);

    public ParkingLotInputCommand(){

    }


    @Override
    public String input() {
            return scanner.nextLine();
    }

    @Override
    public void close() {
        scanner.close();
    }
}
