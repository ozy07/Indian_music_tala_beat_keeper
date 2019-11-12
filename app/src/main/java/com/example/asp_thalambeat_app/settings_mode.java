package com.example.asp_thalambeat_app;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CompoundButton;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;


public class settings_mode extends Fragment {
    private Switch sound_switch, vis_switch;
    private Spinner talaspiner, jathispiner, nadaispiner;
    private TextView debugTV;
    private talas myTala;
    String tala_selection, jathi_selection, nadai_selection;
    ArrayList<Integer> gestureList, sound_list, talalist, talasoundlist;
    private int[] soundIDs;
    tala_settings_listener tala_listener;

    public interface tala_settings_listener {
        void soundSet(boolean isOn);
        void visualSet(boolean isOn);
        void DashSet (String thala, String jathis, String nadai);
        void typeSet (String type);
        void playList (ArrayList list, ArrayList s_list);
        void setNadai (int subdiv);
    }

    public settings_mode() {
        // Required empty public constructor
    }
    public void rec_sounds(int [] in_sounds){
        soundIDs = in_sounds;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View rootView = inflater.inflate(R.layout.fragment_settings_mode, container, false);
        myTala = new talas();

        sound_switch = rootView.findViewById(R.id.sound_switch);
        vis_switch = rootView.findViewById(R.id.visual_switch);
        talaspiner = rootView.findViewById(R.id.tala_spinner);
        jathispiner = rootView.findViewById(R.id.spinner_two);
        nadaispiner = rootView.findViewById(R.id.spinner_three);
        debugTV = rootView.findViewById(R.id.debugTV);
        sound_switch.setChecked(true);
        vis_switch.setChecked(true);
        tala_listener.visualSet(true);
        tala_listener.soundSet(true);
        ArrayAdapter<CharSequence> thalam_types = ArrayAdapter.createFromResource(getContext(),
                R.array.thalam_type, android.R.layout.simple_spinner_item);
        ArrayAdapter<CharSequence> jathi_types = ArrayAdapter.createFromResource(getContext(),
                R.array.jathis_type, android.R.layout.simple_spinner_item);
        ArrayAdapter<CharSequence> nadai_types = ArrayAdapter.createFromResource(getContext(),
                R.array.nadai_type, android.R.layout.simple_spinner_item);
        thalam_types.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        jathi_types.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        nadai_types.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        talaspiner.setAdapter(thalam_types);
        jathispiner.setAdapter(jathi_types);
        nadaispiner.setAdapter(nadai_types);

        talaspiner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                tala_selection = parent.getSelectedItem().toString();
                tala_listener.DashSet(tala_selection, jathi_selection, nadai_selection);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        jathispiner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                jathi_selection = parent.getSelectedItem().toString();
                tala_listener.DashSet(tala_selection, jathi_selection, nadai_selection);
                switch(jathi_selection){
                    case "Thisram - 3":
                        int thisram = 3;
                        if (tala_selection.equals("Eka - Default")){
                            gestureList = myTala.laghu_set(thisram);
                            sound_list = myTala.soundList(gestureList.size());
                            tala_listener.playList(gestureList, sound_list);
                            }
                        else if (tala_selection.equals("Dhruva")){
                            gestureList = myTala.dhruva_list(thisram);
                            sound_list = myTala.soundList(gestureList.size());
                            tala_listener.playList(gestureList, sound_list);
                        }
                        else if (tala_selection.equals("Matya")){
                            gestureList = myTala.matya_list(thisram);
                            sound_list = myTala.soundList(gestureList.size());
                            tala_listener.playList(gestureList, sound_list);
                        }
                        else if (tala_selection.equals("Rupaka")){
                            gestureList = myTala.roopaka_list(thisram);
                            sound_list = myTala.soundList(gestureList.size());
                            tala_listener.playList(gestureList, sound_list);
                        }
                        else if (tala_selection.equals("Jampa")){
                            gestureList = myTala.jhampa_list(thisram);
                            sound_list = myTala.soundList(gestureList.size());
                            tala_listener.playList(gestureList, sound_list);
                        }
                        else if (tala_selection.equals("Triputa")){
                            gestureList = myTala.triputa_list(thisram);
                            sound_list = myTala.soundList(gestureList.size());
                            tala_listener.playList(gestureList, sound_list);
                        }
                        else if (tala_selection.equals("Ata")){
                            gestureList = myTala.ata_List(thisram);
                            sound_list = myTala.soundList(gestureList.size());
                            tala_listener.playList(gestureList, sound_list);
                        }
                        break;

                    case "Chatusram - 4":
                        int cha = 4;
                        if (tala_selection.equals("Eka - Default")){
                            gestureList = myTala.laghu_set(cha);
                            sound_list = myTala.soundList(gestureList.size());
                            tala_listener.playList(gestureList, sound_list);
                        }
                        else if (tala_selection.equals("Dhruva")){
                            gestureList = myTala.dhruva_list(cha);
                            sound_list = myTala.soundList(gestureList.size());
                            tala_listener.playList(gestureList, sound_list);
                        }
                        else if (tala_selection.equals("Matya")){
                            gestureList = myTala.matya_list(cha);
                            sound_list = myTala.soundList(gestureList.size());
                            tala_listener.playList(gestureList, sound_list);
                        }
                        else if (tala_selection.equals("Rupaka")){
                            gestureList = myTala.roopaka_list(cha);
                            sound_list = myTala.soundList(gestureList.size());
                            tala_listener.playList(gestureList, sound_list);
                        }
                        else if (tala_selection.equals("Jampa")){
                            gestureList = myTala.jhampa_list(cha);
                            sound_list = myTala.soundList(gestureList.size());
                            tala_listener.playList(gestureList, sound_list);
                        }
                        else if (tala_selection.equals("Triputa")){
                            gestureList = myTala.triputa_list(cha);
                            sound_list = myTala.soundList(gestureList.size());
                            tala_listener.playList(gestureList, sound_list);
                        }
                        else if (tala_selection.equals("Ata")){
                            gestureList = myTala.ata_List(cha);
                            sound_list = myTala.soundList(gestureList.size());
                            tala_listener.playList(gestureList, sound_list);
                        }
                        break;
                    case "Kandam - 5":
                        int kand = 5;
                        if (tala_selection.equals("Eka - Default")){
                            gestureList = myTala.laghu_set(kand);
                            sound_list = myTala.soundList(gestureList.size());
                            tala_listener.playList(gestureList, sound_list);
                        }
                        else if (tala_selection.equals("Dhruva")){
                            gestureList = myTala.dhruva_list(kand);
                            sound_list = myTala.soundList(gestureList.size());
                            tala_listener.playList(gestureList, sound_list);
                        }
                        else if (tala_selection.equals("Matya")){
                            gestureList = myTala.matya_list(kand);
                            sound_list = myTala.soundList(gestureList.size());
                            tala_listener.playList(gestureList, sound_list);
                        }
                        else if (tala_selection.equals("Rupaka")){
                            gestureList = myTala.roopaka_list(kand);
                            sound_list = myTala.soundList(gestureList.size());
                            tala_listener.playList(gestureList, sound_list);
                        }
                        else if (tala_selection.equals("Jampa")){
                            gestureList = myTala.jhampa_list(kand);
                            sound_list = myTala.soundList(gestureList.size());
                            tala_listener.playList(gestureList, sound_list);
                        }
                        else if (tala_selection.equals("Triputa")){
                            gestureList = myTala.triputa_list(kand);
                            sound_list = myTala.soundList(gestureList.size());
                            tala_listener.playList(gestureList, sound_list);
                        }
                        else if (tala_selection.equals("Ata")){
                            gestureList = myTala.ata_List(kand);
                            sound_list = myTala.soundList(gestureList.size());
                            tala_listener.playList(gestureList, sound_list);
                        }
                        break;
                    case "Misram - 7":
                        int mis = 7;
                        if (tala_selection.equals("Eka - Default")){
                            gestureList = myTala.laghu_set(mis);
                            sound_list = myTala.soundList(gestureList.size());
                            tala_listener.playList(gestureList, sound_list);
                        }
                        else if (tala_selection.equals("Dhruva")){
                            gestureList = myTala.dhruva_list(mis);
                            sound_list = myTala.soundList(gestureList.size());
                            tala_listener.playList(gestureList, sound_list);
                        }
                        else if (tala_selection.equals("Matya")){
                            gestureList = myTala.matya_list(mis);
                            sound_list = myTala.soundList(gestureList.size());
                            tala_listener.playList(gestureList, sound_list);
                        }
                        else if (tala_selection.equals("Rupaka")){
                            gestureList = myTala.roopaka_list(mis);
                            sound_list = myTala.soundList(gestureList.size());
                            tala_listener.playList(gestureList, sound_list);
                        }
                        else if (tala_selection.equals("Jampa")){
                            gestureList = myTala.jhampa_list(mis);
                            sound_list = myTala.soundList(gestureList.size());
                            tala_listener.playList(gestureList, sound_list);
                        }
                        else if (tala_selection.equals("Triputa")){
                            gestureList = myTala.triputa_list(mis);
                            sound_list = myTala.soundList(gestureList.size());
                            tala_listener.playList(gestureList, sound_list);
                        }
                        else if (tala_selection.equals("Ata")){
                            gestureList = myTala.ata_List(mis);
                            sound_list = myTala.soundList(gestureList.size());
                            tala_listener.playList(gestureList, sound_list);
                        }
                        break;
                    case "Sankeernam - 9":
                        int san = 9;
                        if (tala_selection.equals("Eka - Default")){
                            gestureList = myTala.laghu_set(san);
                            sound_list = myTala.soundList(gestureList.size());
                            tala_listener.playList(gestureList, sound_list);
                        }
                        else if (tala_selection.equals("Dhruva")){
                            gestureList = myTala.dhruva_list(san);
                            sound_list = myTala.soundList(gestureList.size());
                            tala_listener.playList(gestureList, sound_list);
                        }
                        else if (tala_selection.equals("Matya")){
                            gestureList = myTala.matya_list(san);
                            sound_list = myTala.soundList(gestureList.size());
                            tala_listener.playList(gestureList, sound_list);
                        }
                        else if (tala_selection.equals("Rupaka")){
                            gestureList = myTala.roopaka_list(san);
                            sound_list = myTala.soundList(gestureList.size());
                            tala_listener.playList(gestureList, sound_list);
                        }
                        else if (tala_selection.equals("Jampa")){
                            gestureList = myTala.jhampa_list(san);
                            sound_list = myTala.soundList(gestureList.size());
                            tala_listener.playList(gestureList, sound_list);
                        }
                        else if (tala_selection.equals("Triputa")){
                            gestureList = myTala.triputa_list(san);
                            sound_list = myTala.soundList(gestureList.size());
                            tala_listener.playList(gestureList, sound_list);
                        }
                        else if (tala_selection.equals("Ata")){
                            gestureList = myTala.ata_List(san);
                            sound_list = myTala.soundList(gestureList.size());
                            tala_listener.playList(gestureList, sound_list);
                        }
                        break;
                    default:
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        nadaispiner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                nadai_selection = parent.getSelectedItem().toString();
               // debugTV.setText(jathi_selection + " " + tala_selection +" "+ nadai_selection);
                tala_listener.DashSet(tala_selection, jathi_selection, nadai_selection);
                tala_listener.typeSet("theTS");
               // debugTV.setText(Integer.toString(soundIDs[3]));
                switch (nadai_selection){
                    case "No Nadai":
                        tala_listener.playList(gestureList, sound_list);
                        tala_listener.setNadai(1);
                        break;
                    case "Chatusram Nadai":
                        talalist = myTala.jathi_gesture_list(gestureList,4);
                        talasoundlist = myTala.jathi_sound_list(sound_list,4);
                        tala_listener.playList(talalist,talasoundlist);
                        tala_listener.setNadai(4);
                        break;
                    case "Thisram Nadai":
                        talalist = myTala.jathi_gesture_list(gestureList,3);
                        talasoundlist = myTala.jathi_sound_list(sound_list,3);
                        tala_listener.playList(talalist,talasoundlist);
                        tala_listener.setNadai(3);
                        break;
                    case "Kandam Nadai":
                        talalist = myTala.jathi_gesture_list(gestureList,5);
                        talasoundlist = myTala.jathi_sound_list(sound_list,5);
                        tala_listener.playList(talalist,talasoundlist);
                        tala_listener.setNadai(5);
                        break;
                    case "Misram Nadai":
                        talalist = myTala.jathi_gesture_list(gestureList,7);
                        talasoundlist = myTala.jathi_sound_list(sound_list,7);
                        tala_listener.playList(talalist,talasoundlist);
                        tala_listener.setNadai(7);
                        break;
                    case "Sankeernam Nadai":
                        talalist = myTala.jathi_gesture_list(gestureList,9);
                        talasoundlist = myTala.jathi_sound_list(sound_list,9);
                        tala_listener.playList(talalist,talasoundlist);
                        tala_listener.setNadai(9);
                        break;
                    default:
                        break;
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        vis_switch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                tala_listener.visualSet(vis_switch.isChecked());
            }
        });
        sound_switch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                tala_listener.soundSet(sound_switch.isChecked());
            }
        });


        return rootView;
    }



    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof tala_settings_listener) {
            tala_listener = (tala_settings_listener) context;
        }
    }

    @Override
    public void onStop() {
        super.onStop();
        tala_listener = null;
    }
}
