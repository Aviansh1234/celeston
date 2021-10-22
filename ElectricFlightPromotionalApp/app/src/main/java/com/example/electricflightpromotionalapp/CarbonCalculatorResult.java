package com.example.electricflightpromotionalapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.electricflightpromotionalapp.adapters.PagerAdapter;
import com.example.electricflightpromotionalapp.fragments.CarbonCalcResult1;
import com.example.electricflightpromotionalapp.fragments.CarbonCalcResult2;
import com.google.android.material.tabs.TabLayout;

public class CarbonCalculatorResult extends AppCompatActivity {

    ViewPager pager;
    PagerAdapter adapter;
    TabLayout tabLayout;
    int carbon;
    TextView data;
    Button continuebtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carbon_calculator_result);

        carbon = getIntent().getIntExtra("CARBON", 2000);
        data = findViewById(R.id.tvOutput);
        continuebtn = findViewById(R.id.continuebtn2);
        data.setText(String.valueOf(carbon));
        pager = findViewById(R.id.resultPager);
        tabLayout = findViewById(R.id.resultTabLayout);
        adapter = new PagerAdapter(getSupportFragmentManager(), FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        pager.setAdapter(adapter);
        tabLayout.setupWithViewPager(pager);
        adapter.AddFragment(new CarbonCalcResult1(carbon));
        adapter.AddFragment(new CarbonCalcResult2());
        adapter.notifyDataSetChanged();
        for (int i = 0; i < tabLayout.getTabCount(); i++) {
            View tab = ((ViewGroup) tabLayout.getChildAt(0)).getChildAt(i);
            ViewGroup.MarginLayoutParams p = (ViewGroup.MarginLayoutParams) tab.getLayoutParams();
            p.setMargins(20, 0, 20, 0);
            tab.requestLayout();
        }
        continuebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CarbonCalculatorResult.this, LoadingActivity.class);
                intent.putExtra("CARBONUSER", carbon);
                startActivity(intent);
                finish();
            }
        });
    }
}