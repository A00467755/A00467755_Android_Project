package com.example.hotel_reservation_system;

public class Guest {
    private String guest_name;
    private String gender;
    public Guest(String guest_name, String gender) {
        this.guest_name = guest_name;
        this.gender = gender;
    }

    public String getGuest_name() {
        return guest_name;
    }

    public void setGuest_name(String guest_name) {
        this.guest_name = guest_name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}