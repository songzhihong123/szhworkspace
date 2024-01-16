package com.letcode.szh.bilibili.middle;

/**
 * @ClassName EditCost
 * @Description EditCost
 * @Author szh
 * @Date 2024年01月15日
 */
public class EditCost {


    /*

        给定两个字符串str1和str2 ， 在给定三个整数ic 、 dc、rc ， 分别代表插入、删除
        和替换一个字符的代价， 返回将str1编辑成str2的最小代价。

        abcdef -> skbcdf


     */



    //  ic 插入代价    dc 删除代价   rc 替换代价
    public static int minCost(String str1 , String str2 , int ic ,int dc , int rc){


        char[] chs1 = str1.toCharArray();
        char[] chs2 = str2.toCharArray();

        int row = chs1.length + 1;
        int col = chs2.length + 1;

        // dp[i][j] 表示 str1[0..i-1] 变为 srt2[0-j-1] 需要的最小代价

        int[][] dp = new int[row][col];

        for(int i = 1 ; i < row ; i++){
            dp[i][0] = dc * i;
        }

        for(int j = 1 ; j< col ; j++){
            dp[0][j] = ic * j;
        }


        for(int i = 1 ; i < row ; i++){
            for(int j = 1 ; j < col ; j++){
                // srt1[i - 1] == str2[j-1] , 可以【选择不变】 或者  【是将srt1[i - 1] 位置的值 替换为 str2[j-1]的位置】
                if(chs1[i - 1] == chs2[j - 1]){
                    dp[i][j] = dp[i - 1][j - 1];
                }else{
                    dp[i][j] = dp[i - 1][j - 1] + rc;
                }


                // str1[0 - i-2] 变为 str2[0 - i-1]  并且 给 str[i-1] 位置的值加上
                dp[i][j] = Math.min(dp[i][j] , dp[i][j - 1] + ic);

                // str1[0 - i-1] 变为 str2[0 - i-2]  并且 给 str[i-1] 位置的值删掉
                dp[i][j] = Math.min(dp[i][j] , dp[i - 1][j] + dc);

            }
        }



        return dp[row - 1] [col - 1];


    }






}
