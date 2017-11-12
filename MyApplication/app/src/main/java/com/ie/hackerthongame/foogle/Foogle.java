package com.ie.hackerthongame.foogle;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.ie.hackerthongame.R;
import com.ie.hackerthongame.spaceO.SpaceO;

public class Foogle extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_foogle);
    }

    @Override
    public void onBackPressed() {
        // Do Here what ever you want do on back press;
    }

    public void goToHardware(View view) {
        startActivity( new Intent(this, Hardware.class));
    }

    public void goToSoftware(View view) {
        startActivity( new Intent(this, Software.class));
    }

}
