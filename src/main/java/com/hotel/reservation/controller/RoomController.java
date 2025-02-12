package com.hotel.reservation.controller;

import com.hotel.reservation.model.Room;
import com.hotel.reservation.service.RoomService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rooms")
@CrossOrigin(origins = "*")
public class RoomController {
    private final RoomService roomService;

    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }

    @GetMapping("/available")
    public List<Room> getAvailableRooms() {
        return roomService.getAvailableRooms();
    }

    @PostMapping("/book/{numRooms}")
    public List<Room> bookRooms(@PathVariable int numRooms) {
        return roomService.bookRooms(numRooms);
    }

    @PostMapping("/reset")
    public void resetBookings() {
        roomService.resetBookings();
    }
}
