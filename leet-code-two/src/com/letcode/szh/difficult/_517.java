package com.letcode.szh.difficult;

/**
 * @ClassName _517
 * @Description _517
 * @Author szh
 * @Date 2024年01月11日
 */
public class _517 {



    public int findMinMoves(int[] machines){
        if(machines == null || machines.length == 0){
            return 0;
        }

        int size = machines.length;
        int sum = 0;
        for(int i = 0 ; i < size ; i++){
            sum += machines[i];
        }

        if(sum % size != 0){
            return -1;
        }

        int avg = sum / size;
        int leftSum = 0; // 左侧一共需要的数量
        int ans = 0;

        for(int i = 0 ; i < machines.length ; i++){
            // 负数， 需要输入，  正数， 需要输出
            int leftRest = leftSum - i * avg;
            // 负数， 需要输入，  正数， 需要输出
            int rightRest = (sum - leftSum - machines[i]) - (size - i - 1) * avg;

            // 左右两边都是负数 ， 中间位置需要扔出去衣服 左侧的绝对值 + 右侧的绝对值
            if(leftRest < 0 && rightRest < 0){
                ans = Math.max(ans , Math.abs(leftRest) + Math.abs(rightRest));
            }else{
                ans = Math.max(ans , Math.max(Math.abs(leftRest) , Math.abs(rightRest)));
            }
            leftSum += machines[i];

        }

        return ans;
    }



}
