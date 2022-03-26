package com.song.medium;

public class _275 {


    public int hIndex(int[] citations) {
        int n = citations.length;
        int left = 0;
        int right = n - 1;
        while(left <= right){
            int mid = left + (right - left)/2;
            if(citations[mid] >= n - mid){
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        return n - left;
    }

    public int hIndex1(int[] citations) {
        int h = 0;
        int i = citations.length - 1;
        while(i >= 0 && citations[i] > h){
            h ++;
            i --;
        }
        return h;
    }

    public static void main(String[] args){
        _275 obj = new _275();
        int[] citations = {3,0,6,1,5};
        System.out.println(obj.hIndex(citations));
    }



}
