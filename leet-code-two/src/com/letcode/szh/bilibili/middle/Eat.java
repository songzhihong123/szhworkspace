package com.letcode.szh.bilibili.middle;

/**
 * @ClassName Eat
 * @Description Eat
 * @Author szh
 * @Date 2024年01月11日
 */
public class Eat {


    /*

    有“先手” 和 “后手” 两个角色吃草， 每个角色只能吃 4^x 的草
    谁先吃完谁获胜，

    “先手”和“后手” 都绝顶聪明 ， 不可以不吃草的情况下


     */

    public static String winner1(int n){
        // 0  1  2  3  4
        //后  先  后  先  先
        if(n < 5){
            return (n == 0 || n == 2) ? "后手" : "先手";
        }

         // n >= 5时
        int base = 1; //先手决定吃的草

        while(base <= n){
            // 当前一共n份草， 先手吃掉的是base份， n - base 是留给后手的草
            // 如果是别人先吃了base份，那我在n-base里面吃，此时我是后手的身份
            if(winner1(n - base).equals("后手")){
                return "先手";
            }

            if(base > n / 4){ // 防止溢出 ， 用除法也是为了防止溢出
                break;
            }

            base *= 4;
        }

        return "后手";
    }

    // 打表
    public static String winner2(int n){
        if(n % 5 == 0 || n % 5 == 2){
            return "后手";
        }else{
            return "先手";
        }
    }



    public static void main(String[] args) {
        for(int i = 0 ; i <= 50 ; i ++){
            System.out.println(i + ": " + winner1(i));
        }
    }


}
