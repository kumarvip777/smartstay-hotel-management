package org.kumar.hotel.controller;

import org.kumar.hotel.model.Booking;
import org.kumar.hotel.model.Contact;
import org.kumar.hotel.model.Hotel;
import org.kumar.hotel.service.RoomService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HotelController {
    //test

    private final RoomService roomService;

    public HotelController(RoomService roomService) {
        this.roomService = roomService;
    }

    // Common data for all views
    @ModelAttribute
    public void commonData(Model model) {
        Hotel hotel = new Hotel(
                "Royal Stay",
                "ROYALSTAY",
                "Live Inside Pure Luxury",
                "World-class hospitality with modern luxury.",
                "123 Luxury Street, Chennai",
                "+91-9876543210"
        );
        model.addAttribute("hotel", hotel);
    }

    // Home page
    @GetMapping("/")
    public String home() {
        return "index";
    }

    // Rooms page
    @GetMapping("/rooms")
    public String rooms(Model model) {
        model.addAttribute("rooms", roomService.getAllRooms());
        return "rooms";
    }

    // Booking page
    @GetMapping("/booking")
    public String booking(Model model) {
        model.addAttribute("booking", new Booking());
        return "booking";
    }

    @PostMapping("/saveBooking")
    public String saveBooking(@ModelAttribute Booking booking, Model model) {
        System.out.println(booking);
        model.addAttribute("message", "Booking Successful!");
        return "success";
    }

    // Contact page
    @GetMapping("/contact")
    public String contact(Model model) {
        model.addAttribute("contact", new Contact());
        return "contact";
    }

    @PostMapping("/saveContact")
    public String saveContact(@ModelAttribute Contact contact, Model model) {
        System.out.println(contact);
        model.addAttribute("message", "Message Sent Successfully!");
        return "success";
    }
}

