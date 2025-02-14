package com.hotel.reservation.model;

public class Room {
    private String roomNumber;
    private boolean isBooked;

    // Constructor, Getters, and Setters
    public Room(String roomNumber) {
        this.roomNumber = roomNumber;
        this.isBooked = false;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public boolean isBooked() {
        return isBooked;
    }

    public void setBooked(boolean booked) {
        isBooked = booked;
    }
}
