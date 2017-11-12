package com.ie.hackerthongame;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.ie.hackerthongame.spaceO.Astronaut;

public class astroHero extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_astro_hero);
    }

    public void goToAstronaut(View view) {
        startActivity(new Intent(this, Astronaut.class));
    }
}
