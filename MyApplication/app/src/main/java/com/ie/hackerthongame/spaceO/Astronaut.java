package com.ie.hackerthongame.spaceO;

import android.app.Activity;
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
import com.ie.hackerthongame.slidingPuzzle.board.Board;

public class Astronaut extends Activity {

    /** The main view. */
    private ViewGroup mainView;

    /** The board view that generates the tiles using 2-D graphics. */
    private BoardView boardView;

    private String story = "You're in space, having just landed on a foreign planet outside of our solar system. However, the reason for your landing is not a pleasant one.";
    private String[] storyCont = {"There were some malfunctions in your space shuttle and now you need to complete repairs!",
            "Don't fear, you've been trained for this, and it's not the first time you've made some quick fixes on the job."};
    private int count = 0;
    TextView issue;
    Button go;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_astronaut);
        mainView = (ViewGroup) findViewById(R.id.astroLayout);

        go = (Button) findViewById(R.id.go);
        issue = (TextView) findViewById(R.id.astroIssue);
        go.setVisibility(View.GONE);
        issue.setText(story);
    }

    @Override
    public void onBackPressed() {/* we only move forward. */ }

    public void puzzel(View view){
        this.mainView.removeView(boardView);
        this.boardView = new BoardView(this, "astronaut");
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
