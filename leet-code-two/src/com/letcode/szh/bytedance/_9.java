package com.letcode.szh.bytedance;

/**
 * @ClassName _9
 * @Description 回文数
 * @Author szh
 * @Date 2024年01月02日
 */
public class _9 {

    public boolean isPalindrome(int x) {
        String strx = String.valueOf(x);
        int left = 0;
        int right = strx.length() - 1;

        while(left < right){
            char cl = strx.charAt(left);
            char cr = strx.charAt(right);
            if(cl != cr){
                return false;
            }
            left ++;
            right --;
        }
        return true;
    }





}
