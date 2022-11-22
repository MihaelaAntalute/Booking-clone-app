package com.spring.booking.DTO;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;
import java.util.List;

public class AddReservationDTO {

    private List<Long> roomsIds;
    @JsonFormat(pattern="yyyy-MM-dd")
    private LocalDateTime checkIn;

    private LocalDateTime checkOut;

    public AddReservationDTO( List<Long> roomsIds, LocalDateTime checkIn, LocalDateTime checkOut) {
        this.roomsIds = roomsIds;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }

    public LocalDateTime getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(LocalDateTime checkIn) {
        this.checkIn = checkIn;
    }

    public LocalDateTime getCheckOut() {
        return checkOut;
    }

    public void setCheckOut(LocalDateTime checkOut) {
        this.checkOut = checkOut;
    }



    public List<Long> getRoomsIds() {
        return roomsIds;
    }

    public void setRoomsIds(List<Long> roomsIds) {
        this.roomsIds = roomsIds;
    }



}
