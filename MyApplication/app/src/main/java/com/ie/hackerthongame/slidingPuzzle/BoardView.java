package com.ie.hackerthongame.slidingPuzzle;

import java.util.Iterator;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.FontMetrics;
import android.graphics.Paint.Style;
import 	android.graphics.Rect;
import android.graphics.Picture;
import android.view.MotionEvent;
import android.view.View;

import com.ie.hackerthongame.End;
import com.ie.hackerthongame.R;
import com.ie.hackerthongame.foogle.Hardware;
import com.ie.hackerthongame.slidingPuzzle.board.Board;
import com.ie.hackerthongame.slidingPuzzle.board.Place;

/**
 * The Class BoardView. It uses 2-D graphics to display the puzzle board.
 *
 * @author Caio Lopes
 * @version 1.0 $
 */
public class BoardView extends View {
    /** board size */
    private int boardSize =3;

    /** The board. */
    private Board board;

    /** The width. */
    private float width;

    /** The height. */
    private float height;
    /** the screen's height */
    private float screenHeight;

    Context context;

    /** The job */
    String job;

    /**
     * Instantiates a new board view.
     *
     * @param context
     *            the context
     */
    public BoardView(Context context, String job) {
        super(context);
        this.board = new Board(3);
        this.board.addBoardChangeListener(boardChangeListener);
        this.board.rearrange();
        this.job = job;
        this.context = context;
        setFocusable(true);
        setFocusableInTouchMode(true);
    }

    /*
     * (non-Javadoc)
     *
     * @see android.view.View#onSizeChanged(int, int, int, int)
     */
    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        this.width = w / this.board.size();
        this.height = w / this.board.size();
        this.screenHeight = h;
        super.onSizeChanged(w, h, oldw, oldh);
    }

    /**
     * Locate place.
     *
     * @param x
     *            the x
     * @param y
     *            the y
     * @return the place
     */
    private Place locatePlace(float x, float y) {
        System.out.println(x+" "+y);
        int ix = (int) (x / width);
        int iy = (int) (y / height);
        System.out.println(ix +" " + iy);

        return board.at(ix + 1, iy + 1);
    }

    /*
     * (non-Javadoc)
     *
     * @see android.view.View#onTouchEvent(android.view.MotionEvent)
     */
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (event.getAction() != MotionEvent.ACTION_DOWN)
            return super.onTouchEvent(event);
        Place p = locatePlace(event.getX(), event.getY());

        if (p != null && p.slidable() && !board.solved()) {
            p.slide();
            invalidate();
        }
        return true;
    }

    /*
     * (non-Javadoc)
     *
     * @see android.view.View#onDraw(android.graphics.Canvas)
     */
    @Override
    protected void onDraw(Canvas canvas) {
        Paint background = new Paint();
        background.setColor(getResources().getColor(R.color.board_color));
        canvas.drawRect(0, 0, getWidth(), getHeight(), background);

        Paint dark = new Paint();
        dark.setColor(getResources().getColor(R.color.tile_color));
        dark.setStrokeWidth(15);

        Paint foreground = new Paint(Paint.ANTI_ALIAS_FLAG);
        foreground.setColor(getResources().getColor(R.color.tile_color));
        foreground.setStyle(Style.FILL);
        foreground.setTextSize(height * 0.75f);
        foreground.setTextScaleX(width / height);
        foreground.setTextAlign(Paint.Align.CENTER);

        float x = width / 2;
        FontMetrics fm = foreground.getFontMetrics();
        float y = (height / 2) - (fm.ascent + fm.descent) / 2;

        Iterator<Place> it = board.places().iterator();
        for (int i = 0; i < board.size(); i++) {
            for (int j = 0; j < board.size(); j++) {
                if (it.hasNext()) {
                    Place p = it.next();
                    Rect spot = new Rect((int)(i * width), (int)(j * height),
                            (int)(i * width + width ), (int)(j * height + height));
                    if (p.hasTile()){
                        int resId = getResources().getIdentifier(job+(p.getTile().number()),"drawable", "com.ie.hackerthongame");

                        Bitmap b = BitmapFactory.decodeResource(getResources(), resId);
                        canvas.drawBitmap(b, null, spot,null);
                    } else {
                        canvas.drawRect(spot, dark);
                    }
                }
            }
        }
    }

    /** The board change listener. */
    private Board.BoardChangeListener boardChangeListener = new Board.BoardChangeListener() {
        public void tileSlid(Place from, Place to, int numOfMoves) {
        }

        public void solved(int numOfMoves) { context.startActivity( new Intent(context, End.class));
        }
    };
}