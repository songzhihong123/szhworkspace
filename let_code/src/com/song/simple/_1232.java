package com.song.simple;

/**
 * Created by Zhihong Song on 2021/1/17 20:36
 */

public class _1232 {

    /**
     *在一个 XY 坐标系中有一些点，我们用数组 coordinates 来分别记录它们的坐标，
     *
     * 其中 coordinates[i] = [x, y] 表示横坐标为 x、纵坐标为 y 的点。
     *
     */


    public boolean checkStraightLine(int[][] coordinates) {

        for (int i = 1; i + 1 < coordinates.length; i++) {
            if((coordinates[i][0] - coordinates[i - 1][0]) * (coordinates[i + 1][1] - coordinates[i][1]) !=
                    (coordinates[i + 1][0] - coordinates[i][0]) * (coordinates[i][1] - coordinates[i - 1][1])){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {

        int[][] coordinates = {{1,1},{2,3}};
        _1232 obj = new _1232();
        System.out.println(obj.checkStraightLine(coordinates));

    }





}
