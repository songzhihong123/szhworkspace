package com.song.simple;

/**
 * @description:
 * @author: szh
 * @create: 2021-05-31 13:31
 **/
public class _342 {

    //给定一个整数，写一个函数来判断它是否是 4 的幂次方

    public boolean isPowerOfFour(int n) {
        if (n == 0){
            return false;
        }
        int _log = (int)(Math.log(n) / Math.log(4));
        int _n = (int)Math.pow(4,_log);
        return _n == n;
    }


    //    如果 n 是 4 的幂，那么它可以表示成 4^x 的形式，我们可以发现它除以 3 的余数一定为 1，即：
    //
    //            4^x = (3 + 1)^x = 1 (mod3)
    //
    //    如果 n 是 2 的幂却不是 4 的幂，那么它可以表示成 4^x * 2 的形式，此时它除以 3 的余数一定为 2。
    //
    //    因此我们可以通过 n 除以 3 的余数是否为 1 来判断 n 是否是 4 的幂。
    //
    public boolean isPowerOfFour1(int n) {
        return n > 0 & (n & (n - 1)) == 0 & n % 3 == 1;
    }

    /**
     *
     * 如果 n 是 4 的幂，那么 n 的二进制表示中有且仅有一个 1，
     * 并且这个 1 出现在从低位开始的第偶数个二进制位上（这是因为这个 1 后面必须有偶数个0）。这里我们规定最低位为第 0 位，例如 n=16 时，n 的二进制表示为
     *
     * (10000)2
     *
     * 唯一的 1 出现在第 4 个二进制位上，因此 n 是 4 的幂。
     *
     * 由于题目保证了 n 是一个 32 位的有符号整数，因此我们可以构造一个整数 mask，
     * 它的所有偶数二进制位都是 0，所有奇数二进制位都是 1。这样一来，我们将 n 和 mask 进行按位与运算，如果结果为 0，说明 n 二进制表示中的 1 出现在偶数的位置，否则说明其出现在奇数的位置。
     *
     * 根据上面的思路，mask 的二进制表示为：
     *
     * mask=(10101010101010101010101010101010)2
     *
     * 我们也可以将其表示成 16 进制的形式，使其更加美观：
     *
     * mask=(AAAAAAAA)16
     *
     *
      **/
    public boolean isPowerOfFour2(int n) {
        return n > 0 & (n & (n - 1)) == 0 && (n & 0xaaaaaaaa) == 0;
    }



    public static void main(String[] args){
        _342 obj = new _342();
        int n = 64;
        System.out.println(obj.isPowerOfFour2(n));
    }


}
