package org.kumar.hotel.controller;

import jakarta.validation.Valid;
import org.kumar.hotel.model.Booking;
import org.kumar.hotel.model.Contact;
import org.kumar.hotel.service.BookingService;
import org.kumar.hotel.service.ContactService;
import org.kumar.hotel.service.RoomService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HotelController {
    // Feature A Change

    private final RoomService roomService;
    private final BookingService bookingService;
    private final ContactService contactService;

    public HotelController(RoomService roomService,
                           BookingService bookingService,
                           ContactService contactService) {

        this.roomService = roomService;
        this.bookingService = bookingService;
        this.contactService = contactService;
    }

    // Home Page
    @GetMapping("/")
    public String home() {
        return "index";
    }

    // Rooms Page
    @GetMapping("/rooms")
    public String rooms(Model model) {

        model.addAttribute(
                "rooms",
                roomService.getAllRooms()
        );

        return "rooms";
    }

    // Booking Page
    @GetMapping("/booking")
    public String booking(Model model) {

        model.addAttribute(
                "booking",
                new Booking()
        );

        return "booking";
    }

    // Save Booking
    @PostMapping("/saveBooking")
    public String saveBooking(@Valid @ModelAttribute Booking booking,
                              BindingResult result,
                              Model model) {

        if (result.hasErrors()) {
            return "booking";
        }

        bookingService.saveBooking(booking);

        model.addAttribute(
                "message",
                "Booking Successful!"
        );

        return "success";
    }

    // Contact Page
    @GetMapping("/contact")
    public String contact(Model model) {

        model.addAttribute(
                "contact",
                new Contact()
        );

        return "contact";
    }

    // Save Contact
    @PostMapping("/saveContact")
    public String saveContact(@Valid @ModelAttribute Contact contact,
                              BindingResult result,
                              Model model) {

        if (result.hasErrors()) {
            return "contact";
        }

        contactService.saveContact(contact);

        model.addAttribute(
                "message",
                "Message Sent Successfully!"
        );

        return "success";
    }

    // View All Bookings
    @GetMapping("/bookings")
    public String bookings(Model model) {

        model.addAttribute(
                "bookings",
                bookingService.getAllBookings()
        );

        return "bookings";
    }
}