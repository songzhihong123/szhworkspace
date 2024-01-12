package com.letcode.szh.bilibili.middle;

/**
 * @ClassName AppleMinBags
 * @Description AppleMinBags
 * @Author szh
 * @Date 2024年01月10日
 */
public class AppleMinBags {

    /*
       小虎取附近的商店买苹果，奸诈的商贩使用了捆绑交易， 只提供6个每袋
       和8个每袋的包装不可拆分。可是小虎现在只想购买恰好n个苹果，小虎想
       购买尽量少的袋数方便携带。如果不能购买恰好n个苹果，小虎将不会购买
       。输入一个整数n，表示小虎想购买的苹果数，返回最小使用多少袋子。如果
       无论如何都不能正好装下，返回-1

     */

    public static int minBags(int applet){
         if(applet <= 0){
            return 0;
        }

        // 奇数直接返回 获取 苹果数量小于6 个， 肯定装不了，直接返回-1
        if((applet % 2 != 0) || applet < 6){
            return -1;
        }

        int bag8 = applet / 8;
        int rest = applet % 8;

        // 装8个苹果的袋子正好装满
        if(rest == 0){
            return bag8;
        }

        // 剩下的苹果 正好钩状6个苹果的袋子
        if(rest % 6 == 0){
            return bag8 + (rest / 6);
        }

        while(bag8 >= 0){
            // 优化，当剩余的苹果树超过24，肯定是装不了了
            // 直接返回-1 ,如果剩余苹果大于24了，我就用8个袋子了
            if(rest > 24){
                return -1;
            }
            // 不是6的倍数
            if(rest % 6 != 0){
                rest += 8;
                bag8 --;
            }else{
                // 是6的倍数啦
                return bag8 + (rest / 6);
            }
        }
        return -1;
    }


    // 打表
    public static int minBagAwesome(int apple){
        if((apple & 1) != 0){ // 是奇数
            return  -1;
        }

        if(apple < 18){
            return apple == 0 ? 0 : (apple == 6 || apple == 8) ? 1
                    : (apple == 12 || apple == 14 || apple == 16) ? 2 : -1;
        }


        return (apple - 18) / 8 + 3;
    }




    public static void main(String[] args) {

        for(int i = 1 ; i <= 100 ; i ++){
            System.out.println(i + ":" + minBags(i) + " ");
        }


    }



}
