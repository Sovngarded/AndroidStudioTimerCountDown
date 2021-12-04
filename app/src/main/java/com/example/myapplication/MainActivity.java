package com.example.myapplication;

import static java.lang.String.valueOf;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    TextView textView;
    Button button;
    Handler handler = new Handler();
    int timerAm;
    String nowTime;

    int delay = 1000;// in ms

    Timer timer = new Timer();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = (Button) findViewById(R.id.buttonStart);
        editText = (EditText) findViewById(R.id.editTextTextMultiLine);
        textView = (TextView) findViewById(R.id.textView);
    }

    public void clickOnButton(View view) {
        textView.setText(editText.getText());
        timerAm = Integer.parseInt(editText.getText().toString());
        button.setClickable(false);
        new CountDownTimer(timerAm * 1000, 1000) { // Here I want to have a user input value in milli seconds instead of pre loaded value of 30000

            public void onTick(long millisUntilFinished) {

                textView.setText("seconds remaining: " + millisUntilFinished / 1000);
            }

            public void onFinish() {
                button.setClickable(true);
            }
        }.start();


    }


}
