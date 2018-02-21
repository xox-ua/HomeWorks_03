package com.example.xox_ua.homeworks_03;

import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        LinearLayout root = new LinearLayout(this);
        root.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT));


        root.setOrientation(LinearLayout.HORIZONTAL);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);                  // фиксируем экран (запрет поворота)
        root.setBackground(getResources().getDrawable(R.drawable.hw_02));

        /*LinearLayout card1 = new CustomUserLayout(this, null);
        card1.tvText1.setText("aaaaaaa");
        card1.tvText2.setText("vvvvvvv");
        card1.ivPhoto.setBackgroundResource(R.drawable.ic_launcher_background);

        CustomUserLayout card2 = new CustomUserLayout(this, null);
        card2.tvText1.setText("aaaaaaa");
        card2.tvText2.setText("vvvvvvv");
        card2.ivPhoto.setBackgroundResource(R.drawable.ic_launcher_background);
        root.addView(card1);
        root.addView(card2);*/
        setContentView(root);
    }
}
