package com.letcode.szh.bilibili.middle;

/**
 * @ClassName MaxOneBorderSize
 * @Description MaxOneBorderSize 预处理数组
 * @Author szh
 * @Date 2024年01月11日
 */
public class MaxOneBorderSize {

    /*

    给定一个N*N的矩阵matrix ， 只有0和1两种值，返回边框全是1的最大正方形的边长长度

    例子
    0 1 1 1 1
    0 1 0 0 1
    0 1 0 0 1
    0 1 1 1 1
    0 1 0 1 1

    其中边框全是1的最大正方形的大小为4 * 4 , 所以返回1


    思路：需要枚举这个矩阵里面所有的正方形是不是边全为1

     确定一个点，确定边长，就可以枚举所有正方形

     */


    public static int maxAllOneBorder(int[][] m){

        int N = m.length;
        int M = m[0].length;

        //right 用来记录算上自己右边有多少个连续的1
        // 例如例子中的 right[4][4] = 1  right[4][3] = 2  right[4][2] = 0
        int[][] right = new int[N][M];

        //down 用来记录算上自己下边有多少个连续的1
        // 例如例子中的 right[4][4] = 1  right[3][4] = 2  right[2][4] = 3
        int[][] down = new int[N][M];


        // 填充right数组
        for(int row = N - 1 ; row >= 0 ; row--){
            for(int col = M - 1 ; col >= 0 ; col --){
                if(col == M - 1){
                    right[row][col] = m[row][col];
                }else{
                    right[row][col] = m[row][col] == 0 ? 0 : right[row][col + 1] + 1;
                }
            }
        }

        // 填充down数组
        for(int col = M - 1 ; col >= 0 ; col --){
            for(int row = N - 1 ; row >= 0 ; row--){
                if(row == N - 1){
                    down[row][col] = m[row][col];
                }else{
                    down[row][col] = m[row][col] == 0 ? 0 : down[row + 1][col] + 1;
                }
            }
        }

        int res = Integer.MIN_VALUE;


        for(int row = 0 ; row < N ; row ++){ // 所有行
            for(int col = 0 ; col < M ; col ++) { // 所有列
                // 上面两个for循环可以确定一个点
                for(int border = 1 ; border <= Math.min(N - row, M - col) ; border ++){ // 枚举所有边
                  // 上面三个for循环可以确定一个正方形

                   // 需要验证这个正方形的边是不是全是1
                   // 普通方法 需要 4个 for循环依次遍历
                   // 优化： 使用预处理矩阵 right 和 down
                    // 例如当前点是（5 ， 4） bolder 是 3
                    if(right[row][col] >= border && down[row][col] >= border
                            && right[row + border - 1][col] >= border && down[row][col + border - 1] >= border){
                        // 认为border 有效
                        res = Math.max(res , border);
                    }
                }
            }

        }

        return res == Integer.MIN_VALUE ? -1 : res;
    }


    public static void main(String[] args) {

        int[][] m = new int[][]{
                {1 , 0 , 1 , 1 , 1},
                {1 , 0 , 1 , 0 , 1},
                {1 , 1 , 1 , 1 , 1},
                {1 , 0 , 1 , 0 , 0},
        };

        System.out.println(maxAllOneBorder(m));


    }










}
