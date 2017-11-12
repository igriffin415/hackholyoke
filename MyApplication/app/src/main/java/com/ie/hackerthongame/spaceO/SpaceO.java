package com.ie.hackerthongame.spaceO;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.ie.hackerthongame.R;

public class SpaceO extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_space_o);
    }


    public void goToBiologist(View view) {
        startActivity( new Intent(this, Biologist.class));
    }

    public void goToAstronaut(View view) {
        startActivity( new Intent(this, Astronaut.class ));
    }
}
