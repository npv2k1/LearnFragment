package com.example.learnfragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.example.learnfragment.adapter.AdapterViewpager;
import com.google.android.material.tabs.TabLayout;

public class Tab extends AppCompatActivity {

    ViewPager viewPager;
    TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab);

        viewPager = findViewById(R.id.viewPager);
        tabLayout = findViewById(R.id.tabLayout);

        AdapterViewpager adapterViewpager = new AdapterViewpager(getSupportFragmentManager(), 3);
        viewPager.setAdapter(adapterViewpager);

        viewPager.setPageTransformer(true, new Animation());

        viewPager.setAdapter(adapterViewpager);

        tabLayout.setupWithViewPager(viewPager);
        tabLayout.getTabAt(0).setIcon(R.drawable.ic_baseline_fastfood_24);

    }

    @Override
    public void onBackPressed() {

        if(viewPager.getCurrentItem() == 0)
            super.onBackPressed();
        else
            viewPager.setCurrentItem(viewPager.getCurrentItem() - 1);

        super.onBackPressed();
    }
}