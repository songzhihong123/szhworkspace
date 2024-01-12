package com.letcode.szh.bilibili.middle;

/**
 * @ClassName ColorLeftRight
 * @Description ColorLeftRight , 预处理数组
 * @Author szh
 * @Date 2024年01月11日
 */
public class ColorLeftRight {


    /*
    给定一个字符串，字符串是由G和R组成的数组，
    需要给G染成R ， 或者把R染成G ， 要求是 R的左边全是G

    求最少的染几次？


    思路：
    1、分成两部分 0 和 n-1 , 让左边上全是G ， 右边全是R
    2、分成两部分 0..1 和 2..n-1 , 让左边上全是G ， 右边全是R
    3、分成两部分 0..2 和 3..n-1 , 让左边上全是G ， 右边全是R
    4、以此类推，求最小值

    优化：
        1、增加预处理数组，去掉遍历行为

     */


    public static int minPaint1(String s){
        char[] str = s.toCharArray();

        int res = Integer.MAX_VALUE;
        int N = str.length;
        for(int L = -1 ; L <= N ; L ++){
            int count = 0 ;
            if(L == -1) { // 统计全数组中R的个数
                for(int i = 0 ; i < N ; i ++){
                    if(str[i] == 'G'){
                        count ++;
                    }
                }
                res = Math.min(res , count);
            }else if(L == N){ // 统计全数组中G的个数
                for(int i = 0 ; i < N ; i ++){
                    if(str[i] == 'R'){
                        count ++;
                    }
                }
                res = Math.min(res , count);
            }else{
                // 统计 str[0..L] 上 R 的个数【染成G】 ， 和 str[L + 1..N-1] 上G的个数[染成R]
                for(int i = 0 ; i <= L ; i ++){
                    if(str[i] == 'R'){
                        count ++;
                    }
                }
                for(int i = L + 1 ; i <= N - 1 ; i ++){
                    if(str[i] == 'G'){
                        count ++;
                    }
                }
                res = Math.min(res , count);
            }
        }
        return res;
    }



    // 预加载一个数组， 去掉遍历
    // 预加载只需要一个数组
    public static int minPaint2(String s){
        char[] str = s.toCharArray();
        int N = str.length;
        // 统计0..i 上R的个数
        int[] rCount = new int[N];
        // 统计i..N-1 上G 的个数
        int[] gCount = new int[N];

        int rc = 0;
        for(int i = 0 ; i < N ; i ++){
            rCount[i] = str[i] == 'R' ? ++rc : rc;
        }

        int gc = 0;
        for(int i = N - 1 ; i >= 0 ; i --){
            gCount[i] = str[i] == 'G' ? ++gc : gc;
        }

        int res = Integer.MAX_VALUE;

        for(int L = -1 ; L <= N ; L ++){
            int count = 0 ;
            if(L == -1) { // 统计全数组中R的个数
                count = rCount[N - 1];
                res = Math.min(res , count);
            }else if(L == N){ // 统计全数组中G的个数
                count = gCount[0];
                res = Math.min(res , count);
            }else{
                // 统计 str[0..L] 上 R 的个数【染成G】 ， 和 str[L + 1..N-1] 上G的个数[染成R]
                count += rCount[L];
                count += (L + 1) >= N ? 0 : gCount[L + 1];
                res = Math.min(res , count);
            }
        }
        return res;
    }


    public static void main(String[] args) {

        String s = "GRRGRG";

        System.out.println(minPaint1(s));
        System.out.println(minPaint2(s));


    }







}
