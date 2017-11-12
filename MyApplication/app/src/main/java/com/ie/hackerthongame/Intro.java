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
import com.ie.hackerthongame.spaceO.SpaceO;

public class Intro extends Activity {
    private String story = "You're having a good time in college, studying the STEM field of your choice.";
    private String[] storyCont = {"Today you graduate! You've been offered some positions at some great companies!",
                                  "The first is Foogle, a large corperation that builds computers and develops software for them. They've offered you either a position as a hardware or software enginere.",
                                  "\nThe other company is SpaceO, an institute for intergalactic research and travel. There you've been offered either a position as a biologist, reasearching forign planets, or as an astronaut!",
                                  "\nWhere will you go?"};
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
    public void onBackPressed() {
        // Do Here what ever you want do on back press;
    }

    public void goToSpaceO(View view){
        //go to spaceO
        startActivity( new Intent(this, SpaceO.class));
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (event.getAction() != MotionEvent.ACTION_DOWN)
            return super.onTouchEvent(event);
        progessStory();
        return true;
    }

    public void goToFoogle(View view){
        startActivity( new Intent(this, Foogle.class));
    }

    private void progessStory(){
        if(count < storyCont.length)
        {
            story += "\n" + storyCont[count];
            intro.setText(story);
        }
        else {
            foogle.setVisibility(View.VISIBLE);
            spaceO.setVisibility(View.VISIBLE);
        }
        count++;
    }
}
