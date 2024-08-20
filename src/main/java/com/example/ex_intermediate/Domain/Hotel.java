package com.example.ex_intermediate.Domain;

/**
 * ホテルのドメインクラス
 */
public class Hotel {
    private String hotel_name;
    private String nearest_station;
    private Integer price;

    @Override
    public String toString() {
        return "Hotel [hotel_name=" + hotel_name + ", nearest_station=" + nearest_station + ", price=" + price + "]";
    }
    public void setHotel_name(String hotel_name) {
        this.hotel_name = hotel_name;
    }
    public void setNearest_station(String nearest_station) {
        this.nearest_station = nearest_station;
    }
    public void setPrice(Integer price) {
        this.price = price;
    }
    public String getHotel_name() {
        return hotel_name;
    }
    public String getNearest_station() {
        return nearest_station;
    }
    public Integer getPrice() {
        return price;
    }

}
