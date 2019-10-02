package com.example.asp_thalambeat_app;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;


public class settings_section extends Fragment {
    private ImageButton play_beat, stop_beat;
    private TextView tempoDisplay;
    private Button tempo_tap;
    private SeekBar tempo_selection;
    private int current_bPm = 20;
    private int tapCount;
    private boolean isPlaying;
    private MyBpmCalculator myBpmCalculator;
    private ArrayList<Integer> gestureList;
    play_section_listener play_listener;


    public settings_section() {
        // Required empty public constructor
    }

    public interface play_section_listener {
        void playBeat(boolean play, ArrayList<Integer> list);

        void stopBeat(boolean stop);

        void selected_bpm(int bpm);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_settings_section, container, false);
        play_beat = rootView.findViewById(R.id.play_button_main);
        stop_beat = rootView.findViewById(R.id.stop_button_main);
        tempo_tap = rootView.findViewById(R.id.tempo_tap);
        tempoDisplay = rootView.findViewById(R.id.bpm_display_main);
        tempo_selection = rootView.findViewById(R.id.temposeekBar);
        tempo_selection.setProgress(current_bPm);
        myBpmCalculator = new MyBpmCalculator();
        tapCount = 0;
        tempoDisplay.setText(String.valueOf(current_bPm));
        isPlaying = false;

        tempo_tap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (tapCount < 6) {
                    myBpmCalculator.storeTime();
                    tapCount++;

                } else {
                    int bpm = myBpmCalculator.calculateBpm(myBpmCalculator.storeTapDelays());
                    if (bpm > 301) {
                        bpm = 300;
                    }
                    String a = String.valueOf(bpm);
                    tempoDisplay.setText(a);
                    current_bPm = bpm;
                    tapCount = 0;
                    tempo_selection.setProgress(current_bPm);
                    myBpmCalculator.clearTimeStamps();
                    Toast t = Toast.makeText(getContext(), "BPM SET",
                            Toast.LENGTH_SHORT);
                    t.setGravity(Gravity.CENTER_HORIZONTAL, 0, 0);
                    t.show();
                }
            }
        });

        tempo_selection.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                current_bPm = progress;
                tempoDisplay.setText(String.valueOf(current_bPm));
                play_listener.selected_bpm(current_bPm);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        play_beat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                play_listener.selected_bpm(current_bPm);
                if (!isPlaying){
                play_listener.playBeat(true, gestureList);
                play_listener.stopBeat(false);
                isPlaying = true;
                } else {
                    play_listener.stopBeat(true);
                    isPlaying = false;
                }

            }
        });
        stop_beat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                play_listener.stopBeat(true);
                isPlaying = false;
            }
        });

        return rootView;
    }

    public void recieveArray(ArrayList<Integer> list){
        gestureList = list;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof play_section_listener) {
            play_listener = (play_section_listener) context;
        }
    }

    @Override
    public void onStop() {
        super.onStop();
        play_listener = null;
    }
}
