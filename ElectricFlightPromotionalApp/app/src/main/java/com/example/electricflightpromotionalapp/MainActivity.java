package com.example.electricflightpromotionalapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.transition.ChangeBounds;
import android.transition.Transition;
import android.transition.TransitionManager;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.widget.Button;
import android.widget.EditText;

import com.example.electricflightpromotionalapp.adapters.PagerAdapter;
import com.example.electricflightpromotionalapp.fragments.OnBoardingFragment2;
import com.example.electricflightpromotionalapp.fragments.OnboardingFragment1;
import com.example.electricflightpromotionalapp.fragments.OnboardingFragment3;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {
    ViewPager pager;
    PagerAdapter adapter;
    TabLayout tabLayout;
    ConstraintSet oldset = new ConstraintSet(), newset = new ConstraintSet();
    ConstraintLayout layout;
    EditText answer;
    Button continuebtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pager = findViewById(R.id.onBoardingViewPager);
        layout = findViewById(R.id.constraintlayout1);
        oldset.clone(layout);
        answer = findViewById(R.id.carbonFirstAnswer);
        continuebtn = findViewById(R.id.continuebtn);
        newset.clone(this, R.layout.activity_main_alt);
        tabLayout = findViewById(R.id.onBoardingTabLayout);
        adapter = new PagerAdapter(getSupportFragmentManager(), FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        pager.setAdapter(adapter);
        tabLayout.setupWithViewPager(pager);
        adapter.AddFragment(new OnboardingFragment1());
        adapter.AddFragment(new OnBoardingFragment2());
        adapter.AddFragment(new OnboardingFragment3(this));
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
                int carbon = calculateCarbon();
                if(carbon == -1){
                    answer.setError("Please enter a valid number");
                    return;
                }
                destroyAndStartNewActivity(carbon);
            }
        });
    }

    public void animationCommence() {
        Transition transition = new ChangeBounds();
        transition.setInterpolator(new LinearInterpolator());
        transition.setDuration(1000);
        TransitionManager.beginDelayedTransition(layout);
        newset.applyTo(layout);
    }

    public int calculateCarbon(){
        String answerText = answer.getText().toString();
        if(!answerText.isEmpty()){
            return 115*((Integer.parseInt(answerText))*500);
        }
        return -1;
    }

    public void destroyAndStartNewActivity(int carbon){
        Intent intent = new Intent(this, CarbonCalculatorResult.class);
        intent.putExtra("CARBON", carbon);
        startActivity(intent);
        finish();
    }
}