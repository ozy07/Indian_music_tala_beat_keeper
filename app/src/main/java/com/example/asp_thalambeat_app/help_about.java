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
        helpData.add(new help_data("Select A Tala", "In order to select a Tala, Navigate to settings page" +
                " by clicking on the settings icon on the top left of the play button as pictured below ", R.drawable.settings_icon));
        helpData.add(new help_data("Select A Tala", "In order to select a Tala, Navigate to settings page" +
                " by clicking on the settings icon on the top left of the play button as pictured below ", R.drawable.settings_icon));
        helpData.add(new help_data("Select A Tala", "In order to select a Tala, Navigate to settings page" +
                " by clicking on the settings icon on the top left of the play button as pictured below ", R.drawable.settings_icon));
        helpData.add(new help_data("Select A Tala", "In order to select a Tala, Navigate to settings page" +
                " by clicking on the settings icon on the top left of the play button as pictured below ", R.drawable.settings_icon));
        helpData.add(new help_data("Select A Tala", "In order to select a Tala, Navigate to settings page" +
                " by clicking on the settings icon on the top left of the play button as pictured below ", R.drawable.settings_icon));
        helpData.add(new help_data("Select A Tala", "In order to select a Tala, Navigate to settings page" +
                " by clicking on the settings icon on the top left of the play button as pictured below ", R.drawable.settings_icon));
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
