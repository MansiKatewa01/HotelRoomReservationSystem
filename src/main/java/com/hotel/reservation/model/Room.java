package com.hotel.reservation.model;

public class Room {
    private int floor;
    private int number;
    private boolean isBooked;

    public Room(int floor, int number) {
        this.floor = floor;
        this.number = number;
        this.isBooked = false;
    }

    public int getFloor() { return floor; }
    public int getNumber() { return number; }
    public boolean isBooked() { return isBooked; }

    public void setBooked(boolean booked) { isBooked = booked; }
}
