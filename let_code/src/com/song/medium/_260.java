package com.song.medium;

import java.util.ArrayList;
import java.util.List;

public class _260 {

    public int[] singleNumber(int[] nums) {
        int xornum = 0;
        for(int num : nums){
            xornum ^= num;
        }
        int lsb = (Integer.MAX_VALUE == xornum ? xornum : xornum & -xornum);
        int type1 = 0;
        int type2 = 0;
        for (int num : nums){
            if((num & lsb) != 0){
                type1 ^= num;
            }else{
                type2 ^= num;
            }
        }
        return new int[]{type1 , type2};
    }

    public static void main(String[] args){
        _260 obj = new _260();
        int[] nums = {1,2,1,3,2,5};
//        obj.singleNumber(nums);

        System.out.println(6 & -6);

    }


}
