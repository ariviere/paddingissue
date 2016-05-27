package com.ar.modifypaddingissue;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewTreeObserver;

public class MainActivity extends AppCompatActivity implements MyFragment.Listener {

    private View dummyText;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dummyText = findViewById(R.id.dummy_text);
        viewPager = (ViewPager) findViewById(R.id.viewPager);

        dummyText.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() {
            @Override
            public boolean onPreDraw() {
                dummyText.getViewTreeObserver().removeOnPreDrawListener(this);
                viewPager.setPadding(0, dummyText.getHeight(), 0, 0);
                return false;
            }
        });

        viewPager.setAdapter(new MyPagerAdapter(getSupportFragmentManager(), this));
    }

    @Override
    public void onScrollY(int y) {
        int newRecyclerPaddingTop = viewPager.getPaddingTop() - y;

        if (newRecyclerPaddingTop <= 0) {
            newRecyclerPaddingTop = 0;
        } else if (newRecyclerPaddingTop >= dummyText.getHeight()) {
            newRecyclerPaddingTop = dummyText.getHeight();
        }

        viewPager.setPadding(0, newRecyclerPaddingTop, 0, 0);
    }
}
