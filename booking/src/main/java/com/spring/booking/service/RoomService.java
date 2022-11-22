package com.spring.booking.service;

import com.spring.booking.DTO.AddReservationDTO;
import com.spring.booking.DTO.AddRoomDTO;
import com.spring.booking.DTO.EditPriceRoomDTO;
import com.spring.booking.model.Hotel;
import com.spring.booking.model.Room;
import com.spring.booking.repository.HotelRepository;
import com.spring.booking.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.util.List;

@Service
public class RoomService {
    private RoomRepository roomRepository;
    private HotelRepository hotelRepository;

    public RoomService(RoomRepository roomRepository, HotelRepository hotelRepository) {
        this.roomRepository = roomRepository;
        this.hotelRepository = hotelRepository;
    }


    public Room addRoom(AddRoomDTO addRoomDTO, Long hotelId) {
        Room roomToBeSaved = new Room();
        Hotel foundedHotel = hotelRepository.findById(hotelId).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "the hotel not found"));
        roomToBeSaved.setHotel(foundedHotel);
        roomToBeSaved.setRoomNumber(addRoomDTO.getRoomNumber());
        roomToBeSaved.setPrice(addRoomDTO.getPrice());
        roomToBeSaved.setNumbersOfPersons(addRoomDTO.getNumbersOfPersons());
        return roomRepository.save(roomToBeSaved);
    }

    public List<Room> getAllRoomsByHotel(Long hotelId) {
        Hotel foundedHotel = hotelRepository.findById(hotelId).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "the hotel not found"));
        return roomRepository.findAllByHotel(foundedHotel);
    }

    public Room updatePriceRoom(AddRoomDTO addRoomDTO, Long roomId) {
        Room foundRoom = roomRepository.findById(roomId).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "the room not found"));
        foundRoom.setPrice(addRoomDTO.getPrice());
        return roomRepository.save(foundRoom);
    }

    public void deleteRoom(Long roomId) {
        Room foundRoom = roomRepository.findById(roomId).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "the room not found"));
        roomRepository.delete(foundRoom);
    }




}
