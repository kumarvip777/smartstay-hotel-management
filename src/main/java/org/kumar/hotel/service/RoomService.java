package org.kumar.hotel.service;

import org.kumar.hotel.model.Room;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RoomService {

    public List<Room> getAllRooms() {

        List<Room> roomList = new ArrayList<>();

        roomList.add(
                new Room(
                        null,
                        "Deluxe Room",
                        "AC",
                        5000,
                        "/images/room1.jpg"
                )
        );

        roomList.add(
                new Room(
                        null,
                        "Luxury Suite",
                        "Premium",
                        8500,
                        "/images/room2.jpg"
                )
        );

        roomList.add(
                new Room(
                        null,
                        "Single Room",
                        "Non AC",
                        2500,
                        "/images/room3.jpg"
                )
        );

        return roomList;
    }
}