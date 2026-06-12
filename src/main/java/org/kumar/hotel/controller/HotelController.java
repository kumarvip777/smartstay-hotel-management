package org.kumar.hotel.controller;

import org.kumar.hotel.model.Booking;
import org.kumar.hotel.model.Contact;
import org.kumar.hotel.service.BookingService;
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
    private final BookingService bookingService;

    public HotelController(RoomService roomService,
                           BookingService bookingService) {

        this.roomService = roomService;
        this.bookingService = bookingService;
    }

    @GetMapping("/")
    public String home() {
        return "index";
    }

    @GetMapping("/rooms")
    public String rooms(Model model) {

        model.addAttribute("rooms",
                roomService.getAllRooms());

        return "rooms";
    }

    @GetMapping("/booking")
    public String booking(Model model) {

        model.addAttribute("booking", new Booking());

        return "booking";
    }

    @GetMapping("/contact")
    public String contact(Model model) {

        model.addAttribute("contact", new Contact());

        return "contact";
    }

    @PostMapping("/saveBooking")
    public String saveBooking(@ModelAttribute Booking booking,
                              Model model) {

        bookingService.saveBooking(booking);

        model.addAttribute(
                "message",
                "Booking Successful!"
        );

        return "success";
    }

}