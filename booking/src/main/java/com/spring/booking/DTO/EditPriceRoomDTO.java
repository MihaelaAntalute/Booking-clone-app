package com.spring.booking.DTO;

public class EditPriceRoomDTO {
    private Integer price;


    public EditPriceRoomDTO(Integer price) {
        this.price = price;
    }
    public Integer getPrice() {
        return price;
    }
    public void setPrice(Integer price) {
        this.price = price;
    }


}
