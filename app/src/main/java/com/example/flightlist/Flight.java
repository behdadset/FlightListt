package com.example.flightlist;

import com.google.gson.annotations.SerializedName;


public class Flight {
    @SerializedName("id")
    public int id;

    @SerializedName("departure_date")
    String departure_date;

    @SerializedName("airline_code")
    String airline_code;

    @SerializedName("flight_number")
    String flight_number;

    @SerializedName("departure_city")
    String departure_city;

    @SerializedName("departure_airport")
    String departure_airport;

    @SerializedName("arrival_city")
    String arrival_city;

    @SerializedName("arrival_airport")
    String arrival_airport;

    @SerializedName("scheduled_duration")
    String scheduled_duration;

    @SerializedName("arrival_date")
    String arrival_date;

}
