package com.spring.booking.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Reservation {
    @Id
    @GeneratedValue
    private Long id;

    @Column
    private LocalDateTime checkIn;

    @Column
    private LocalDateTime checkOut;

    @ManyToOne
    @JsonBackReference(value="user-reservation")
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "reservation",cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JsonManagedReference(value="reservation-roomreservation")
    private List<RoomReservation> roomReservationList;

    public Reservation(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<RoomReservation> getRoomReservationList() {
        if(this.roomReservationList == null){
            this.roomReservationList = new ArrayList<>();
        }
        return roomReservationList;
    }

    public void setRoomReservationList(List<RoomReservation> reservationList) {
        this.roomReservationList = reservationList;
    }
}
