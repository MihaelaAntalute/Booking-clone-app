package com.spring.booking.service;

import com.spring.booking.DTO.AddReservationDTO;
import com.spring.booking.model.*;
import com.spring.booking.repository.ReservationRepository;
import com.spring.booking.repository.RoomRepository;
import com.spring.booking.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class ReservationService {
    private ReservationRepository reservationRepository;
    private RoomRepository roomRepository;
    private UserRepository userRepository;

    @Autowired
    public ReservationService(RoomRepository roomRepository, ReservationRepository reservationRepository, UserRepository userRepository) {
        this.roomRepository = roomRepository;
        this.userRepository = userRepository;
        this.reservationRepository = reservationRepository;
    }

    public Reservation addReservation(AddReservationDTO addReservationDTO) {
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User foundUser = userRepository.findUserByUsername(userDetails.getUsername()).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "user not found"));
        Reservation reservation = new Reservation();
        reservation.setCheckIn(addReservationDTO.getCheckIn());
        reservation.setCheckOut(addReservationDTO.getCheckOut());
        reservation.setUser(foundUser);
        addReservationDTO.getRoomsIds().forEach(roomId -> {
            Room currentRoom = roomRepository.findById(roomId).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "room not found"));
            RoomReservation roomReservation = new RoomReservation();
            roomReservation.setReservation(reservation);
            roomReservation.setRoom(currentRoom);
            roomReservation.setCreatedDAte(LocalDateTime.now());
            reservation.getRoomReservationList().add(roomReservation);
        });
        return reservationRepository.save(reservation);
    }

    public List<Room> getAvailableRooms(LocalDate startDate, LocalDate endDate, Integer numberOfPersons) {
        //ma duc prin toate hotelurile
        //ma duc prin toate camerele de la fiecare hotel
        //pentru o camera ma duc prin toate rezervarile
        //verific daca exista cel putin o rezervare care interfereaza cu startDate si endDate
        //o rezervare interfereaza cu sD si eD daca are checkin intre sD si eD sau daca are checkout intre sD si eD
        //daca nicio rezervare nu interfereaza cu sD si eD pentru camera curenta, adaug camera in lista rezultat (inseamna ca e available)
        return null;
    }

    //1.caut hotelul
    //2.la hotelul gasit verific daca pt data cautata ce camere sunt disponibile
//    public List<Room> getAvailableRooms(Long hotelId, LocalDate date) {
//     //   Hotel foundedHotel = hotelRepository.findById(hotelId).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "the hotel not found"));
//
//    }


}
