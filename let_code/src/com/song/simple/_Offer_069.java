package com.song.simple;

public class _Offer_069 {

    public int peakIndexInMountainArray(int[] arr) {
        int len = arr.length;
        for (int i = 0; i < len - 1; i++) {
            if(arr[i] > arr[i + 1]){
                return i;
            }
        }
        return len - 1;
    }

    public int peakIndexInMountainArray1(int[] arr) {
        int len = arr.length;
        int left = 1;
        int right = len - 2;
        int ans = 0;
        while(left <= right){
            int mid = (left + right) / 2;
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
        _Offer_069 obj = new _Offer_069();
        int[] arr = {1,2,5,4,3,2,1};
        System.out.println(obj.peakIndexInMountainArray1(arr));

    }





}
