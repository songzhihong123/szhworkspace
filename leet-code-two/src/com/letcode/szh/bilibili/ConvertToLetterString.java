package com.letcode.szh.bilibili;

/**
 * @ClassName ConvertToLetterString
 * @Description ConvertToLetterString
 * @Author szh
 * @Date 2024年01月06日
 */
public class ConvertToLetterString {


    /*
    规定1和A对应，2和B对应，3和C对应...
    那么一个数字字符串比如'111' ， 就可以转化为“AAA” , "KA" , "AK"
    给定一个只有数字字符组成的字符串str，返回有多少中转化结果
     */

    public static int number(String str){
        char[] strs = str.toCharArray();

        return process(strs , 0);
    }



    // i 之前的位置，如何转化已经做过决定了
    // i.. 有多少中转化的结果
    public static int process(char[] str , int i){
        // i 等于数据长度是，有一种
        if(i == str.length){
            return 1;
        }
        // str[i] 遇到‘0’ 的时候无法转化直接 返回0
        if(str[i] == '0'){
            return 0;
        }

        // str[i] 遇到1 的时候， 和 i + 1 位置结合，都小于 26
        if(str[i] == '1'){
            int res = process(str , i + 1); // i 自己作为单独的部分，后续有多少中方法
            if(i + 1 < str.length){
                res += process(str , i + 2); // (i和i+1)作为单独的部分，后续有多少中方法
            }
            return res;
        }

        // str[i] 遇到2 的时候， 和 i + 1 位置结合，不一定小于 26 ， 需要判断 i + 1 的位置需要 在 '0' , '6'之间 才可以
        if(str[i] == '2'){
            int res = process(str , i + 1); // i 自己作为单独的部分，后续有多少中方法
            if(i + 1 < str.length && (str[i + 1] >= '0' && str[i + 1] <= '6')){
                res += process(str , i + 2); // (i和i+1)作为单独的部分，后续有多少中方法
            }
            return res;
        }

        return process(str , i + 1);
    }








}
