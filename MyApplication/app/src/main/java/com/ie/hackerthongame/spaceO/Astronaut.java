package com.ie.hackerthongame.spaceO;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;

import com.ie.hackerthongame.R;
import com.ie.hackerthongame.slidingPuzzle.BoardView;
import com.ie.hackerthongame.slidingPuzzle.board.Board;

public class Astronaut extends Activity {

    /** The main view. */
    private ViewGroup mainView;

    /** The board view that generates the tiles using 2-D graphics. */
    private BoardView boardView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_astronaut);
        mainView = (ViewGroup) findViewById(R.id.astroLayout);
    }

    @Override
    public void onBackPressed() {
        // Do Here what ever you want do on back press;
    }

    public void puzzel(View view){
        this.mainView.removeView(boardView);
        this.boardView = new BoardView(this, "astronaut");
        this.mainView.addView(boardView);
    }
}
