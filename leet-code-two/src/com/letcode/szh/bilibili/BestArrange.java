package com.letcode.szh.bilibili;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @ClassName BestArrange
 * @Description 贪心算法求最优解
 * @Author szh
 * @Date 2024年01月05日
 */
public class BestArrange {

    public static class Program{
        // 项目开始时间
        public int start;
        // 项目结束时间
        public int end;

        public Program(int start , int end){
            this.start = start;
            this.end = end;
        }
    }

    public static class ProgramComparator implements Comparator<Program>{
        @Override
        public int compare(Program o1, Program o2) {
            return o1.end - o2.end;
        }
    }

    // 给一个项目列表， 每个项目有开始时间和结束时间
    // 给一个项目开始时间点
    // 同一时间只能有一个项目在进行，求最多安排多少个项目？
    // 贪心算法求最优解
    public static int bestArrange(Program[] programs , int timePoint){
        // 按项目的结束时间排序
        Arrays.sort(programs , new ProgramComparator());
        int result = 0;

        for(int i = 0 ; i < programs.length ; i ++){
            if(programs[i].start >= timePoint){
                result ++;
                timePoint = programs[i].end;
            }
        }




        return result;
    }






}
