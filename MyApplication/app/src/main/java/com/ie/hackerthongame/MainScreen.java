package com.ie.hackerthongame;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;

import com.ie.hackerthongame.slidingPuzzle.BoardView;
import com.ie.hackerthongame.slidingPuzzle.board.Board;

public class MainScreen extends Activity {

    /** The main view. */
    private ViewGroup mainView;

    /** The game board. */
    private Board board;

    /** The board view that generates the tiles and lines using 2-D graphics. */
    private BoardView boardView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_screen);
        mainView = (ViewGroup) findViewById(R.id.mainLayout);
    }




    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */
    public native String stringFromJNI();
    // Used to load the 'native-lib' library on application startup.
    static {
        System.loadLibrary("native-lib");
    }

    public void moveScreens(View view){
        this.mainView.removeView(boardView);
        this.boardView = new BoardView(this, "biologist");
        this.mainView.addView(boardView);
//        startActivity( new Intent(this, BoardView.class));
    }
}
