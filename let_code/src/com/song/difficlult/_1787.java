package com.song.difficlult;

import java.sql.Timestamp;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @description:
 * @author: szh
 * @create: 2021-05-28 15:02
 **/
public class _1787 {

    // x 的范围是[0 , 2^10 )
    public static int MAXX = 1 << 10;

    // 最大值，为了防止整数溢出选择 INFTY_MAX / 2
    public static final int INFTY = Integer.MAX_VALUE / 2;

    public int minChanges(int[] nums, int k) {
        int n = nums.length;
        int[] f = new int[MAXX];
        Arrays.fill(f , INFTY);
        //边界条件 f(-1 , 0) = 0
        f[0] = 0;

        for (int i = 0; i < k; i++) {
            Map<Integer , Integer> cnt = new HashMap<>();
            int size = 0;
            for (int j = i; j < n; j += k) {
                cnt.put(nums[j] , cnt.getOrDefault(nums[j] , 0) + 1);
                ++ size;
            }
            //求出t2
            int t2min = Arrays.stream(f).min().getAsInt();

            int[] g = new int[MAXX];
            Arrays.fill(g ,t2min);
            for (int mask = 0; mask < MAXX; mask++) {
                // t1 需要枚举 x 才能求出
                for(Map.Entry<Integer , Integer> entry : cnt.entrySet()){
                    int x = entry.getKey();
                    int conutx = entry.getValue();
                    g[mask] = Math.min(g[mask] , f[mask ^ x] - conutx);
                }
            }
            for (int j = 0; j < MAXX; j++) {
                g[j] += size;
            }
            f = g;
        }
        return f[0];
    }

    public static void main(String[] args){
        _1787 obj = new _1787();
        int[] nums  = {3,4,5,2,1,7,3,4,7};
        int k = 3;
//        System.out.println(obj.minChanges(nums, k));
        String str = "2021-05-19 11:22:41";
        Date timestamp = Timestamp.valueOf(str);
        System.out.println(timestamp);
    }

}
