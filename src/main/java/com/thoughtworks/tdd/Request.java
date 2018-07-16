package com.thoughtworks.tdd;

public class Request {
    private String command;

    public Request(String command) {
        this.command = command;
    }

    public Request() {

    }

    public String getCommand() {
        return command;
    }

    public void setCommand(String command) {
        this.command = command;
    }
}

