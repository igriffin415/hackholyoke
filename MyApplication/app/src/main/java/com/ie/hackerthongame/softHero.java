package com.ie.hackerthongame;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.ie.hackerthongame.foogle.Software;

public class softHero extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_soft_hero);
    }

    public void goToSoftware(View view) {
        startActivity(new Intent(this, Software.class));
    }

}
