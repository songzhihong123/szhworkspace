package com.song.simple;

public class _495 {


    public int findPoisonedDuration(int[] timeSeries, int duration) {
        int len = timeSeries.length;
        if(len == 1){
            return duration;
        }
        int result = 0;
        for (int i = 1; i < len; i++) {
            if(timeSeries[i] - timeSeries[i - 1] >= duration){
                result += duration;
            }else{
                result += timeSeries[i] - timeSeries[i - 1];
            }
        }
        return result + duration;

    }


    public static void main(String[] args){
        _495 obj = new _495();
        int[] timeSeries = {1,4};
        int duration = 2;
        System.out.println(obj.findPoisonedDuration(timeSeries , duration));
    }


}
