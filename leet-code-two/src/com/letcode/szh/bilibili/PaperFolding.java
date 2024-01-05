package com.letcode.szh.bilibili;

/**
 * @ClassName PaperFolding
 * @Description PaperFolding
 * @Author szh
 * @Date 2024年01月04日
 */
public class PaperFolding {


    /*
        折纸问题：
        给一个N ，折纸N次， 打印折纸之后的方向
     */

    public static void printAllFolds(int N){
        printProcess(1 , N ,true);
    }

    // i表示节点层数， N 一共的层数 , down = true 凹 ， down = false 凸
    public static void printProcess(int i , int N ,boolean down){
        if(i > N){
            return;
        }

        printProcess(i + 1 , N , true);
        System.out.println(down ? "凹" : "凸");
        printProcess(i + 1 , N , false);
    }


    public static void main(String[] args) {
       int N = 3;
        printAllFolds(N);
    }



}
