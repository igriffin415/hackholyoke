package com.ie.hackerthongame;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.ie.hackerthongame.spaceO.Biologist;

public class bioHero extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bio_hero);
    }
    @Override
    public void onBackPressed() {/* we only move forward. */ }

    public void goToBiologist(View view) {
        startActivity( new Intent(this, Biologist.class));
    }


}
