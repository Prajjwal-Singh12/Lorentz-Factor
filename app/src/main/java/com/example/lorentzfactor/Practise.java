package com.example.lorentzfactor;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Build;
import android.os.Bundle;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Practise extends AppCompatActivity {

    private EditText velocitytxt, lFactortxt;
    private TextView result;
    private Button check;
    View view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practise);
        velocitytxt = findViewById(R.id.velocityPractise);
        lFactortxt = findViewById(R.id.lorentzFPractise);
        result = findViewById(R.id.resultPractise);
        check = findViewById(R.id.checkButton);
        Vibrator vibrator = (Vibrator)getSystemService(VIBRATOR_SERVICE);
        view = this.getWindow().getDecorView();

        check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (velocitytxt.length()==0)
                    velocitytxt.setError("Enter velocity");
                else if (lFactortxt.length()==0)
                    lFactortxt.setError("Enter Lorentz Factor");
                else {
                    String s_vel = velocitytxt.getText().toString();
                    double vel = Double.parseDouble(s_vel);
                    String s_lfactor = lFactortxt.getText().toString();
                    double lfactor = Double.parseDouble(s_lfactor);
                    double calclfactor = Lorentz_Factor.Calculate(vel);
                    double lfactor_rounded = Math.round(lfactor * 1000000) / 1000000.0;
                    double calclfactor_rounded = Math.round(calclfactor * 1000000) / 1000000.0;

                    if (vel < 299792458 && vel >= 0) {
                        if (lfactor_rounded == calclfactor_rounded) {
                            result.setText("CORRECT ANSWER!");
                            view.setBackgroundResource(android.R.color.holo_green_light);
                        } else {
                            result.setText("WRONG ANSWER\nCorrect Lorentz Factor= " + calclfactor_rounded);
                            view.setBackgroundResource(android.R.color.holo_red_light);
                            if (Build.VERSION.SDK_INT >= 26)
                                vibrator.vibrate(VibrationEffect.createOneShot(500, VibrationEffect.DEFAULT_AMPLITUDE));
                            else
                                vibrator.vibrate(500);
                        }
                    } else {
                        Toast.makeText(Practise.this, R.string.invalidToast, Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}