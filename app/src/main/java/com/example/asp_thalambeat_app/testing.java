package com.example.asp_thalambeat_app;

import android.content.Context;
import android.os.Handler;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class testing extends AppCompatActivity {
    private Button play, stop, tap;
    private TextView beatDisplay;
    private EditText tempoText;
    Vibrator vibrate;
    private MyBpmCalculator myBpmCalculator;
    boolean stopClick;
    private int tapcount;

    Handler myhandler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_testing);
        play = findViewById(R.id.tempoBTN);
        stop = findViewById(R.id.stopbutton);
        tap = findViewById(R.id.tapbtn);
        tempoText = findViewById(R.id.tempoET);
        beatDisplay = findViewById(R.id.beatCount);
        vibrate = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        myBpmCalculator = new MyBpmCalculator();
        tapcount = 0;

        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stopClick = true;
            }
        });

        tap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (tapcount < 6) {
                    myBpmCalculator.storeTime();
                    tapcount++;
                    String a = String.valueOf(tapcount);
                    beatDisplay.setText(a);
                } else {
                   int bpm =  myBpmCalculator.calculateBpm(myBpmCalculator.storeTapDelays());
                    String a = String.valueOf(bpm);
                    tempoText.setText(a);
                    tapcount = 0;
                    myBpmCalculator.clearTimeStamps();
                }
            }
        });

    }

    public void StartBeat(final View view) {
        String tempo = tempoText.getText().toString();
        final int tempoNum = Integer.parseInt(tempo);
        final Runnable beatrun = new Runnable() {
            @Override
            public void run() {
                int beat_type = 1;
                long delay = 60000 / tempoNum;

                while (!stopClick) {

                    for (int i = 1; i <= 4; i++) {
                        final String display = String.valueOf(i);
                        myhandler.post(new Runnable() {
                            @Override
                            public void run() {
                                vibrate.vibrate(50);
                                beatDisplay.setText(display);

                            }
                        });
                        try {
                            Thread.sleep(delay);
                        } catch (Exception ex) {

                        }
                    }
                }
            }
        };
        new Thread(beatrun).start();
        stopClick = false;

    }


}
