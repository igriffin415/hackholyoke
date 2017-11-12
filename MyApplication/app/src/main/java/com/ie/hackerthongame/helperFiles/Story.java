package com.ie.hackerthongame.helperFiles;

import android.view.View;
import android.widget.TextView;
import android.widget.Button;

/**
 * Created by FireI on 11/12/2017.
 */

public class Story {

    //checks to make sure that the current index is valid, then either:
    //adds to text or shows buttons
    public static void progressStory(String[] storyCont, TextView story, int count, Button[] buttons){
        String text = (String) story.getText();
        if(count < storyCont.length)
        {
            text += "\n\n" + storyCont[count];
            story.setText(text);
        }
        else {
            for(Button b : buttons)
            b.setVisibility(View.VISIBLE);
        }
    }
}
