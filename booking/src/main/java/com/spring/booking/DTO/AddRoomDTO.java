package com.spring.booking.DTO;

public class AddRoomDTO {

    private Long hotelId;

    private String roomNumber;

    private Integer price;

    private Integer numbersOfPersons;

    public AddRoomDTO(Long hotelId, String roomNumber, Integer price, Integer numbersOfPersons) {
        this.hotelId = hotelId;
        this.roomNumber = roomNumber;
        this.price = price;
        this.numbersOfPersons = numbersOfPersons;
    }

    public Long getHotelId() {
        return hotelId;
    }

    public void setHotelId(Long hotelId) {
        this.hotelId = hotelId;
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

}
