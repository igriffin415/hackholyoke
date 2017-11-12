package com.ie.hackerthongame.foogle;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.ie.hackerthongame.R;
import com.ie.hackerthongame.helperFiles.Story;
import com.ie.hackerthongame.spaceO.SpaceO;

public class Foogle extends AppCompatActivity {

    private String story = "You've accepted the job at Foogle!";
    private String[] storyCont = {"You receive and email stating that they're so excited to have you with them.",
            "Now you have to decide what you're gonig to do.",
            "They've offered you two separate positions, what will you take?"};
    private int count = 0;
    TextView foogle;
    Button hardware;
    Button software;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_foogle);

        hardware = (Button) findViewById(R.id.hardware);
        software = (Button) findViewById(R.id.software);
        foogle = (TextView) findViewById(R.id.foogle);

        hardware.setVisibility(View.GONE);
        software.setVisibility(View.GONE);
        foogle.setText(story);
    }

    @Override
    public void onBackPressed() {/* we only move forward. */ }

    public void goToHardware(View view) {
        startActivity( new Intent(this, Hardware.class));
    }

    public void goToSoftware(View view) {
        startActivity( new Intent(this, Software.class));
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (event.getAction() != MotionEvent.ACTION_DOWN)
            return super.onTouchEvent(event);
        Story.progressStory(storyCont, foogle, count, new Button[] {hardware, software});
        count++;
        return true;
    }

}
