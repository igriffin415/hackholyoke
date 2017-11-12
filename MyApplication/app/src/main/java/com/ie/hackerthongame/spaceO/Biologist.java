package com.ie.hackerthongame.spaceO;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;

import com.ie.hackerthongame.R;
import com.ie.hackerthongame.slidingPuzzle.BoardView;

public class Biologist extends AppCompatActivity {
    /** The main view. */
    private ViewGroup mainView;

    /** The board view that generates the tiles using 2-D graphics. */
    private BoardView boardView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_biologist);
        mainView = (ViewGroup) findViewById(R.id.bioLayout);
    }

    @Override
    public void onBackPressed() {
        // Do Here what ever you want do on back press;
    }

    public void puzzel(View view){
        this.mainView.removeView(boardView);
        this.boardView = new BoardView(this, "biologist");
        this.mainView.addView(boardView);
    }
}
