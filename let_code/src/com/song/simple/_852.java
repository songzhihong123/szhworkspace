package com.song.simple;

/**
 * @description:
 * @author: szh
 * @create: 2021-06-15 09:03
 **/
public class _852 {

    public int peakIndexInMountainArray(int[] arr) {
        int len = arr.length;
        int result = 0;
        for (int i = 1; i < len; i++) {
            if(arr[i] > arr[i - 1]){
                result = i;
            }
        }
        return result;
    }

    public int peakIndexInMountainArray1(int[] arr) {
        int len = arr.length;
        for (int i = 1; i < len; i++) {
            if(arr[i] < arr[i - 1]){
               return i - 1;
            }
        }
        return -1;
    }

    // 二分法
    public int peakIndexInMountainArray2(int[] arr) {
        int len = arr.length;
        int left = 1;
        int right = len - 2;
        int ans = 0;
        while(left <= right){
            int mid = (right + left) / 2;
            if(arr[mid] > arr[mid + 1]){
                ans = mid;
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        return ans;
    }



    public static void main(String[] args){
        _852 obj = new _852();
        int[] arr = {0,2,1,0};
        System.out.println(obj.peakIndexInMountainArray2(arr));
    }



}
