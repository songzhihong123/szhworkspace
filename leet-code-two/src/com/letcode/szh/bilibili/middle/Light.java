package com.letcode.szh.bilibili.middle;

/**
 * @ClassName Light
 * @Description Light
 * @Author szh
 * @Date 2024年01月15日
 */
public class Light {

    /*

       小Q正在给一条长度为n的道路设计路灯安置方案。
       为了让问题更简单，小Q把道路视为n个方格，需要照亮的地方用‘.’ 表示，不需要
       照亮的障碍物格子用‘X’表示。小Q现在要在道路上设置一些路灯，对于安置在pos位置的路灯，这盏路灯
       可以照亮pos-1，pos，pos+1这三个位置。小Q希望能安置尽量少的路灯照亮所有'.'的区域。希望你能帮他计算一下
       最少需要多少盏路灯。


       输入描述：
        s中只有‘.’ 或者 ‘X’ 两种字符
        输出一个整数表示最少需要多少盏路灯
     */



    // s中只有‘.’ 或者 ‘X’ 两种字符
    // 路灯可以影响左中右三个位置
    //至少需要多少灯，可i把.都点亮
    public static int minLight(String s){

        char[] str = s.toCharArray();

        int index = 0;
        int light = 0;
        // ..XX....XX
        // ..........
        while(index < s.length()){
            // 当前位置是X直接跳过去
            if(str[index] == 'X'){
                index ++;
            }else{ //str[index] == '.'
                // 当前位置是，的话直接给灯
                light ++;
                // 下一个位置到了最后，直接结束
                if(index + 1 == s.length()){
                    break;
                }else{
                    // 下个位置是X，直接跳到下下个位置
                    if(str[index + 1] == 'X'){
                        index = index + 2;
                    }else{
                        // 下个位置是. 的话， 下个位置会被当前位置的灯照亮
                        // 直接跳转到index + 3 的位置，
                        index = index + 3;
                    }
                }



            }
        }

        return light;
    }


    public static int minLight1(String s){
        if(s == null || s.length() == 0){
            return 0;
        }
        return process(s.toCharArray() , 0 , true);
    }


    // str 表述字符数组
    // index 表示当前位置
    // pre表示前一个灯亮不亮 ， true表示亮， false表示不亮
    // 返回最少需要多少盏路灯
    public static int process(char[] str , int index , boolean pre){
        if(index == str.length){
            return 0;
        }

        if(index == str.length - 1){
            if(!pre && str[index] == 'X'){
                return -1;
            }
            if(pre && str[index] == 'X'){
                return 0;
            }
            return 1;
        }

        int res = Integer.MAX_VALUE;
        int light = 0;
       if(pre){ // 前一个位置亮灯
           if(str[index] == 'X'){
               light = process(str , index + 1, true);
               res = Math.min(res , light);
           }else{ //index 不是 'X'
               // index位置不放灯
               light = process(str , index + 1, false);
               if(light != -1){
                   res = Math.min(res , light);
               }

               // index位置放灯
               light = process(str , index + 2, true);
               if(light != -1){
                   res = Math.min(res , light + 1);
               }
           }
       }else{ // 前一个位置不亮灯
            if(str[index] == 'X'){
                res = -1;
            }else{
                light = process(str , index + 2, true);
                if(light != -1){
                    res = Math.min(res , light + 1);
                }
            }
       }


       return res == Integer.MAX_VALUE ? -1 : res;

    }


    public static void main(String[] args) {
//        String s = "..XX....XX";
        String s = "..........";

        System.out.println(minLight(s));
        System.out.println(minLight1(s));
    }



}
