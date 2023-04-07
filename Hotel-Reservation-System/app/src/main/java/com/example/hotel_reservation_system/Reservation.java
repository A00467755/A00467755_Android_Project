package com.example.hotel_reservation_system;


import java.util.List;

public class Reservation {
    private String hotel_name;
    private String checkin;
    private String checkout;
    private List<Guest> guest_list;

    public Reservation(String hotel_name, String checkin, String checkout, List<Guest> guest_list) {
        this.hotel_name = hotel_name;
        this.checkin = checkin;
        this.checkout = checkout;
        this.guest_list = guest_list;
    }

    public String getHotel_name() {
        return hotel_name;
    }

    public String getCheckin() {
        return checkin;
    }

    public String getCheckout() {
        return checkout;
    }

    public List<Guest> getGuest_list() {
        return guest_list;
    }

    public void setHotel_name(String hotel_name) {
        this.hotel_name = hotel_name;
    }

    public void setCheckin(String checkin) {
        this.checkin = checkin;
    }

    public void setCheckout(String checkout) {
        this.checkout = checkout;
    }

    public void setGuest_list(List<Guest> guest_list) {
        this.guest_list = guest_list;
    }
}