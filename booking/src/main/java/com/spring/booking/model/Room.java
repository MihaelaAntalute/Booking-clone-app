package com.spring.booking.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.List;

@Entity
public class Room {
    @Id
    @GeneratedValue
    private long id;
    @Column
     private  String roomNumber;
    @Column
     private Integer price;
    @Column
     private Integer numbersOfPersons;

    @OneToMany(mappedBy = "room",cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JsonManagedReference(value="room-roomreservation")
     private List<RoomReservation> reservationList;
     @ManyToOne
     @JsonBackReference(value="hotel-room")
    @JoinColumn(name = "hotel_id")
    private Hotel hotel;
     public Room(){}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getNumbersOfPersons() {
        return numbersOfPersons;
    }

    public void setNumbersOfPersons(Integer numbersOfPersons) {
        this.numbersOfPersons = numbersOfPersons;
    }

    public List<RoomReservation> getReservationList() {
        return reservationList;
    }

    public void setReservationList(List<RoomReservation> reservationList) {
        this.reservationList = reservationList;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }
}
