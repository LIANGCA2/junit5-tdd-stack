package com.thoughtworks.tdd;

public class Receipt {
    private String id;

    public Receipt(){

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Receipt(String id) {
        this.id = id;
    }
}
