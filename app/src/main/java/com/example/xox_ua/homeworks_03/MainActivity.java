package com.example.xox_ua.homeworks_03;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.text.TextUtils;
import android.text.method.PasswordTransformationMethod;
import android.util.Log;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

public class MainActivity extends AppCompatActivity {
public Toolbar mToolbar;
public Button btnGoogle;
public Button btnFacebook;
public Button btnPass;
public Button btnLogIn;
public EditText etMail;
public EditText etPass;
public int passIndex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        LinearLayout root = new LinearLayout(this);
        root.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT));
        root.setOrientation(LinearLayout.VERTICAL);
        // фиксируем экран (запрет поворота)
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        root.setBackground(getResources().getDrawable(R.drawable.hw_02));

        // TOOLBAR добавление кнопки back и её функционала
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        // основной контейнер
        LinearLayout llTotal = new LinearLayout(this);
        llTotal.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT));
        llTotal.setOrientation(LinearLayout.VERTICAL);
        ViewGroup.MarginLayoutParams llParams = (ViewGroup.MarginLayoutParams) llTotal.getLayoutParams();
        llParams.rightMargin = 50;
        llParams.leftMargin = 50;
        llParams.topMargin = 0;


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

        // контейнер с кнопками Google и Facebook
        LinearLayout llGoFa = new LinearLayout(this);
        llGoFa.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, 94));
        llGoFa.setOrientation(LinearLayout.HORIZONTAL);
        ViewGroup.MarginLayoutParams llGoFaParams = (ViewGroup.MarginLayoutParams) llGoFa.getLayoutParams();
        llGoFaParams.topMargin = 20;

        // кнопка Google
        btnGoogle = new Button(this);
        btnGoogle.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT, 1));
        ViewGroup.MarginLayoutParams btnGoogleParams = (ViewGroup.MarginLayoutParams) btnGoogle.getLayoutParams();
        btnGoogleParams.rightMargin = 10;
        Drawable imgGoogle = this.getResources().getDrawable(R.drawable.btn_google);
        imgGoogle.setBounds( -20, 0, 74, 94 );                          //гарницы картинки: отступ, отступ, размер, размер
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
        imgFacebook.setBounds( -20, 0, 74, 94 );                          //гарницы картинки: отступ, отступ, размер, размер
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
        LinearLayout llOr = new LinearLayout(this);
        llOr.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT));
        llOr.setOrientation(LinearLayout.HORIZONTAL);
        ViewGroup.MarginLayoutParams llOrParams = (ViewGroup.MarginLayoutParams) llOr.getLayoutParams();
        llOrParams.topMargin = 60;

        // line1
        View vLine1 = new View(this);
        LinearLayout.LayoutParams vLine1Params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
                5, 1);
        vLine1Params.gravity = Gravity.CENTER_VERTICAL;
        vLine1Params.rightMargin = 15;
        vLine1.setLayoutParams(vLine1Params);
        vLine1.setBackgroundColor(ContextCompat.getColor(this, R.color.colorGrey));

        // надпись "OR"
        TextView tvOr = new TextView(this);
        tvOr.setText(R.string.or);
        tvOr.setTextColor(ContextCompat.getColor(this, R.color.colorWhite));
        tvOr.setTextSize(18);

        // line2
        View vLine2 = new View(this);
        LinearLayout.LayoutParams vLine2Params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
                5, 1);
        vLine2Params.gravity = Gravity.CENTER_VERTICAL;
        vLine2Params.leftMargin = 15;
        vLine2.setLayoutParams(vLine2Params);
        vLine2.setBackgroundColor(ContextCompat.getColor(this, R.color.colorGrey));

        // EditText - eMail
        etMail = new EditText(this);
        LinearLayout.LayoutParams etMailParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT);
        etMailParams.topMargin = 35;
        etMail.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_EMAIL_ADDRESS);
        etMail.setTextColor(ContextCompat.getColor(this, R.color.colorWhite));
        etMail.setHintTextColor(ContextCompat.getColor(this, R.color.colorGrey));
        etMail.getBackground().mutate().setColorFilter(getResources().getColor(R.color.colorGreen), PorterDuff.Mode.SRC_ATOP);
        etMail.setTextSize(TypedValue.COMPLEX_UNIT_SP, 18f);
        etMail.setTypeface(btnFacebook.getTypeface(), Typeface.BOLD);
        etMail.setHint(R.string.hint_email);
        etMail.setLayoutParams(etMailParams);

        // контейнер для пароля
        LinearLayout llPass = new LinearLayout(this);
        llPass.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT));
        llPass.setOrientation(LinearLayout.HORIZONTAL);
        ViewGroup.MarginLayoutParams llPassParams = (ViewGroup.MarginLayoutParams) llPass.getLayoutParams();
        llPassParams.topMargin = 20;

        // EditText - pass
        etPass = new EditText(this);
        LinearLayout.LayoutParams etPassParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT, 1);
        etPass.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_TEXT_VARIATION_PASSWORD);
        etPass.setTransformationMethod(new PasswordTransformationMethod());
        etPass.setTextColor(ContextCompat.getColor(this, R.color.colorWhite));
        etPass.setHintTextColor(ContextCompat.getColor(this, R.color.colorGrey));
        etPass.getBackground().mutate().setColorFilter(getResources().getColor(R.color.colorGreen), PorterDuff.Mode.SRC_ATOP);
        etPass.setTextSize(TypedValue.COMPLEX_UNIT_SP, 18f);
        etPass.setTypeface(btnFacebook.getTypeface(), Typeface.BOLD);
        etPass.setHint(R.string.hint_pass);
        etPass.setLayoutParams(etPassParams);

        // Button - pass show/hide
        btnPass = new Button(this);
        LinearLayout.LayoutParams btnPassParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT, 1);
        btnPass.setBackground(getResources().getDrawable(R.drawable.ic_show_password));
        btnPass.setLayoutParams(btnPassParams);
        // обработка кнопки - pass show/hide
        btnPass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (passIndex == 1) {
                    // скрыть пароль
                    etPass.setTransformationMethod(new PasswordTransformationMethod());
                    passIndex = 0;
                    Log.d("passIndex", String.valueOf(passIndex));
                } else {
                    /// показать пароль
                    etPass.setTransformationMethod(null);
                    passIndex = 1;
                    Log.d("passIndex", String.valueOf(passIndex));
                }
            }
        });

        // Button - Log in
        btnLogIn = new Button(this);
        btnLogIn.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT));
        ViewGroup.MarginLayoutParams btnLogInParams = (ViewGroup.MarginLayoutParams) btnLogIn.getLayoutParams();
        btnLogInParams.topMargin = 25;
        btnLogIn.setText(R.string.log_in);
        btnLogIn.setTextColor(ContextCompat.getColor(this, R.color.colorWhite));
        btnLogIn.setTextSize(TypedValue.COMPLEX_UNIT_SP, 18f);
        btnLogIn.setTypeface(btnLogIn.getTypeface(), Typeface.BOLD);
        btnLogIn.setLayoutParams(btnLogInParams);
        btnLogIn.setBackgroundColor(ContextCompat.getColor(this, R.color.colorGreen));
        // обработка нажатия на "Log in", а также правильности ввода e-mail: ____@___.__
        btnLogIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CharSequence temp_email = etMail.getText().toString();
                String temp_pass = etPass.getText().toString();
                if (!isValidEmail(temp_email)) {
                    etMail.requestFocus();
                    etMail.setError(getString(R.string.error_email));
                } else if (temp_pass.matches("")) {
                    etPass.setError(getString(R.string.error_pass));
                } else {
                    // осуществляем переход и выводим сообщение
                    Toast.makeText(getApplicationContext(), R.string.toast1, Toast.LENGTH_SHORT).show();
                }
            }
        });

        // текст-кнопка "Очистить поля ввода"
        TextView tvClear = new TextView(this);
        LinearLayout.LayoutParams tvClearParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT);
        tvClearParams.topMargin = 30;
        tvClearParams.gravity = Gravity.CENTER;
        tvClear.setText(R.string.clear);
        tvClear.setTextColor(ContextCompat.getColor(this, R.color.colorWhite));
        tvClear.setTextSize(12);
        tvClear.setLayoutParams(tvClearParams);
        // обработка нажатия на текст-кнопку "Очистить поля ввода"
        tvClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                etMail.setText("");
                etPass.setText("");
            }
        });

        // контейнер с кнопками SignUp и Terms
        LinearLayout llBottom = new LinearLayout(this);
        llBottom.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT));
        llBottom.setOrientation(LinearLayout.HORIZONTAL);
        ViewGroup.MarginLayoutParams llBottomParams = (ViewGroup.MarginLayoutParams) llBottom.getLayoutParams();
        llBottomParams.topMargin = 20;
        llBottom.setLayoutParams(llBottomParams);

        // текст-кнопка SignUp
        TextView tvSignUp = new TextView(this);
        LinearLayout.LayoutParams tvSignUpParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT, 1);
        tvSignUpParams.gravity = Gravity.BOTTOM;
        tvSignUp.setGravity(Gravity.END);
        tvSignUpParams.rightMargin = 50;
        tvSignUpParams.bottomMargin = 20;
        tvSignUp.setText(R.string.sign_up);
        tvSignUp.setTextColor(ContextCompat.getColor(this, R.color.colorWhite));
        tvSignUp.setTextSize(14);
        tvSignUp.setTypeface(btnGoogle.getTypeface(), Typeface.BOLD);
        tvSignUp.setLayoutParams(tvSignUpParams);

        // обработка нажатия на "Sign up"
        tvSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), R.string.toast2, Toast.LENGTH_SHORT).show();
            }
        });

        // текст-кнопка Terms
        TextView tvTerms = new TextView(this);
        LinearLayout.LayoutParams tvTermsParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT, 5);
        tvTermsParams.gravity = Gravity.BOTTOM;
        tvTermsParams.bottomMargin = 20;
        tvTerms.setGravity(Gravity.END);
        tvTerms.setText(R.string.terms);
        tvTerms.setTextColor(ContextCompat.getColor(this, R.color.colorWhite));
        tvTerms.setTextSize(14);
        tvTerms.setTypeface(btnGoogle.getTypeface(), Typeface.BOLD);
        tvTerms.setLayoutParams(tvTermsParams);

        // обработка нажатия на "Terms"
        tvTerms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), R.string.toast2, Toast.LENGTH_SHORT).show();
            }
        });


        // вставляем надпись "Hello" в контейнер Total
        llTotal.addView(tvHello);
        // вставляем надпись "Sign in" в контейнер Total
        llTotal.addView(tvSignIn);
        // вставляем контейнер с кнопками Google и Facebook в контейнер Total
        llTotal.addView(llGoFa);
            // вставляем кнопку Google в контейнер GoogleFacebook
            llGoFa.addView(btnGoogle);
            // вставляем кнопку Facebook в контейнер GoogleFacebook
            llGoFa.addView(btnFacebook);
        // вставляем контейнер с линиями и надписью "OR"
        llTotal.addView(llOr);
            // вставляем Line1
            llOr.addView(vLine1);
            // вставляем надпись "OR"
            llOr.addView(tvOr);
            // вставляем Line2
            llOr.addView(vLine2);
        // вставляем EditText eMail
        llTotal.addView(etMail);
        // вставляем контейнер с паролем
        llTotal.addView(llPass);
            // вставляем etPass
            llPass.addView(etPass);
            // вставляем картинку pass show/hide
            llPass.addView(btnPass);
        // вставляем кнопку LogIn
        llTotal.addView(btnLogIn);
        // вставляем TexvView Clear
        llTotal.addView(tvClear);
        // вставляем контейнер с кнопками SignUp и Terms
        llTotal.addView(llBottom);
        // вставляем SignUp
        llBottom.addView(tvSignUp);
        // вставляем Terms
        llBottom.addView(tvTerms);

        // вставляем контейнер Total в главный контейнер root
        root.addView(llTotal);
        // создаем главный контейнер root
        setContentView(root);
    }

    // проверка правильности формата введённого email
    public static boolean isValidEmail(CharSequence target) {
        return !TextUtils.isEmpty(target) && android.util.Patterns.EMAIL_ADDRESS.matcher(target).matches();
    }

    // обработка нажатия на кнопку back toolbar'a
    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
