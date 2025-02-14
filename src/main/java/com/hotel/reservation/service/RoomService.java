package com.hotel.reservation.service;

import com.hotel.reservation.model.Room;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class RoomService {

    private Map<Integer, List<Room>> hotelRooms = new HashMap<>();
    
    // Constructor: Initialize rooms in hotel
    public RoomService() {
        for (int i = 1; i <= 9; i++) {
            hotelRooms.put(i, new ArrayList<>());
            for (int j = 1; j <= 10; j++) {
                hotelRooms.get(i).add(new Room(i + "" + (j < 10 ? "0" + j : j)));
            }
        }
        hotelRooms.put(10, new ArrayList<>());
        for (int i = 1; i <= 7; i++) {
            hotelRooms.get(10).add(new Room("100" + i));
        }
    }

    public List<Room> getAvailableRooms() {
        List<Room> availableRooms = new ArrayList<>();
        for (Map.Entry<Integer, List<Room>> entry : hotelRooms.entrySet()) {
            for (Room room : entry.getValue()) {
                if (!room.isBooked()) {
                    availableRooms.add(room);
                }
            }
        }
        return availableRooms;
    }

    public String bookRooms(int numOfRooms) {
        List<Room> availableRooms = getAvailableRooms();
        if (availableRooms.size() < numOfRooms) {
            return "Not enough rooms available.";
        }

        // Implement logic based on rules
        List<Room> bookedRooms = new ArrayList<>();
        for (Room room : availableRooms) {
            if (bookedRooms.size() < numOfRooms) {
                room.setBooked(true);
                bookedRooms.add(room);
            }
        }

        return "Rooms booked: " + bookedRooms.stream().map(Room::getRoomNumber).collect(Collectors.joining(", "));
    }

    public void resetBookings() {
        for (Map.Entry<Integer, List<Room>> entry : hotelRooms.entrySet()) {
            for (Room room : entry.getValue()) {
                room.setBooked(false);
            }
        }
    }

    // Simulate random occupancy
    public void generateRandomOccupancy() {
        Random rand = new Random();
        for (Map.Entry<Integer, List<Room>> entry : hotelRooms.entrySet()) {
            for (Room room : entry.getValue()) {
                room.setBooked(rand.nextBoolean());
            }
        }
    }
}
