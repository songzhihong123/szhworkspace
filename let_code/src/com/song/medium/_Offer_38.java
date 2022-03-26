package com.song.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @description:
 * @author: szh
 * @create: 2021-06-24 14:44
 **/
public class _Offer_38 {

    List<String> result = new ArrayList<>();
    boolean[] vis;
    int n;

    public String[] permutation(String s) {
        char[] arr = s.toCharArray();
        Arrays.sort(arr);
        n = s.length();
        vis = new boolean[n];
        StringBuffer perm = new StringBuffer();
        backtrack(arr , 0 , perm);
        int size = result.size();
        String[] recArr = new String[size];
        for (int i = 0; i < size; i++) {
            recArr[i] = result.get(i);
        }
        return recArr;
    }

    //回溯法
    public void backtrack(char[] arr , int i ,StringBuffer perm){
        if(i == n){
            result.add(perm.toString());
            return;
        }
        for (int j = 0; j < n; j++) {
            if(vis[j] || (j > 0 && !vis[j - 1] && arr[j - 1] == arr[j])){
                continue;
            }
            vis[j] = true;
            perm.append(arr[j]);
            backtrack(arr , i + 1 , perm);
            perm.deleteCharAt(perm.length() - 1);
            vis[j] = false;
        }
    }

    public static void main(String[] args){
        _Offer_38 obj = new _Offer_38();
        String s = "abc";
        System.out.println(obj.permutation(s));
    }


}
