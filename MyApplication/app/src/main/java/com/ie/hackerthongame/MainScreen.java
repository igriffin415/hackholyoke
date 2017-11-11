package com.ie.hackerthongame;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainScreen extends AppCompatActivity {

    Button btn = (Button)findViewById(R.id.open_activity_button);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_screen);

    // Example of a call to a native method
    TextView tv = (TextView) findViewById(R.id.sample_text);
    tv.setText(stringFromJNI());

    Button startButton = (Button) findViewById(R.id.Start);
    startButton.setOnClickListener(new OnClickListener(){

        public void onClick(View v){
                startActivity(new Intent(activity_main_screen.this, activity_space_o.class));
            }
        });
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
}
