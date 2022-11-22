package com.spring.booking.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
public class RoomReservation {

    @Id
    @GeneratedValue
    private Long id;
    @ManyToOne
    @JsonBackReference(value="room-roomreservation")
    @JoinColumn(name = "room_id")
    private Room room;

    @ManyToOne
    @JsonBackReference(value="reservation-roomreservation")
    @JoinColumn(name = "reservation")
    private Reservation reservation;

    @Column
    private LocalDateTime createdDAte;
    public RoomReservation(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public Reservation getReservation() {
        return reservation;
    }

    public void setReservation(Reservation reservation) {
        this.reservation = reservation;
    }

    public LocalDateTime getCreatedDAte() {
        return createdDAte;
    }

    public void setCreatedDAte(LocalDateTime createdDAte) {
        this.createdDAte = createdDAte;
    }
}
