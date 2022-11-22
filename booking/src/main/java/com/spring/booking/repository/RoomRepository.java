package com.spring.booking.repository;

import com.spring.booking.model.Hotel;
import com.spring.booking.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoomRepository extends JpaRepository<Room,Long> {

    List<Room>findAllByHotel(Hotel hotel);
}
