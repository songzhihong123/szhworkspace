package com.letcode.szh.bilibili;

/**
 * @ClassName CardsInLine
 * @Description CardsInLine
 * @Author szh
 * @Date 2024年01月06日
 */
public class CardsInLine {


    /*
    给定一个整型数组arr ， 代表数值不同的纸牌排成一条线。玩家A和玩家B依次拿走每张纸牌，规定玩家A先拿，
    玩家B后拿，但是每次只能拿走最左或最右的纸牌，玩家A和玩家B都绝顶聪明。请返回最后获胜者的分数。

    举例：
    arr = [1 ,2 ,100 ,4]
    开始，玩家A只能拿走1或者4.如果开始时玩家A拿走1，则排列变为[2 , 100 , 4]，接下来玩家B可以拿走2或者4，
    然后继续轮到玩家A...
    如果开始玩家A拿走4，则排列变为[1 ,2 ,100] ,接下来玩家B可以拿走1或者100，然后继续轮到玩家A....

    玩家A作为绝顶聪明的人不会先拿4，因为拿4之后，玩家B将拿走100.所以玩家A会先拿1，让排列变为[2 , 100 ,4]，
    接下来玩家B不管怎么选， 100都会被玩家A拿走。玩家A会获胜，分数变为101.所以返回101.
    arr=[1 , 100 ,2].
    开始时 ， 玩家A不管拿1还是2，玩家B作为绝顶聪明的人，都会把100拿走。玩家B会获胜，分数为100.所以返回100

     */


    public static int win1(int[] arr){
        if(arr == null || arr.length == 0){
            return 0;
        }
        return Math.max(f(arr , 0 , arr.length- 1) , s(arr , 0 , arr.length - 1));
    }



    // 定义一个先手函数
    public static int f(int[] arr , int i , int j){
        // 如果剩下一个数，我是先手 ， 我肯定就拿走了
        if(i == j){
            return arr[i];
        }
        // [先手拿左边的值 和 后手拿剩下的值]  与   [先手拿右边的值 和 后手拿剩下的值] 求最大值
       return Math.max(arr[i] + s(arr , i + 1 , j) , arr[j] + s(arr , i, j - 1));
    }


    //定义一个后手函数
    public static int s(int[] arr , int i , int j){
        // 如果剩下最后一个值，我是后手，那我就是0
        if(i == j){
            return 0;
        }
        // 先手拿左边的值 和 先手拿右边的值 取最小值
        return Math.min(f(arr , i + 1 , j) , f(arr , i , j - 1));
    }



    // 动态规划
    public static int dp(int[] arr){
        if(arr == null || arr.length == 0){
            return 0;
        }

        int[][] f = new int[arr.length][arr.length];
        int[][] s = new int[arr.length][arr.length];

        for(int i = 0 ; i < arr.length ; i++){
            f[i][i] = arr[i];
            s[i][i] = 0;
        }

        int row = 0;
        int col = 1;

        while(col < arr.length){
            int i = row;
            int j = col;
            while(i < arr.length && j < arr.length){
                f[i][j] = Math.max(arr[i] + s[i + 1][j] , arr[j] + s[i][j - 1]);
                s[i][j] = Math.min(f[i + 1][j] , f[i][j - 1]);
                i ++;
                j ++;
            }
            col ++;
        }
        return Math.max(f[0][arr.length- 1], s[0][arr.length- 1]);
    }


}
