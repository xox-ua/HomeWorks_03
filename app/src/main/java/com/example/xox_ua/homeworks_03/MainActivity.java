package com.example.xox_ua.homeworks_03;

import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toolbar;

public class MainActivity extends AppCompatActivity {
public Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        LinearLayout root = new LinearLayout(this);
        root.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT));
        root.setOrientation(LinearLayout.VERTICAL);
        // фиксируем экран (запрет поворота)
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        root.setBackground(getResources().getDrawable(R.drawable.hw_02));

        // добавляем toolbar
        // хз как его добавить !!!!!!!!!!!!!!!!!!!

        // основной контейнер
        LinearLayout llTotal = new LinearLayout(this);
        llTotal.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT));
        llTotal.setOrientation(LinearLayout.VERTICAL);
        ViewGroup.MarginLayoutParams llParams = (ViewGroup.MarginLayoutParams) llTotal.getLayoutParams();
        llParams.rightMargin = 27;
        llParams.leftMargin = 27;
        llParams.topMargin = 80;
        //llTotal.setBackgroundColor(ContextCompat.getColor(this, R.color.colorGoogle));


        // надпись Hello again
        TextView tvHello = new TextView(this);
        LinearLayout.LayoutParams tvHelloParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        tvHelloParams.topMargin = 30;
        tvHelloParams.gravity = Gravity.CENTER_HORIZONTAL;
        tvHello.setText(R.string.hello);
        tvHello.setTextColor(ContextCompat.getColor(this, R.color.colorWhite));
        tvHello.setTextSize(30);
        tvHello.setLayoutParams(tvHelloParams);
        tvHello.setBackgroundColor(ContextCompat.getColor(this, R.color.colorLime));


        //params.weight = 1.0f;




        // вставляем надпись Hello в контейнер Total
        llTotal.addView(tvHello);
        // вставляем контейнер Total в главный контейнер root
        root.addView(llTotal);
        // создаем главный контейнер root
        setContentView(root);
    }
}
