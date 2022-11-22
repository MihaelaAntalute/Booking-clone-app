package com.spring.booking.controller;

import com.spring.booking.DTO.AddReservationDTO;
import com.spring.booking.DTO.AddRoomDTO;
import com.spring.booking.DTO.EditPriceRoomDTO;
import com.spring.booking.model.Room;
import com.spring.booking.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/room")
public class RoomController {
    private RoomService roomService;

    @Autowired
    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }

    @PostMapping("/add/{hotelId}")
    public Room addRoom(@RequestBody AddRoomDTO addRoomDTO, @PathVariable Long hotelId) {
        return roomService.addRoom(addRoomDTO, hotelId);
    }


    @GetMapping("/{hotelId}")
    public List<Room> getAllRoomsByHotel(@PathVariable Long hotelId) {
        return roomService.getAllRoomsByHotel(hotelId);
    }

    @DeleteMapping("/delete/{roomId}")
    public void deleteRoom(@PathVariable Long roomId) {
        roomService.deleteRoom(roomId);
    }

    @PutMapping("/update/{roomId}")
    public Room updatePriceRoom(@RequestBody AddRoomDTO addRoomDTO, @PathVariable Long roomId) {
        return roomService.updatePriceRoom(addRoomDTO, roomId);
    }



//Sa vada cate camere sunt libere/ocupate pentru o anumita perioada

//Sa vada care este pretul obtinut din toate rezervarile dintr-o anumita perioada

}

