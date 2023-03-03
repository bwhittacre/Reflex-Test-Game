package com.example.myapplication;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.Toast;
import java.util.Random;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    public Button button1, button2;
    public RelativeLayout relativeLayout;
    //This function runs the actual game, namely the initial state, and the math done to show the reflexes of the player.
    Runnable runnable = new Runnable() {
        @Override
        public void run(){
            //This sets the background color.
            relativeLayout.setBackgroundResource(R.color.purple_200);
            //This gets the system time, and sets it in milliseconds.
            final long time = System.currentTimeMillis();
            //This waits for the second button press.
            button2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //This gets the system time from when the button is pressed in milliseconds.
                    long time1 = System.currentTimeMillis();
                    //This displays how fast the player was.
                    Toast.makeText(getApplicationContext(), "Your reflexes took " + (time1 - time) + " milliseconds to kick in.", Toast.LENGTH_LONG).show();
                    //This resets the background.
                    relativeLayout.setBackgroundResource(0);
                }
            });
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        relativeLayout = findViewById(R.id.rlVar1);
        button1 = findViewById(R.id.btVar1);
        button2 = findViewById(R.id.btVar2);
        //This waits for the start button to be pressed.
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //This gets a number between 1 and 100, at random.
                Random random = new Random();
                int num = random.nextInt(20);
                //This calls runnable after the day from the number of seconds.
                Handler handler = new Handler();
                handler.postDelayed(runnable, num * 1000);
            }
        });
    }
}