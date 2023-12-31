package com.letcode.szh.sort;

/**
 * @ClassName _7HeapSort
 * @Description 堆排序
 * @Author szh
 * @Date 2023年12月31日
 */
public class _7HeapSort {

    public static void swap(int[] arr , int i , int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // 求下标为k的父亲节点
    public static int parent(int k){
        return (k - 1) / 2;
    }

    // 求下标为k的左孩子节点
    public static int leftChild(int k){
        return k * 2 + 1;
    }

    // 求下标为k的右孩子节点
    public static int rightChild(int k){
        return k * 2 + 2;
    }

    // 元素下沉
    public static void siftDown(int[] arr , int k){
        while(leftChild(k) < arr.length - 1){
            int i = leftChild(k);

            if(rightChild(k) < arr.length - 1 && arr[rightChild(k)] > arr[i]){
                i = rightChild(k);
            }
            if(arr[k] < arr[i]){
                // i 为当前节点的左孩子节点和右孩子节点的最大值
                swap(arr , i , k);
                k = i;
            }else{
                break;
            }
        }
    }


    // 元素上浮
    public static void siftUp(int[] arr , int k){
        while(k >= 0 && arr[k] > arr[parent(k)]){
            swap(arr , k , parent(k));
            k = parent(k);
        }
    }

    // 构建一个最大堆
    public static void heapify(int[] arr){
        //从最后一个节点的父亲节点到第一个节点，执行元素下沉的操作
        for(int i = parent(arr.length - 1) ; i >= 0 ; i --){
            // 元素下沉
            siftDown(arr , i);
        }
    }

    public static int remove(int[] arr){
        int ret = arr[0];
        swap(arr , 0 , arr.length - 1);
        arr[arr.length - 1] = 0;
        siftDown(arr , 0);
        return ret;
    }

    public static int[] heapSort(int[] arr){
        heapify(arr);
        int[] res = new int[arr.length];

        for (int i = 0; i < arr.length ; i ++){
            res[i] = remove(arr);
        }

        return res;
    }



    public static void main(String[] args) {
        int[] arr = {12 , 13 , 56 , 6 ,10 , 88 , 8};
        int[] ret = heapSort(arr);

        for(int ar : ret){
            System.out.print(ar + " ");
        }
    }


}
