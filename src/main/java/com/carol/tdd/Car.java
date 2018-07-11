package com.carol.tdd;

public class Car implements parkingCarOp {
    public Ticket ticket;
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    private Integer id;

    @Override
    public void setParkingTicket(Ticket ticket) {
       this.ticket = ticket;
    }
    @Override
    public Ticket getParkingTicket() {
        return ticket;
    }
}
