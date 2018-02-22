package com.example.xox_ua.homeworks_03;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.ProgressBar;
import android.widget.TextView;

public class ProgressBarHorizontalActivity extends AppCompatActivity {
    ProgressBar bar;
    TextView tv_complete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.progress_bar_horizontal);
        // фиксируем экран (запрет поворота)
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        // TOOLBAR добавление кнопки back и её функционала
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.colorFacebook)));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        // ProgressBar Horizontal
        bar = (ProgressBar) findViewById(R.id.progress_bar);
        tv_complete = (TextView) findViewById(R.id.complete);
        ObjectAnimator animation = ObjectAnimator.ofInt(bar, "progress", 0, 100);
        animation.setDuration(3000);
        animation.setInterpolator(new DecelerateInterpolator());
        animation.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animator) {
            }
            @Override
            public void onAnimationEnd(Animator animator) {
                tv_complete.setText(R.string.download_complete);
            }
            @Override
            public void onAnimationCancel(Animator animator) {
            }
            @Override
            public void onAnimationRepeat(Animator animator) {
            }
        });
        animation.start();
    }

    // обработка нажатия на кнопку back toolbar'a
    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}