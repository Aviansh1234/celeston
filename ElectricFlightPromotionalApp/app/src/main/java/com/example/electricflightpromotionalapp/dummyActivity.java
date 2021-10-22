package com.example.electricflightpromotionalapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.electricflightpromotionalapp.api.Flight;
import com.example.electricflightpromotionalapp.api.OpenSkyApi;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class dummyActivity extends AppCompatActivity {

    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://opensky-network.org/api/flights/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();
    OpenSkyApi openSkyApi = retrofit.create(OpenSkyApi.class);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dummy);

        Call<Flight[]>call = openSkyApi.getFlights(getResources().getString(R.string.dummy2), getResources().getString(R.string.dummy1));
        call.enqueue(new Callback<Flight[]>() {
            @Override
            public void onResponse(Call<Flight[]> call, Response<Flight[]> response) {
                System.out.println("in response");
                if (!response.isSuccessful()){
                    System.out.println("in if statement");
                    return;
                }
                System.out.println(response.toString());
                System.out.println("okcheck1");
                Flight[] data =response.body();
                System.out.println("okcheck2");
                System.out.println(data[1].getFirstSeen());
            }

            @Override
            public void onFailure(Call<Flight[]> call, Throwable t) {
                System.out.println("error: "+t.getMessage());
            }
        });
    }
}