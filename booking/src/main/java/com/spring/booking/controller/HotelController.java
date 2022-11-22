package com.spring.booking.controller;

import com.spring.booking.model.Hotel;
import com.spring.booking.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hotel")
public class HotelController {
    private HotelService hotelService;

    @Autowired
    public HotelController(HotelService hotelService) {
        this.hotelService = hotelService;
    }

    @PostMapping("/add")
    public Hotel addHotel(@RequestBody Hotel hotel){
        return hotelService.addHotel(hotel);
    }

    @GetMapping("/")
    public List<Hotel> getAllHotels(){
        return hotelService.getAllHotels();
    }

//    @PutMapping("/update/{hatelId}")
//    public Hotel updateHotel(@RequestBody Hotel hotel,@PathVariable){
//        return hotelService.
//    }


}
