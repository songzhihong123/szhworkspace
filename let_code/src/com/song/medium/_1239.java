package com.song.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @description:
 * @author: szh
 * @create: 2021-06-24 16:35
 **/
public class _1239 {

    public int maxLength(List<String> arr) {
        if(arr.size() == 0){
            return 0;
        }
        List<String> tempList = new ArrayList<>();
        for (String ts : arr) {
            if(tempList.isEmpty()){
                tempList.add(ts);
                continue;
            }
            char[] tsChars = ts.toCharArray();
            for (String tmpStr : tempList) {
                char[] tmpStrChars = tmpStr.toCharArray();
                a : for (char tmpStrChar : tmpStrChars) {
                        for (char tsChar : tsChars) {
                            if(tmpStrChar - tsChar == 0){
                                break a;
                            }
                        }
                    }

            }




        } 



        return -1;
    }



    public static void main(String[] args){
        _1239 obj = new _1239();
        List<String> arr = new ArrayList<>();
        arr.add("un");
        arr.add("iq");
        arr.add("ue");
        System.out.println(obj.maxLength(arr));
    }

}
