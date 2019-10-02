package com.example.asp_thalambeat_app;

import java.util.ArrayList;

public class talas {
    ArrayList<Integer> combinedList;
    ArrayList<Integer> laghu;
    ArrayList<Integer> drutam;
    ArrayList<Integer> andrutam;
    int [] laghu_gestures = new int [] {
            R.drawable.palm_down_b, R.drawable.pinky_b, R.drawable.ring_b,
            R.drawable.middle_b,  R.drawable.index_b, R.drawable.thumb_b,
            R.drawable.pinky_6th_b_, R.drawable.ring_7th_b_, R.drawable.middle_8th_b_
    };

    public ArrayList laghu_set (int n){
        laghu = new ArrayList<>();
        for(int i = 0; i<n; i++){
            laghu.add(laghu_gestures[i]);
        }
        return laghu;
    }
    public ArrayList drutam_set(){
        drutam = new ArrayList<>();
        drutam.add(R.drawable.palm_down_b);
        drutam.add(R.drawable.palm_up_b);
        return drutam;
    }
    public ArrayList andrutam_set(){
        andrutam = new ArrayList<>();
        andrutam.add(R.drawable.palm_down_b_);
        return andrutam;
    }

    //Talas
    //Eka
    public void eka_list(int ts){ //made up of laghu (I)
        combinedList = laghu_set(ts);
    }
}
