package com.letcode.szh.bilibili.middle;

import java.util.Arrays;

/**
 * @ClassName LongestNoRepeatSubstring
 * @Description LongestNoRepeatSubstring
 * @Author szh
 * @Date 2024年01月15日
 */
public class LongestNoRepeatSubstring {
    
    /* 
    求一个字符串中出现的最长字符字串
     */

    
    public static int maxUnique(String str){
        
        
        char[] chars = str.toCharArray();

        int[] map = new int[256];
        Arrays.fill(map , -1);


        int res = 0;
        int pre = -1;
        int cur = 0;

        for(int i = 0 ; i < chars.length; i++){
            // 上一个字符出现的长度 ，是 i - 1 长度或者是 当前字母上次出现的位置
            pre = Math.max(pre , map[chars[i]]);
            // 当前字符的最大长度
            cur = i - pre;

            res = Math.max(res , cur);
            map[chars[i]] = i;
        }

        return res;
    }
    


    
    
    
}
