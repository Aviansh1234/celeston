package com.example.electricflightpromotionalapp.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.electricflightpromotionalapp.R;

public class CarbonCalcResult1 extends Fragment {

    private int carbon;
    public CarbonCalcResult1(int carbon) {
        this.carbon = carbon;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_carbon_calc_result1, container, false);
        TextView tv1 = view.findViewById(R.id.amounttvresult), tv2 = view.findViewById(R.id.similaritytvresult);
        tv1.setText("The total carbon footprint emitted by you by travelling short distances via cumbustion planes is "+String.valueOf(carbon)+"g");
        int carkm = (carbon/115)*30;
        tv2.setText("This carbon footprint is similar to you travelling " +String.valueOf(carkm)+ " kms via a petrol car.");
        return view;
    }
}