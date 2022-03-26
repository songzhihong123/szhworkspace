package com.song.simple;

public class _167 {


    public int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;

        while(left < right){
            if(numbers[left] + numbers[right] > target){
                right --;
            }else if(numbers[left] + numbers[right] < target){
                left ++;
            }else{
                return new int[]{left + 1 , right + 1};
            }

        }
        return new int[]{};
    }





    public static void main(String[] args){
        _167 obj  = new _167();
        int[] numbers = {-1 , 0};
        int target = 6;
        int[] ints = obj.twoSum(numbers, target);

        for(int i : ints){
            System.out.printf(i + " ");
        }


    }




}
