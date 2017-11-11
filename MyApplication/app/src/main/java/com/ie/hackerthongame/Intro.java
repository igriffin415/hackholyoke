package com.ie.hackerthongame;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.ie.hackerthongame.foogle.Foogle;
import com.ie.hackerthongame.spaceO.SpaceO;

public class Intro extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);
    }

    public void goToSpaceO(View view){
        //go to spaceO
        startActivity( new Intent(this, SpaceO.class));
    }

    public void goToFoogle(View view){
        startActivity( new Intent(this, Foogle.class));
    }
}
