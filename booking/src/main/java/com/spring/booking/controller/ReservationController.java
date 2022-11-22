package com.spring.booking.controller;

import com.spring.booking.DTO.AddReservationDTO;
import com.spring.booking.model.Reservation;
import com.spring.booking.model.Room;
import com.spring.booking.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/reservation")

public class ReservationController {

    private ReservationService reservationService;


    @Autowired
    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @PostMapping("/add")
    public Reservation addReservation(@RequestBody AddReservationDTO addReservationDTO) {
        return reservationService.addReservation(addReservationDTO);
    }
    @GetMapping("/availability/")
    public List<Room> getAvailableRooms(LocalDate startDate, LocalDate endDate, Integer numberOfPersons){
        //1. de facut un DTO ca sa prindem informatiile startDate, endDate, numberOfpersons
        return reservationService.getAvailableRooms(startDate, endDate, numberOfPersons);
    }





}
