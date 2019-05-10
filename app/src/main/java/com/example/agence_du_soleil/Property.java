package com.example.agence_du_soleil;

import java.util.Date;

public class Property {

    private double price;
    private String name;
    private int id;
    private String type;
    private String city;
    private String address1;
    private String address2;
    private String district;
    private double surface;
    private int rooms;
    private Date date;
    private int cp;

    public Property(double price, String name, int id, String type, String city, String address1, String address2, String district, double surface, int rooms, Date date, int cp){
        this.price = price;
        this.name = name;
        this.id = id;
        this.type = type;
        this.city = city;
        this.address1 = address1;
        this.address2 = address2;
        this.district = district;
        this.surface = surface;
        this.rooms = rooms;
        this.date = date;
        this.cp = cp;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public double getSurface() {
        return surface;
    }

    public void setSurface(double surface) {
        this.surface = surface;
    }

    public int getRooms() {
        return rooms;
    }

    public void setRooms(int rooms) {
        this.rooms = rooms;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getCp() {
        return cp;
    }

    public void setCp(int cp) {
        this.cp = cp;
    }
}
