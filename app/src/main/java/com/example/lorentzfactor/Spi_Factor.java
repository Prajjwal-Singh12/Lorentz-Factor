package com.example.lorentzfactor;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Spi_Factor extends AppCompatActivity {
    private TextView spitxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spi_factor);
        spitxt = findViewById(R.id.textView5);

        Thread t=new Thread(){
            @Override
            public void run(){
                while(!isInterrupted()){
                    try {
                        Thread.sleep(1000);
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                Date currentDate = new Date();
                                SimpleDateFormat hourFormat = new SimpleDateFormat("h");
                                SimpleDateFormat minFormat = new SimpleDateFormat("m");
                                SimpleDateFormat secFormat = new SimpleDateFormat("s");
                                String s_hour = hourFormat.format(currentDate);
                                int hour = Integer.parseInt(s_hour);
                                String s_min = minFormat.format(currentDate);
                                int min = Integer.parseInt(s_min);
                                String s_sec = secFormat.format(currentDate);
                                int sec = Integer.parseInt(s_sec);
                                double spifvalue = fact(hour)/((min*min*min)+sec);
                                spitxt.setText(spifvalue+"");
                            }
                        });
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            }
        };
        t.start();
    }

    int fact (int n){
        int factorial = 1;
        for(int i = 1; i <= n; i++)
        {
            factorial *= i;
        }
        return factorial;
    }
}