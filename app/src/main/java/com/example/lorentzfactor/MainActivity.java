package com.example.lorentzfactor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button lorentzButton, spiButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lorentzButton = findViewById(R.id.lorentzbutton);
        spiButton = findViewById(R.id.spibutton);

        lorentzButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openLorentzActivity();
            }
        });
        spiButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openSpiActivity();
            }
        });

    }

    public void openLorentzActivity(){
        Intent intent = new Intent(this,Lorentz_Factor.class);
        startActivity(intent);
    }

    public void openSpiActivity(){
        Intent intent = new Intent(this,Spi_Factor.class);
        startActivity(intent);
    }
}