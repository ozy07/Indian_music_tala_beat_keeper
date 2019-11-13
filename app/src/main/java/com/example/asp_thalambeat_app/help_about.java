package com.example.asp_thalambeat_app;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;

public class help_about extends AppCompatActivity {
    FloatingActionButton return_fab;
    RecyclerView my_rv;
    RecyclerView.LayoutManager rv_layout;
    RecyclerView.Adapter rv_adapter;
    ArrayList<help_data> helpData = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help_about);
        return_fab = findViewById(R.id.backToPlayer);
        my_rv = findViewById(R.id.myR_view);
        my_rv.setHasFixedSize(true);
        rv_layout = new LinearLayoutManager(this);
        my_rv.setLayoutManager(rv_layout);
        helpData.add(new help_data("What does this App Do?", "This application works very much like a " +
                "metronome. By selecting certain types of tala from the settings page (eg Eka | Chatusram | no nadai), we can " +
                "mimic the western normal time signature 4/4 beat structure. However this app is not a metronome. It has been developed" +
                " to help classical indian musicians who play or compose indian carnatic music keep the beat using visual aids, sounds or" +
                " a combination of both. Regular western musicians can also use it like a metronome by using the Eka tala.",
                R.drawable.ic_sentiment_satisfied_black_24dp));
        helpData.add(new help_data("How do I leave this page?", "Simply Click on the Button on the top left side of this page" +
                " and you will be redirected to the Tala player. The button should look like the button below.", R.drawable.return_icon));
        helpData.add(new help_data("How do I start playing?", "Navigate to the Tala player and select the desired tala" +
                " from the dropdown menu available. Once selection is complete, click the play button on the mid left of the page. " +
                "Click play or stop from the resulting page to start or stop the player", R.drawable.play_btn));
        helpData.add(new help_data("How do I set the Tempo?", "Users can select a tempo for their desired tala by tapping the bottom half" +
                " of the player page to set tempo. There is also a slidder on the player page to help select a tempo manually." +
                " Selecting the tempo can also be done while the player is playing (the player adjusts automatically)",
                R.drawable.ic_sentiment_satisfied_black_24dp));
        helpData.add(new help_data("Can I select a different Tala while the player is playing?", "Yes indeed, the application is" +
                " able to adjust to a new tala selection with minimal distruption to the flow of the music. Ensure to navigate to the player" +
                " screen after Tala selection and click play. Note: You do not need to stop the beat.", R.drawable.settings_icon));
        helpData.add(new help_data("Can I set my own sound or visual aid preference?", "This application allows you to toggle " +
                "ON or OFF for both sound and visual aid. This also works in realtime so we can set these while a tala is playing." +
                " Note: toggling both off will mean that nothing is visible or audible from the player", R.drawable.settings_icon));
        //helpData.add(new help_data());
        //helpData.add(new help_data());
        rv_adapter = new custom_adapter(helpData);
        my_rv.setAdapter(rv_adapter);
        return_fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(help_about.this, MainActivity.class));
            }
        });


    }
}
