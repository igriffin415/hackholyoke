package com.ie.hackerthongame;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.ie.hackerthongame.foogle.Foogle;
import com.ie.hackerthongame.helperFiles.Story;
import com.ie.hackerthongame.spaceO.SpaceO;

public class Intro extends Activity {
    private String story = "Today you graduate from college! You've been offered some positions at some great companies!";
    private String[] storyCont = {"The first is Foogle, a large corporation that builds computers and develops software for them. They've offered you either a position as a hardware or software engineer.",
                                  "The other company is SpaceO, an institute for intergalactic research and travel. There you've been offered either a position as a biologist, researching foreign planets, or as an astronaut!",
                                  "Where will you go?"};
    private int count = 0;
    Button foogle;
    Button spaceO;
    TextView intro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);
        foogle = (Button) findViewById(R.id.foogle);
        spaceO = (Button) findViewById(R.id.spaceO);
        intro = (TextView) findViewById(R.id.intro);
        foogle.setVisibility(View.GONE);
        spaceO.setVisibility(View.GONE);
        intro.setText(story);
    }

    @Override
    public void onBackPressed() {/* we only move forward. */ }

    public void goToSpaceO(View view){ startActivity( new Intent(this, SpaceO.class)); }

    public void goToFoogle(View view){
        startActivity( new Intent(this, Foogle.class));
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (event.getAction() != MotionEvent.ACTION_DOWN)
            return super.onTouchEvent(event);
        Story.progressStory(storyCont, intro, count, new Button[] {foogle, spaceO});
        count++;
        return true;
    }
}
