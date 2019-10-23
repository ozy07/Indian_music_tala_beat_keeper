package com.example.asp_thalambeat_app;

import java.util.ArrayList;

public class talas {
    ArrayList<Integer> combinedList;
    ArrayList<Integer> soundList;
    ArrayList<Integer> laghu;
    ArrayList<Integer> drutam = new ArrayList<>();
    ArrayList<Integer> andrutam = new ArrayList<>();
    public  talas(){
        drutam.add(R.drawable.palm_down_b);
        drutam.add(R.drawable.palm_up_b);

        andrutam.add(R.drawable.palm_down_b_);
    }

    int subdiv = R.drawable.sub_div;
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

    //Talas
    //Eka
    public ArrayList eka_list(int ts){ //made up of laghu (I)
        combinedList = new ArrayList<>();
        combinedList = laghu_set(ts);
        return combinedList;
    }
    public ArrayList ata_List(int ts){ //made up of two laghus and two drutam (IIOO)
        combinedList = new ArrayList<>();
        ArrayList<Integer> lg = laghu_set(ts);
        combinedList.addAll(lg);
        combinedList.addAll(lg);
        combinedList.addAll(drutam);
        combinedList.addAll(drutam);
        return combinedList;
    }
    public ArrayList dhruva_list(int ts){ //made up of one laghu followed by a drutam and two laghu(IOII)
        combinedList = new ArrayList<>();
        ArrayList<Integer> lg = laghu_set(ts);
        combinedList.addAll(lg);
        combinedList.addAll(drutam);
        combinedList.addAll(lg);
        combinedList.addAll(lg);
        return combinedList;
    }
    public ArrayList triputa_list(int ts){ //made up of one laghu and two drutams (IOO)
        combinedList = new ArrayList<>();
        combinedList.addAll(laghu_set(ts));
        combinedList.addAll(drutam);
        combinedList.addAll(drutam);
        return combinedList;
    }
    public ArrayList jhampa_list(int ts){ //made up of one laghu and one andrutam and one drutams (IUO)
        combinedList = new ArrayList<>();
        combinedList.addAll(laghu_set(ts));
        combinedList.addAll(andrutam);
        combinedList.addAll(drutam);
        return combinedList;
    }
    public ArrayList roopaka_list(int ts){ //made up of one drutam and one laghu (OI)
        combinedList = new ArrayList<>();
        combinedList.addAll(drutam);
        combinedList.addAll(laghu_set(ts));
        return combinedList;
    }
    public ArrayList matya_list(int ts){ //made up of one laghu, one drutam and one laghu (IOI)
        combinedList = new ArrayList<>();
        ArrayList<Integer> lg = laghu_set(ts);
        combinedList.addAll(lg);
        combinedList.addAll(drutam);
        combinedList.addAll(lg);
        return combinedList;
    }

    public ArrayList jathi_gesture_list (ArrayList<Integer> combo, int ts){
        combinedList = new ArrayList<>();
        for (int x : combo) {
            combinedList.add(x);
            for(int i = 0; i < ts - 1; i++){
                combinedList.add(subdiv);
            }
        }
        return  combinedList;
    }
    public ArrayList jathi_sound_list (ArrayList<Integer> combo, int ts){
        soundList = new ArrayList<>();
        for (int x : combo) {
            soundList.add(x);
            for(int i = 0; i < ts - 1; i++){
                soundList.add(4);
            }
        }
        return  soundList;
    }

    public ArrayList soundList (int glist_size){
        soundList = new ArrayList<>();
        soundList.add(1);
        for(int i = 0; i < glist_size - 1; i++){
            soundList.add(2);
        }
        return soundList;
    }



}
