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
    ArrayList<Integer> gestureList;
    tala_settings_listener tala_listener;

    public interface tala_settings_listener {
        void soundSet(boolean isOn);
        void visualSet(boolean isOn);
        void DashSet (String thala, String jathis, String nadai);
        void typeSet (String type);
        void playList (ArrayList list);
    }

    public settings_mode() {
        // Required empty public constructor
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
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        jathispiner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                jathi_selection = parent.getSelectedItem().toString();
               // Toast.makeText(getContext(), tala_selection +" "+jathi_selection,
               //         Toast.LENGTH_SHORT).show();
                switch(jathi_selection){
                    case "Thisram - 3":
                        int thisram = 3;
                        if (tala_selection.equals("Eka - Default")){
                            gestureList = myTala.laghu_set(thisram);
                            tala_listener.playList(gestureList);
                            }
                        else if (tala_selection.equals("Dhruva")){
                            gestureList = myTala.dhruva_list(thisram);
                            tala_listener.playList(gestureList);
                        }
                        else if (tala_selection.equals("Matya")){
                            gestureList = myTala.matya_list(thisram);
                            tala_listener.playList(gestureList);
                        }
                        else if (tala_selection.equals("Rupaka")){
                            gestureList = myTala.roopaka_list(thisram);
                            tala_listener.playList(gestureList);
                        }
                        else if (tala_selection.equals("Jampa")){
                            gestureList = myTala.jhampa_list(thisram);
                            tala_listener.playList(gestureList);
                        }
                        else if (tala_selection.equals("Triputa")){
                            gestureList = myTala.triputa_list(thisram);
                            tala_listener.playList(gestureList);
                        }
                        else if (tala_selection.equals("Ata")){
                            gestureList = myTala.ata_List(thisram);
                            tala_listener.playList(gestureList);
                        }
                        break;

                    case "Chatusram - 4":
                        int cha = 4;
                        if (tala_selection.equals("Eka - Default")){
                            gestureList = myTala.laghu_set(cha);
                            tala_listener.playList(gestureList);
                        }
                        else if (tala_selection.equals("Dhruva")){
                            gestureList = myTala.dhruva_list(cha);
                            tala_listener.playList(gestureList);
                        }
                        else if (tala_selection.equals("Matya")){
                            gestureList = myTala.matya_list(cha);
                            tala_listener.playList(gestureList);
                        }
                        else if (tala_selection.equals("Rupaka")){
                            gestureList = myTala.roopaka_list(cha);
                            tala_listener.playList(gestureList);
                        }
                        else if (tala_selection.equals("Jampa")){
                            gestureList = myTala.jhampa_list(cha);
                            tala_listener.playList(gestureList);
                        }
                        else if (tala_selection.equals("Triputa")){
                            gestureList = myTala.triputa_list(cha);
                            tala_listener.playList(gestureList);
                        }
                        else if (tala_selection.equals("Ata")){
                            gestureList = myTala.ata_List(cha);
                            tala_listener.playList(gestureList);
                        }
                        break;
                    case "Kandam - 5":
                        int kand = 5;
                        if (tala_selection.equals("Eka - Default")){
                            gestureList = myTala.laghu_set(kand);
                            tala_listener.playList(gestureList);
                        }
                        else if (tala_selection.equals("Dhruva")){
                            gestureList = myTala.dhruva_list(kand);
                            tala_listener.playList(gestureList);
                        }
                        else if (tala_selection.equals("Matya")){
                            gestureList = myTala.matya_list(kand);
                            tala_listener.playList(gestureList);
                        }
                        else if (tala_selection.equals("Rupaka")){
                            gestureList = myTala.roopaka_list(kand);
                            tala_listener.playList(gestureList);
                        }
                        else if (tala_selection.equals("Jampa")){
                            gestureList = myTala.jhampa_list(kand);
                            tala_listener.playList(gestureList);
                        }
                        else if (tala_selection.equals("Triputa")){
                            gestureList = myTala.triputa_list(kand);
                            tala_listener.playList(gestureList);
                        }
                        else if (tala_selection.equals("Ata")){
                            gestureList = myTala.ata_List(kand);
                            tala_listener.playList(gestureList);
                        }
                        break;
                    case "Misram - 7":
                        int mis = 7;
                        if (tala_selection.equals("Eka - Default")){
                            gestureList = myTala.laghu_set(mis);
                            tala_listener.playList(gestureList);
                        }
                        else if (tala_selection.equals("Dhruva")){
                            gestureList = myTala.dhruva_list(mis);
                            tala_listener.playList(gestureList);
                        }
                        else if (tala_selection.equals("Matya")){
                            gestureList = myTala.matya_list(mis);
                            tala_listener.playList(gestureList);
                        }
                        else if (tala_selection.equals("Rupaka")){
                            gestureList = myTala.roopaka_list(mis);
                            tala_listener.playList(gestureList);
                        }
                        else if (tala_selection.equals("Jampa")){
                            gestureList = myTala.jhampa_list(mis);
                            tala_listener.playList(gestureList);
                        }
                        else if (tala_selection.equals("Triputa")){
                            gestureList = myTala.triputa_list(mis);
                            tala_listener.playList(gestureList);
                        }
                        else if (tala_selection.equals("Ata")){
                            gestureList = myTala.ata_List(mis);
                            tala_listener.playList(gestureList);
                        }
                        break;
                    case "Sankeernam - 9":
                        int san = 9;
                        if (tala_selection.equals("Eka - Default")){
                            gestureList = myTala.laghu_set(san);
                            tala_listener.playList(gestureList);
                        }
                        else if (tala_selection.equals("Dhruva")){
                            gestureList = myTala.dhruva_list(san);
                            tala_listener.playList(gestureList);
                        }
                        else if (tala_selection.equals("Matya")){
                            gestureList = myTala.matya_list(san);
                            tala_listener.playList(gestureList);
                        }
                        else if (tala_selection.equals("Rupaka")){
                            gestureList = myTala.roopaka_list(san);
                            tala_listener.playList(gestureList);
                        }
                        else if (tala_selection.equals("Jampa")){
                            gestureList = myTala.jhampa_list(san);
                            tala_listener.playList(gestureList);
                        }
                        else if (tala_selection.equals("Triputa")){
                            gestureList = myTala.triputa_list(san);
                            tala_listener.playList(gestureList);
                        }
                        else if (tala_selection.equals("Ata")){
                            gestureList = myTala.ata_List(san);
                            tala_listener.playList(gestureList);
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
