package com.example.xox_ua.homeworks_03;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

public class MainActivity extends AppCompatActivity {
public Toolbar mToolbar;
public Button btnGoogle;
public Button btnFacebook;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        LinearLayout root = new LinearLayout(this);
        root.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT));
        root.setOrientation(LinearLayout.VERTICAL);
        // фиксируем экран (запрет поворота)
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        root.setBackground(getResources().getDrawable(R.drawable.hw_02orig));

        // добавляем toolbar
        // хз как его добавить !!!!!!!!!!!!!!!!!!!

        // основной контейнер
        LinearLayout llTotal = new LinearLayout(this);
        llTotal.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT));
        llTotal.setOrientation(LinearLayout.VERTICAL);
        ViewGroup.MarginLayoutParams llParams = (ViewGroup.MarginLayoutParams) llTotal.getLayoutParams();
        llParams.rightMargin = 50;
        llParams.leftMargin = 50;
        llParams.topMargin = 0;
        // фон для понимания размеров слоя
        //llTotal.setBackgroundColor(0xFF76eec6);

        // надпись Hello again
        TextView tvHello = new TextView(this);
        LinearLayout.LayoutParams tvHelloParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT);
        tvHelloParams.topMargin = 10;
        tvHelloParams.gravity = Gravity.CENTER_HORIZONTAL;
        tvHello.setText(R.string.hello);
        tvHello.setTextColor(ContextCompat.getColor(this, R.color.colorWhite));
        tvHello.setTextSize(30);
        tvHello.setLayoutParams(tvHelloParams);
        // фон для понимания размеров слоя
        //tvHello.setBackgroundColor(0xFF8a2be2);

        // надпись Sign in
        TextView tvSignIn = new TextView(this);
        LinearLayout.LayoutParams tvSignInParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT);
        tvSignInParams.topMargin = 50;
        tvSignInParams.gravity = Gravity.START;
        tvSignIn.setText(R.string.sign_in);
        tvSignIn.setTextColor(ContextCompat.getColor(this, R.color.colorWhite));
        tvSignIn.setTextSize(19);
        tvSignIn.setLayoutParams(tvSignInParams);
        // фон для понимания размеров слоя
        //tvSignIn.setBackgroundColor(0xFFeedfcc);

        // контейнер с кнопками Google и Facebook
        LinearLayout llGoFa = new LinearLayout(this);
        llGoFa.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, 94));
        llGoFa.setOrientation(LinearLayout.HORIZONTAL);
        ViewGroup.MarginLayoutParams llGoFaParams = (ViewGroup.MarginLayoutParams) llGoFa.getLayoutParams();
        llGoFaParams.topMargin = 20;
        // фон для понимания размеров слоя
        //llGoFa.setBackgroundColor(ContextCompat.getColor(this, R.color.colorLime));

        // кнопка Google
        btnGoogle = new Button(this);
        btnGoogle.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT, 1));
        ViewGroup.MarginLayoutParams btnGoogleParams = (ViewGroup.MarginLayoutParams) btnGoogle.getLayoutParams();
        btnGoogleParams.rightMargin = 10;
        Drawable imgGoogle = this.getResources().getDrawable(R.drawable.btn_google);
        imgGoogle.setBounds( 0, 0, 94, 94 );                          //гарницы картинки: отступ, отступ, размер, размер
        btnGoogle.setCompoundDrawables( imgGoogle, null, null, null );
        btnGoogle.setText(R.string.google);
        btnGoogle.setTextColor(ContextCompat.getColor(this, R.color.colorWhite));
        btnGoogle.setTextSize(TypedValue.COMPLEX_UNIT_SP, 18f);
        btnGoogle.setTypeface(btnGoogle.getTypeface(), Typeface.BOLD);
        btnGoogle.setLayoutParams(btnGoogleParams);
        btnGoogle.setBackgroundColor(ContextCompat.getColor(this, R.color.colorGoogle));
        // нажатие на кнопку Google - запуск активности с кастомным ProgressBar'ом
        btnGoogle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ProgressBarRoundActivity.class);
                startActivityForResult(intent, 1);
                Toast.makeText(getApplicationContext(), R.string.google, Toast.LENGTH_SHORT).show();
            }
        });

        // кнопка Facebook
        btnFacebook = new Button(this);
        btnFacebook.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT, 1));
        ViewGroup.MarginLayoutParams btnFacebookParams = (ViewGroup.MarginLayoutParams) btnFacebook.getLayoutParams();
        btnFacebookParams.leftMargin = 10;
        Drawable imgFacebook = this.getResources().getDrawable(R.drawable.btn_facebook);
        imgFacebook.setBounds( 0, 0, 94, 94 );                          //гарницы картинки: отступ, отступ, размер, размер
        btnFacebook.setCompoundDrawables( imgFacebook, null, null, null );
        btnFacebook.setText(R.string.facebook);
        btnFacebook.setTextColor(ContextCompat.getColor(this, R.color.colorWhite));
        btnFacebook.setTextSize(TypedValue.COMPLEX_UNIT_SP, 18f);
        btnFacebook.setTypeface(btnFacebook.getTypeface(), Typeface.BOLD);
        btnFacebook.setLayoutParams(btnFacebookParams);
        btnFacebook.setBackgroundColor(ContextCompat.getColor(this, R.color.colorFacebook));
        // нажатие на кнопку Facebook - запуск активности с кастомным горизонтальным ProgressBar'ом
        btnFacebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ProgressBarHorizontalActivity.class);
                startActivityForResult(intent, 1);
                Toast.makeText(getApplicationContext(), R.string.facebook, Toast.LENGTH_SHORT).show();
            }
        });

        // контейнер "OR"





        // вставляем надпись "Hello" в контейнер Total
        llTotal.addView(tvHello);
        // вставляем надпись "Sign in" в контейнер Total
        llTotal.addView(tvSignIn);
        // вставляем надпись контейнер с кнопками Google и Facebook в контейнер Total
        llTotal.addView(llGoFa);
        // вставляем кнопку Google в контейнер GoogleFacebook
        llGoFa.addView(btnGoogle);
        // вставляем кнопку Facebook в контейнер GoogleFacebook
        llGoFa.addView(btnFacebook);

        // вставляем контейнер Total в главный контейнер root
        root.addView(llTotal);

        // создаем главный контейнер root
        setContentView(root);
    }
}
