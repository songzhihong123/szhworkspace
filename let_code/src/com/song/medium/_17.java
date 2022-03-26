package com.song.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: szh
 * @create: 2021-06-25 15:39
 **/
public class _17 {

    List<String> result = new ArrayList<>();
    int n ;


    public List<String> letterCombinations(String digits) {
        String[] source = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        char[] chars = digits.toCharArray();
        List<String> tempList = new ArrayList<>();
        for (char aChar : chars) {
            tempList.add(source[aChar]);
        }
        n = tempList.size();



        return result;
    }

    public void backtrack(int idx , List<String> curr, StringBuffer combination){
        if(idx == n){
            result.add(combination.toString());
            return;
        }
        String s = curr.get(idx);


    }




    public static void main(String[] args){
        _17 obj = new _17();
        String digits = "23";
//        System.out.println(obj.letterCombinations(digits));

        String str = "/a/b/cvb";
        str = str.substring(str.indexOf("/",str.indexOf("/") + 1));
        System.out.println(str);
    }

}
