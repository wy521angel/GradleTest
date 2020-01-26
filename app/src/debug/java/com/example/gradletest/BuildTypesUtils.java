package com.example.gradletest;

import android.app.Activity;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;

public class BuildTypesUtils {
    public static void drawBadge(Activity activity) {
        ViewGroup decorView = (ViewGroup) activity.getWindow().getDecorView();
        View badge = new View(activity);
        badge.setBackgroundColor(Color.GREEN);
        decorView.addView(badge, 200, 50);
    }
}
