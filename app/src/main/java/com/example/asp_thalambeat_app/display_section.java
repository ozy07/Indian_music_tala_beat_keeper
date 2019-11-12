package com.example.asp_thalambeat_app;

import android.content.Context;
import android.graphics.Color;
import android.media.AudioAttributes;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Vibrator;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ViewSwitcher;

import java.util.ArrayList;


public class display_section extends Fragment {

    private TextView bpmText, tsText, metroText, soundtv, alltv, visualtv;
    private int currentBpm, sub_division;
    private Handler myhandler = new Handler();
    private SoundPool mSoundPool;
    private int[] talaSoundList;
    private ImageSwitcher imswitch;
    private ArrayList<Integer> myTalaList, mySoundlist;
    private boolean playClicked, stopClicked, isPlaying, soundON, visualON;
    private String thalam_text, jathi_text, nadai_text, beatType_text;
   // display_section_listener display_listener;

    public display_section() {
        // Required empty public constructor
    }
    /*public interface display_section_listener{
        void loaded_sounds(int[] sound_ids);
    }*/


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View rootView = inflater.inflate(R.layout.fragment_display_section, container, false);
        bpmText = rootView.findViewById(R.id.bpm_display);
        tsText = rootView.findViewById(R.id.ts_display);
        metroText = rootView.findViewById(R.id.met_display);
        soundtv = rootView.findViewById(R.id.soundtv);
        visualtv = rootView.findViewById(R.id.visualtv);
        alltv = rootView.findViewById(R.id.alltv);
        imswitch = rootView.findViewById(R.id.image_switch);
        imswitch.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                ImageView imageView = new ImageView(getActivity().getApplicationContext());
                imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
                return imageView;
            }
        });
        talaSoundList = new int[4];


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            AudioAttributes audioAttributes = new AudioAttributes.Builder().
                    setUsage(AudioAttributes.USAGE_ASSISTANCE_SONIFICATION).
                    setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION).build();
            mSoundPool = new SoundPool.Builder().setMaxStreams(9).
                    setAudioAttributes(audioAttributes).build();
        } else {
            mSoundPool = new SoundPool(9, AudioManager.STREAM_MUSIC, 0);
        }

        talaSoundList[0] = mSoundPool.load(getContext(), R.raw.click, 1);
        talaSoundList[1] = mSoundPool.load(getContext(), R.raw.wood, 1);
        talaSoundList[2] = mSoundPool.load(getContext(), R.raw.metronome_s, 1);
        talaSoundList[3] = mSoundPool.load(getContext(), R.raw.cross_sticks, 1);

       // display_listener.loaded_sounds(talaSoundList); //send sound IDs to settings mode
        //tsText.setText(Integer.toString(talaSoundList[3]));

        playClicked = false;
        stopClicked = false;
        isPlaying = false;

        return rootView;
    }



    public void updateBPM(int bPm) {
        currentBpm = bPm;
        bpmText.setText(String.valueOf(currentBpm));
    }
    public void updateSubDiv (int sub){
        sub_division = sub;
    }

    public void playBeat(boolean play) {
        if (soundON && visualON) {
            alltv.setTextColor(getResources().getColor(R.color.colorGold));
            soundtv.setTextColor(getResources().getColor(R.color.colorGrey));
            visualtv.setTextColor(getResources().getColor(R.color.colorGrey));
        } else if (soundON) {
            soundtv.setTextColor(getResources().getColor(R.color.colorGold));
            visualtv.setTextColor(getResources().getColor(R.color.colorGrey));
            alltv.setTextColor(getResources().getColor(R.color.colorGrey));
            imswitch.setImageResource(R.drawable.blank);
        } else if (visualON) {
            visualtv.setTextColor(getResources().getColor(R.color.colorGold));
            soundtv.setTextColor(getResources().getColor(R.color.colorGrey));
            alltv.setTextColor(getResources().getColor(R.color.colorGrey));
        }
        playClicked = play;
        //loadSound(myTalaList.size());
// ********        tsText.setText(Integer.toString(myTalaList.get(myTalaList.size() - 1)));
        StartBeat(mySoundlist, myTalaList);
    }

    public void stopBeat(boolean stop) {
        stopClicked = stop;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
       /* if (context instanceof display_section.display_section_listener) {
            display_listener = (display_section.display_section_listener) context;
        }*/


    }

    @Override
    public void onDetach() {
        super.onDetach();
      //  display_listener = null;
    }

    public void StartBeat(final ArrayList<Integer> talaList, final ArrayList<Integer> gList) {
        //final int tempoNum = currentBpm;

        final Runnable beatrun = new Runnable() {
            @Override
            public void run() {
                isPlaying = true;
                for (int a = 1; a > 0; a++) {
                    //int time_sign = talaList.size();
                    for (int i = 0; i < gList.size(); i++) {
                        final int b = i;
                        myhandler.post(new Runnable() {
                            @Override
                            public void run() {
                                if (soundON && visualON) {
                                    mSoundPool.play(talaList.get(b), 1,
                                            1, 0, 0, 1);

                                    imswitch.setImageResource(gList.get(b));
                                } else if (!soundON && visualON) {
                                    imswitch.setImageResource(gList.get(b));
                                } else if (soundON && !visualON) {
                                    mSoundPool.play(talaList.get(b), 1,
                                            1, 0, 0, 1);
                                }

                            }
                        });
                        try {
                            Thread.sleep((60000 / (currentBpm + 1))/sub_division);
                        } catch (InterruptedException ex) {
                            ex.printStackTrace();

                        }

                        if (stopClicked) break;
                    }
                    if (stopClicked) break;
                }

            }
        };

        Thread playing = new Thread(beatrun);
        playing.start();
        stopClicked = false;


    }

    public void setTalaType(ArrayList list, ArrayList s_list) {
        myTalaList = list;
        mySoundlist = s_list;
    }

    public void setSound(boolean isOn) {
        soundON = isOn;
    }

    public void setVisual(boolean isOn) {
        visualON = isOn;
    }

    public void setDash(String tala, String jathi, String nadai) {
        thalam_text = tala;
        jathi_text = jathi;
        nadai_text = nadai;
        metroText.setText(tala + "|" + jathi + "|" + nadai);
    }

    public void setBeatType(String btype) {
        beatType_text = btype;
        // tsText.setText(beatType_text);
    }


}
