package com.hotel.reservation.controller;

import com.hotel.reservation.model.Room;
import com.hotel.reservation.service.RoomService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class RoomController {

    @Autowired
    private RoomService roomService;

    @GetMapping("/")
    public String showRoomAvailability(Model model) {
        List<Room> availableRooms = roomService.getAvailableRooms();
        model.addAttribute("availableRooms", availableRooms);
        return "index";  // Thymeleaf template
    }

    @PostMapping("/bookRooms")
    public String bookRooms(@RequestParam("numOfRooms") int numOfRooms, Model model) {
        String result = roomService.bookRooms(numOfRooms);
        model.addAttribute("result", result);
        return "redirect:/";
    }

    @PostMapping("/generateOccupancy")
    public String generateRandomOccupancy(Model model) {
        roomService.generateRandomOccupancy();
        return "redirect:/";
    }

    @PostMapping("/resetBooking")
    public String resetBooking(Model model) {
        roomService.resetBookings();
        return "redirect:/";
    }
}
