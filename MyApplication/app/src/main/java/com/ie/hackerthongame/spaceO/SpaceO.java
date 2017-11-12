package com.ie.hackerthongame.spaceO;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.ie.hackerthongame.R;
import com.ie.hackerthongame.helperFiles.Story;

public class SpaceO extends Activity {

    private String story = "You've accepted the job at SpaceO!";
    private String[] storyCont = {"You receive and email stating that they're so excited to have you with them.",
            "Now you have to decide what you're going to do.",
            "They've offered you two separate positions, what will you take?"};
    private int count = 0;
    Button bio;
    Button astro;
    TextView spaceO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_space_o);

        //create and hide button(s) && initialize text
        bio = (Button) findViewById(R.id.bio);
        astro = (Button) findViewById(R.id.astronaut);
        spaceO = (TextView) findViewById(R.id.spaceO);
        bio.setVisibility(View.GONE);
        astro.setVisibility(View.GONE);
        spaceO.setText(story);
    }

    @Override
    public void onBackPressed() {/* we only move forward. */ }

    public void goToBiologist(View view) {
        startActivity( new Intent(this, Biologist.class));
    }

    public void goToAstronaut(View view) {
        startActivity( new Intent(this, Astronaut.class ));
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (event.getAction() != MotionEvent.ACTION_DOWN)
            return super.onTouchEvent(event);
        Story.progressStory(storyCont, spaceO, count, new Button[] {bio, astro});
        count++;
        return true;
    }
}
