package com.ie.hackerthongame;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

import com.ie.hackerthongame.foogle.Foogle;
import com.ie.hackerthongame.helperFiles.Story;

public class End extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end);
    }

    @Override
    public void onBackPressed() {/* we only move forward. */ }

    public void backToMain(View view){
        startActivity( new Intent(this, MainScreen.class));
    }
}
