package com.example.asp_thalambeat_app;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements settings_section.play_section_listener,
        settings_mode.tala_settings_listener{
    private display_section disp_sec; //reference to the top player fragment
    private settings_section set_sec;
    private settings_mode set_mode;
    private ImageButton settings_nav;
    private boolean clicked_once;


    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        disp_sec = new display_section();
        set_sec = new settings_section();
        set_mode = new settings_mode();
        settings_nav = findViewById(R.id.nav_button);
        clicked_once = false;
        getSupportFragmentManager().beginTransaction().replace(R.id.displayframe, disp_sec)
                .replace(R.id.settingsframe, set_mode).commit();

        settings_nav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!clicked_once) {
                    getSupportFragmentManager().beginTransaction().
                            replace(R.id.settingsframe, set_sec).commit();
                    settings_nav.setImageResource(R.drawable.settings_icon);
                    clicked_once = true;
                } else if (clicked_once) {
                    getSupportFragmentManager().beginTransaction().
                            replace(R.id.settingsframe, set_mode).commit();
                    settings_nav.setImageResource(R.drawable.return_icon);
                    clicked_once = false;
                }
            }
        });


    }

    @Override
    public void nadaiSetting(int subdiv) {
        disp_sec.updateSubDiv(subdiv);
    }

    @Override
    public void setNadai(int subdiv) {
        set_sec.updateNadai(subdiv);
    }

    @Override
    public void stopBeat(boolean stop) {
        disp_sec.stopBeat(stop);
    }

    @Override
    public void selected_bpm(int bpm) {
        disp_sec.updateBPM(bpm);
    }

    @Override
    public void soundSet(boolean isOn) {
        disp_sec.setSound(isOn);
    }

    @Override
    public void visualSet(boolean isOn) {
        disp_sec.setVisual(isOn);
    }

    @Override
    public void DashSet(String thala, String jathis, String nadai) {
        disp_sec.setDash(thala, jathis, nadai);
    }

    @Override
    public void typeSet(String type) {
        //disp_sec.setBeatType(type);
    }

    @Override
    public void playList(ArrayList list, ArrayList s_list) {

        set_sec.recieveArray(list, s_list);
    }

    @Override
    public void playBeat(boolean play, ArrayList<Integer> list, ArrayList<Integer> s_list) {
        disp_sec.setTalaType(list, s_list);
        disp_sec.playBeat(play);
    }
}
