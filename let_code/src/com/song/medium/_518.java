package com.song.medium;

/**
 * @description:
 * @author: szh
 * @create: 2021-06-10 10:46
 **/
public class _518 {


    /**
     * 对于面额为 coin 的硬币，当 coin ≤ i ≤ amount时，
     * 如果存在一种硬币组合的金额之和等于 i − coin，则在该硬币组合中增加一个面额为 coin 的硬币，即可得到一种金额之和等于 i 的硬币组合.
     *
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/coin-change-2/solution/ling-qian-dui-huan-ii-by-leetcode-soluti-f7uh/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     **/


    public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int coin : coins) {
            for (int i =coin; i <= amount; i++) {
                dp[i] += dp[i - coin];
            }
        }
        return dp[amount];
    }

    public static void main(String[] args){
        _518 obj = new _518();
        int amount = 5;
        int[] coins = {2, 1, 5};
        System.out.println(obj.change(amount, coins));
    }


}
