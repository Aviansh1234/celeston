package com.example.electricflightpromotionalapp.fragments;

import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.electricflightpromotionalapp.MainActivity;
import com.example.electricflightpromotionalapp.R;

public class OnboardingFragment3 extends Fragment {
    MainActivity parent;
    public OnboardingFragment3(MainActivity parent) {
        this.parent = parent;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_onboarding3, container, false);
        Button continuebtn = view.findViewById(R.id.continueFragmentbtn);
        continuebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                parent.animationCommence();
            }
        });
        return view;
    }
}