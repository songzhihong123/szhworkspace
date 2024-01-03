package com.letcode.szh.bilibili;

/**
 * @ClassName _6QuickSort
 * @Description 快速排序
 * @Author szh
 * @Date 2023年12月30日
 */
public class QuickSort {

    /**
     *
     * 1、从序列中随机挑出一个元素，作为“基准”；
     * 2、重新排列序列，将所有比基准值小的元素摆放在基准前面，所有比基准值大的摆在基准的后面，
     * 相同的树可以到任一边。在这个操作结束之后，该基准就处于数列的中间位置。这个称为分区操作
     * 3、递归的把小于基准元素的子序列和大于基准的子序列进行快速排序
     *
     *
     */


    public static void quickSort(int[] arr){

        quickSort(arr , 0 , arr.length - 1);
    }


    public static void quickSort(int[] arr , int low , int high){
        if(low >= high){
            return ;
        }
        // 找一个随机值作为基准值
//        swap(arr , (int)(Math.random() * (high - low + 1)) , high);

        int[] position = partition(arr , low , high);

        quickSort(arr , low , position[0] - 1);
        quickSort(arr , position[1] + 1 , high);
    }

    // 这是一个处理arr[low , high]的函数
    // 默认以arr[high]作为边界值
    // 返回等于区域(左边界 ， 右边界)
    public static int[]  partition(int[] arr , int L , int R){

        int less = L - 1; // < 区的右边界
        int more = R; // > 区的左边界

        while(L < more){
            if(arr[L] < arr[R]){
                // 当前位置的值小于基准值， 当前位置的值和小于区的前一个位置的数字，交换位置，然后小于区右移
                swap(arr , ++less , L++);
            }else if(arr[L] > arr[R]){
                // 当前位置的值大于基准值，当前位置和大于区的前一个位置的数字 交换位置， 然后 大于区左移
                swap(arr , --more , L);
            }else{
                // 相等 移动位置即可
                L ++;
            }
        }

        swap(arr , more , R);

        return new int[]{less + 1, more};
    }


    public static void swap(int[] arr , int i , int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


    public static void main(String[] args) {
        int[] arr = {12 , 13 , 56 , 10 ,10 , 88 , 13};
        quickSort(arr);

        for(int ar : arr){
            System.out.print(ar + " ");
        }
    }


}
