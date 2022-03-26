package com.song.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _299 {

    public String getHint(String secret, String guess) {

        int acounter = 0;
        int[] cntS = new int[10];
        int[] cntG = new int[10];
        for (int i = 0; i < secret.length(); i++) {
            if(secret.charAt(i) == guess.charAt(i)){
                acounter ++;
            }else{
                cntS[secret.charAt(i) - '0']++;
                cntG[guess.charAt(i) - '0']++;
            }
        }

        int bcounter = 0;
        for (int i = 0; i < 10; i++) {
            bcounter += Math.min(cntS[i] , cntG[i]);
        }

        return acounter + "A" + bcounter + "B";
    }


    public static void main(String[] args){
        _299 obj = new _299();
        String secret = "1807";
        String guess =  "7810";
        System.out.println(obj.getHint(secret, guess));

    }



}
