package com.example.asp_thalambeat_app;

import java.util.ArrayList;

public class MyBpmCalculator {
    private static  final  long MILISECONDS_PERMIN = 60000L;
    ArrayList<Long> timestamps;

    public MyBpmCalculator() { //Constructor
        timestamps = new ArrayList<>();
    }

    public void storeTime (){
        Long time = System.currentTimeMillis();
        timestamps.add(time);
    }

    public void clearTimeStamps (){
        timestamps.clear();
    }

    public ArrayList<Long> storeTapDelays (){
        ArrayList<Long> tapDelays = new ArrayList<>();
        int count = 0;
        while (timestamps.size() - 1 > count){
            tapDelays.add(timestamps.get(count+1) - timestamps.get(count));
            count++;
        }
        return tapDelays;
    }

    public int calculateBpm (ArrayList<Long> tapDelays){
        Long Total = 0L;
        for (Long tapDelay : tapDelays){
            Total = Total + tapDelay;
        }
        Long averageInterval = Total/ tapDelays.size();
        return (int) (MILISECONDS_PERMIN / averageInterval);
    }
}
