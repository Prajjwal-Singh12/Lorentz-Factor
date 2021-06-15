package com.example.lorentzfactor;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button button;
    private EditText input;
    private TextView output;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = findViewById(R.id.button);
        input = findViewById(R.id.input);
        output = findViewById(R.id.output);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s = input.getText().toString();
                double vel = Double.parseDouble(s);
                if(vel<299792458 && vel>0) {
                    double lfactor = Calculate(vel);
                    output.setText("Lorentz Factor = " + lfactor);
                }
                else {
                    Toast.makeText(MainActivity.this, R.string.invalidToast, Toast.LENGTH_SHORT).show();
                }

            }
        });
    }

    public double Calculate(double vel)
    {
        double c = 299792458.0;
        double lfactor = 1/ Math.sqrt(1 - (vel*vel)/(c*c));
        return lfactor;
    }
}