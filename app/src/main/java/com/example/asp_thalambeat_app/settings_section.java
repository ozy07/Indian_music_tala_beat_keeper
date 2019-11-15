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

/*
This class controls the play & Stop Buttons, The BPM slider and the BPM Tap to Set feature
*/
public class settings_section extends Fragment {
    private ImageButton play_beat, stop_beat;
    private TextView tempoDisplay;
    private Button tempo_tap;
    private SeekBar tempo_selection;
    private int current_bPm = 20;
    private int tapCount, sub_division;
    private boolean isPlaying = false;
    private MyBpmCalculator myBpmCalculator;
    private ArrayList<Integer> gestureList, soundList;
    play_section_listener play_listener;


    public settings_section() {
        // Required empty public constructor
    }

    /*Below is the interface declaration, detailing methods that must be implemented by any class
    * that needs to recieve any of the variables in these methods */

    public interface play_section_listener {
        void playBeat(boolean play, ArrayList<Integer> list, ArrayList<Integer> s_list);
        void nadaiSetting(int subdiv);
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
                play_listener.playBeat(true, gestureList, soundList);
                play_listener.nadaiSetting(sub_division);
                play_listener.stopBeat(false);
                isPlaying = true;
                } else {
                    play_listener.stopBeat(true);
                    try{Thread.sleep(500);}
                    catch (InterruptedException ex){
                        ex.printStackTrace();
                    }
                    play_listener.playBeat(true, gestureList, soundList);
                    play_listener.nadaiSetting(sub_division);
                    play_listener.stopBeat(false);
                    isPlaying = true;
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

    public void recieveArray(ArrayList<Integer> list, ArrayList<Integer> s_list){
        gestureList = list;
        soundList = s_list;
    }
    public void updateNadai(int subdiv){
        sub_division = subdiv;
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
