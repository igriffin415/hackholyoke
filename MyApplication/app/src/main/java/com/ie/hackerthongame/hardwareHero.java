package com.ie.hackerthongame;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.ie.hackerthongame.foogle.Hardware;
import com.ie.hackerthongame.spaceO.Biologist;

public class hardwareHero extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hardware_hero);
    }
    @Override
    public void onBackPressed() {/* we only move forward. */ }

    public void goToHardware(View view) {
        startActivity( new Intent(this, Hardware.class));
    }
}
