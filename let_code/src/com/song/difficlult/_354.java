package com.song.difficlult;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by Zhihong Song on 2021/3/23 19:58
 */

public class _354 {


    public int maxEnvelopes(int[][] envelopes) {
        if (envelopes.length == 0){
            return 0;
        }

        int n = envelopes.length;
        Arrays.sort(envelopes, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0] != o2[0]){
                    return o1[0] - o2[0];
                }else{
                    return o2[1] - o1[1];
                }
            }
        });

        int[] f= new int[n];
        Arrays.fill(f,1);

        int ans = 1;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (envelopes[j][1] < envelopes[i][1]){
                    f[i] = Math.max(f[i],f[j] + 1);
                }
            }
            ans = Math.max(ans , f[i]);
        }
        return ans;
    }




    public static void main(String[] args){

        int[][] envelopes = {{5,4},{6,4},{6,7},{2,3}};
        _354 obj = new _354();
        System.out.println(obj.maxEnvelopes(envelopes));

    }


}
