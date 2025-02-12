package com.hotel.reservation.service;

import com.hotel.reservation.model.Room;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class RoomService {
    private final List<Room> rooms = new ArrayList<>();

    public RoomService() {
        initializeRooms();
    }

    private void initializeRooms() {
        for (int floor = 1; floor <= 9; floor++) {
            for (int i = 1; i <= 10; i++) {
                rooms.add(new Room(floor, floor * 100 + i));
            }
        }
        for (int i = 1; i <= 7; i++) {
            rooms.add(new Room(10, 1000 + i));
        }
    }

    public List<Room> getAvailableRooms() {
        List<Room> available = new ArrayList<>();
        for (Room room : rooms) {
            if (!room.isBooked()) {
                available.add(room);
            }
        }
        return available;
    }

    public List<Room> bookRooms(int numRooms) {
        List<Room> availableRooms = getAvailableRooms();
        if (availableRooms.size() < numRooms) {
            return Collections.emptyList(); // Not enough rooms available
        }

        availableRooms.sort(Comparator.comparingInt(Room::getFloor)
                .thenComparingInt(Room::getNumber));

        List<Room> selectedRooms = new ArrayList<>();
        for (Room room : availableRooms) {
            if (selectedRooms.size() < numRooms) {
                room.setBooked(true);
                selectedRooms.add(room);
            }
        }
        return selectedRooms;
    }

    public void resetBookings() {
        for (Room room : rooms) {
            room.setBooked(false);
        }
    }
}
