package com.ie.hackerthongame.foogle;

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

public class Hardware extends AppCompatActivity {
    /** The main view. */
    private ViewGroup mainView;

    /** The board view that generates the tiles using 2-D graphics. */
    private BoardView boardView;

    private String story = "You come into work one day to see the office in a mess. As soon as your boss sees you enter she comes over.";
    private String[] storyCont = {"\"Listen,\" she starts, \"I desperately need you to design a piece of hardware for our clients.\"",
            "She gives you the lowdown of what they need and leaves you to it, trusting your expertise. You haven't let her down once."};
    private int count = 0;
    TextView issue;
    Button go;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hardware);
        mainView = (ViewGroup) findViewById(R.id.hardLayout);

        go = (Button) findViewById(R.id.go);
        issue = (TextView) findViewById(R.id.hardwareIssue);
        go.setVisibility(View.GONE);
        issue.setText(story);
    }

    @Override
    public void onBackPressed() {/* we only move forward. */ }

    public void puzzel(View view){
        this.mainView.removeView(boardView);
        this.boardView = new BoardView(this, "hardware");
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
