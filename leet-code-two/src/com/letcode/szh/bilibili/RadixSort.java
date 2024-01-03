package com.letcode.szh.bilibili;

/**
 * @ClassName RadixSort
 * @Description 桶排序
 * @Author szh
 * @Date 2024年01月03日
 */
public class RadixSort {

    public static void radixSort(int[] arr){

        radixSort(arr , 0 , arr.length - 1 , maxbits(arr));
    }

    // 求一个数组里面最大值有多少位
    public static int maxbits(int[] arr){
        int max = Integer.MIN_VALUE;
        for(int i = 0 ; i < arr.length ; i++){
            max = Math.max(max , arr[i]);
        }
        int res = 0;
        while(max != 0){
            res ++;
            max /= 10;
        }
        return res;
    }

    // arr[begin..end]排序
    public static void radixSort(int[] arr , int L , int R , int digit){
        final int radix = 10;
        int i = 0 , j = 0;
        // 有多少个辅助空间
        int[] bucket = new int[R - L + 1];
        // 表示需要进桶出桶多少次，有多少位就进出多少次
        // d = 1 : 表示个位上的数字
        // d = 2 : 表示十位上的数字
        for(int d = 1 ; d <= digit ; d++){
            // 10个空间
            // count[0] 当前位（d位）的是0的数字有多少个
            // count[1] 当前位（d位）的是(0和1)的数字有多少个
            // count[2] 当前位（d位）的是(0和1和2)的数字有多少个
            // count[i] 当前位（d位）的是(0～i)的数字有多少个
            int[] count = new int[radix];
            // 第一步：填充count数组
            for(i = L ; i <= R ; i++){
                j = getDigit(arr[i] , d);
                count[j] ++;
            }

            //第二步： 求 count[0..i] 的和
            for(i = 1 ; i < radix ; i ++){
                count[i] = count[i - 1] + count[i];
            }

            // 第三步：填充辅助空间
            for(i = R ; i >= L ; i --){
                j = getDigit(arr[i] , d);
                bucket[count[j] - 1] = arr[i];
                count[j] --;
            }
            // 第四步：把辅助空间的值放到之前的数据里面
            for(i = L , j = 0 ; i <= R ; i ++ , j++){
                arr[i] = bucket[j];
            }
        }
    }

    // 求数值i在d位值上的数子
    // d = 1 表示个位
    // d = 2 表示十位
    // 525 ,  2
    public static int getDigit(int i , int d){

       return ((i / ((int)Math.pow(10 , d - 1))) % 10);
    }


    public static void main(String[] args) {
        int[] arr = {12 , 13 , 56 , 6 ,10 , 88 , 8};
        radixSort(arr);

        for(int ar : arr){
            System.out.print(ar + " ");
        }
    }


}
