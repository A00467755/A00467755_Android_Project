package com.example.hotel_reservation_system;

public class Confirmation {
    private String confirmation_number;

    public Confirmation(String confirmation_number) {
        this.confirmation_number = confirmation_number;
    }

    public String getConfirmation_number() {
        return confirmation_number;
    }

    public void setConfirmation_number(String confirmation_number) {
        this.confirmation_number = confirmation_number;
    }
}