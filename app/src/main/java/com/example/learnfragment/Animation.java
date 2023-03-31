package com.example.learnfragment;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.ViewPager;

public class Animation implements ViewPager.PageTransformer {
    @Override
    public void transformPage(@NonNull View page, float position) {
        if (position < -1) {
            page.setAlpha(0);
        } else if (position <= 1) {
            page.setAlpha(1);
            page.setTranslationX(-position * page.getWidth());
            float yPosition = position * page.getHeight();
            page.setTranslationY(yPosition);
        } else {
            page.setAlpha(0);
        }
    }
}
