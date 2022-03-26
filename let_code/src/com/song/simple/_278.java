package com.song.simple;

/**
 * @description:
 * @author: szh
 * @create: 2021-06-15 10:51
 **/
public class _278 {

    public int firstBadVersion(int n) {
        int left = 1;
        int right = n;
        while(left < right){
            int mid = left + (right - left) / 2;
            if(isBadVersion(mid)){
                right = mid;
            }else{
                left = mid + 1;
            }

        }
        return left;
    }

    public static void main(String[] args){

    }

    //  接口来判断版本号 version 是否在单元测试中出错
    boolean isBadVersion(int version){

        return true;
    }

}
