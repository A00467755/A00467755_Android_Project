package com.example.hotel_reservation_system;

import java.util.List;


import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.POST;
import retrofit.http.Body;

public interface ApiInterface {

    // API's endpoints

    // Get hotel list
    @GET("/hotel")
    public void getHotelsLists(Callback<List<HotelListData>> callback);

    // Make a reservation
    @POST("/reservation")
    public void createReservation(
            @Body Reservation reservation, Callback<Confirmation> callback);
}
