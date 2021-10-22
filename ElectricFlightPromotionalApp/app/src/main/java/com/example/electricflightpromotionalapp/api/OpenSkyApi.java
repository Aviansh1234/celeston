package com.example.electricflightpromotionalapp.api;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface OpenSkyApi {
    @GET("all?")
    Call<Flight[]>getFlights(@Query("begin")String begin, @Query("end")String end);
}
