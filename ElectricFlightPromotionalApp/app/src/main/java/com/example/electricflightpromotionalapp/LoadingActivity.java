package com.example.electricflightpromotionalapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.widget.Toast;

import com.example.electricflightpromotionalapp.api.Flight;
import com.example.electricflightpromotionalapp.api.OpenSkyApi;

import java.io.IOException;
import java.util.Date;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class LoadingActivity extends AppCompatActivity {

    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://opensky-network.org/api/flights/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();
    OpenSkyApi openSkyApi = retrofit.create(OpenSkyApi.class);
    Date date = new Date();
    long carbonAll = 0;
    long end, begin;
    long carbon2hr = 0;
    long carbon2hrsave, carbonallsave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loading);

        date.setHours(0);
        date.setMinutes(0);
        date.setDate(date.getDate() - 1);
        begin = date.getTime() / 1000;
        System.out.println(begin);
        date.setHours(date.getHours() + 2);
        end = date.getTime() / 1000;
        System.out.println(end);
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 12; i++) {
                    Call<Flight[]> call = openSkyApi.getFlights(String.valueOf(begin), String.valueOf(end));
                    int finalI = i;
                    try {
                        Response<Flight[]> response = call.execute();
                        System.out.println("in response");
                        if (!response.isSuccessful()) {
                            System.out.println("in if statement");
                            break;
                        }
                        System.out.println(response.toString());
                        System.out.println("okcheck1");
                        Flight[] data = response.body();
                        System.out.println("okcheck2");
                        System.out.println(data[1].getFirstSeen());
                        for (int j = 0; j < data.length; j++) {
                            long timeFlight = data[j].getLastSeen() - data[j].getFirstSeen();
                            if (timeFlight < 9000)
                                carbonallsave += 115 * 800 * timeFlight;
                            carbonAll += 115 * 200 * timeFlight;
                            if (finalI == 0) {
                                if (timeFlight < 9000)
                                    carbon2hrsave += 115 * 800 * timeFlight;
                                carbon2hr += 115 * 800 * timeFlight;
                            }
                        }
                    } catch (Exception e) {
                        Looper.prepare();
                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                Toast.makeText(LoadingActivity.this, "We are sorry, it seems that the api used in this project has gone to sleep please try again later", Toast.LENGTH_SHORT).show();
                                finishAffinity();
                                System.exit(0);
                            }
                        }, 2000);
                    }
                    date.setHours(date.getHours() + 2);
                    end += 3.6e+6;
                    begin += 3.6e+6;
                }
                Intent intent = new Intent(LoadingActivity.this, HomePage.class);
                intent.putExtra("ALL", carbonAll);
                System.out.println(carbonAll);
                intent.putExtra("HR", carbon2hr / 2);
                intent.putExtra("ALLSAVE", carbonallsave);
                intent.putExtra("HRSAVE", carbon2hrsave / 2);
                intent.putExtra("CARBON", getIntent().getIntExtra("CARBONUSER", 2000));
                startActivity(intent);
                finish();
            }
        };
        new Thread(runnable).start();

//        new Handler().postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                startActivity(new Intent(LoadingActivity.this, HomePage.class));
//                finish();
//            }
//        }, 5000);
    }
}