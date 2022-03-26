package test;

import java.util.Arrays;

/**
 * Created by Zhihong Song on 2021/1/30 10:38
 */

public class Test {

    public int[] sort(int [] target){

        // [3,5,4,9,5,2]
        int len = target.length;
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                if(target[i] < target[j]){
                    int temp = target[i];
                    target[i] = target[j];
                    target[j] = temp;
                }
            }
        }
        return  target;
    }

    public static void main(String[] args) {
        Test test =  new Test();
        int[] a = {3,5,4,9,5,2};
//        Arrays.stream(test.sort(a)).forEach(System.out::print);
        test.quickSort(a,0,a.length - 1);
        Arrays.stream(a).forEach(System.out::print);
    }

    public void quickSort(int[] ints, int left, int right){
        //如果起始角标不小于结束角标退出递归
        if (right <= left) {
            return;
        }
        //记录开始结束角标，最后赋值使用
        int l = left;
        int r = right;
        //用最末尾值当中间值
        int temp = ints[r];
        //左右循环找到左边大于循环值，右边小于循环值，注意内部两个while循环先后顺序，与最后赋值有关
        while (l != r) {
            while (ints[l] <= temp && r > l) {
                l++;
            }
            while (ints[r] >= temp && r > l) {
                r--;
            }
            if (l <= r) {
                int t = ints[r];
                ints[r] = ints[l];
                ints[l] = t;
            }
        }
        //将最后一个值与大于他的最靠前的进行交换
        ints[right] = ints[r];
        ints[r] = temp;
        //中间值没有必要参与递归
        quickSort(ints, r + 1, right);
        quickSort(ints, left, r - 1);
    }

}
