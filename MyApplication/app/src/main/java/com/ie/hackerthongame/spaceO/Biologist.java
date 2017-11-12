package com.ie.hackerthongame.spaceO;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.ie.hackerthongame.R;
import com.ie.hackerthongame.helperFiles.Story;
import com.ie.hackerthongame.slidingPuzzle.BoardView;

public class Biologist extends AppCompatActivity {
    /** The main view. */
    private ViewGroup mainView;

    /** The board view that generates the tiles using 2-D graphics. */
    private BoardView boardView;

    private String story = "You come into work one day to see find you boss is a mess, running up and down the command center.";
    private String[] storyCont = {"She rushes you when you enter, letting you know what's got her in a frenzy. One of the astronauts accidentally disturbed the fragile ecosystem on the current research planet!",
            "You're the most familiar with this planet so it's up to you to rebalance it all!"};
    private int count = 0;
    TextView issue;
    Button go;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_biologist);
        mainView = (ViewGroup) findViewById(R.id.bioLayout);

        go = (Button) findViewById(R.id.go);
        issue = (TextView) findViewById(R.id.bioIssue);
        go.setVisibility(View.GONE);
        issue.setText(story);
    }

    @Override
    public void onBackPressed() {/* we only move forward. */ }

    public void puzzel(View view){
        this.mainView.removeView(boardView);
        this.boardView = new BoardView(this, "biologist");
        this.mainView.addView(boardView);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (event.getAction() != MotionEvent.ACTION_DOWN)
            return super.onTouchEvent(event);
        Story.progressStory(storyCont, issue, count, new Button[] {go});
        count++;
        return true;
    }
}

