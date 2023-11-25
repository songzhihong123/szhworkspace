package com.letcode.szh.simple;

/**
 * @ClassName _495
 * @Description _495
 * @Author szh
 * @Date 2023年11月16日
 */
public class _495 {


    public int findPoisonedDuration(int[] timeSeries, int duration) {

//        int[] timeSeries = {1,2};
//        int duration = 2;

        // 总体思路： 从第二个值开始遍历， 比较与前一个值的差值，
        // 差值 >= duration ,表示两个值中间有 duration 时间在中毒， 现在是无毒状态 ， 中毒时间是duration
        // 差值 < duration ， 表示两个值中间一直在中毒，现在还在中毒状态，中毒时间是差值
        // 遍历到最后一个值时候算出来最后一个值和前一个值的中毒时间，最后一个值仍然要中毒 duration 的时间长度


        int length = timeSeries.length;

        int res = 0;

        if(length == 0){
            return res;
        }

        for(int i = 1 ; i < length ; i ++){

            if(timeSeries[i] - timeSeries[i - 1] >= duration){
                // 当前时间和前一个时间的差值在中毒时间范围内
                res += duration;
            }else{
                // 当前时间和前一个时间的差值不在中毒时间范围内
                res += (timeSeries[i] - timeSeries[i - 1]);
            }
        }

        return res + duration;
    }


    public int findPoisonedDurationV1(int[] timeSeries, int duration) {


        // 总体思路： 记录中毒的结束时间expired ， 判断当前时间是否在中毒时间范围内
        // 当前位置不在中毒时间范围内，将来的中毒结束时间为 timeSeries[i] + duration , 当前位置将要中毒的时间为 duration
        // 当前位置在中毒的时间范围内，将来中毒的结束时间为 timeSeries[i] + duration ， 当前位置将要中毒的时间为 （timeSeries[i] + duration）- expired

        // 中毒的总时间
        int res = 0;
        // 中毒的结束时间
        int expired = 0;
        for(int i = 0 ; i < timeSeries.length ; i ++){
            // 当前时间不在中毒时间范围内
            if(timeSeries[i] >= expired){
                res += duration;
            }else{ // 当前时间在中毒的时间范围内
                res += timeSeries[i] + duration - expired;
            }
            expired = timeSeries[i] + duration;
        }
        return res;
    }





    public static void main(String[] args) {
        _495 obj = new _495();
//        int[] timeSeries = {1,3,5,7,9,11,13,15};
        int[] timeSeries = {1,2};
        int duration = 2;
        System.out.println(obj.findPoisonedDurationV1(timeSeries , duration));
    }


}
