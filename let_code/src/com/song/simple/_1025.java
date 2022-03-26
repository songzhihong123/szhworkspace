package com.song.simple;

/**
 * Created by Zhihong Song on 2021/1/11 21:13
 */

public class _1025 {

    /**
     * 爱丽丝和鲍勃一起玩游戏，他们轮流行动。爱丽丝先手开局。
     *
     * 最初，黑板上有一个数字 N 。在每个玩家的回合，玩家需要执行以下操作：
     *
     *     选出任一 x，满足 0 < x < N 且 N % x == 0 。
     *     用 N - x 替换黑板上的数字 N 。
     *
     * 如果玩家无法执行这些操作，就会输掉游戏。
     *
     * 只有在爱丽丝在游戏中取得胜利时才返回 True，否则返回 False。假设两个玩家都以最佳状态参与游戏。
     */

    public boolean divisorGame1(int N) {
       boolean[] dp = new boolean[N + 1];
       dp[1] = false;
       dp[2] = true;
       for(int i = 3 ; i <= N ; i++){
           for (int j = 1 ; j < i ; j++){
               if(i % j == 0 && !dp[i - j]){
                   dp[i] = true;
                   break;
               }
           }
       }
       return dp[N];

    }

    public boolean divisorGame2(int N) {
        if (N == 1) {
            return false;
        }
        // 使用包装类型的布尔数组是利用了包装类型的一个特殊的状态 null，表示当前状态还没计算出来
        Boolean[] memo = new Boolean[N + 1];
        return dfs(N, memo);
    }

    private boolean dfs(int n, Boolean[] memo) {
        if (n == 1) {
            return false;
        }
        if (n == 2) {
            return true;
        }

        if (memo[n] != null) {
            return memo[n];
        }

        boolean canWin = false;
        // n / 2 是下取整，所以可以取等号
        for (int i = 1; i <= n / 2; i++) {
            if (n % i == 0 && !dfs(n - i, memo)) {
                // 当前先手，如果对手的下一个状态值有 false，就说明我们可以赢
                canWin = true;
                // 由于假设两边都足够聪明，因此我们赢了以后，就可以退出循环了
                break;
            }
        }
        memo[n] = canWin;
        return canWin;
    }



    public static void main(String[] args) {

    }

}
