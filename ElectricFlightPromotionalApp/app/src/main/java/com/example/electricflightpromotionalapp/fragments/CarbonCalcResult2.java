package com.example.electricflightpromotionalapp.fragments;

import android.graphics.Typeface;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.StyleSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.electricflightpromotionalapp.R;

public class CarbonCalcResult2 extends Fragment {


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    TextView textView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_carbon_calc_result2, container, false);
        textView = view.findViewById(R.id.amounttvresult2);
        String text = "Electric planes could have travelled you the same distance but with 0 carbon dioxide emmision.";
        SpannableString ss = new SpannableString(text);
        StyleSpan boldSpan = new StyleSpan(Typeface.BOLD);
        ss.setSpan(boldSpan, 68, 69, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        textView.setText(ss);
        return view;
    }
}