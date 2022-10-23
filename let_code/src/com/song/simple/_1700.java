package com.song.simple;

/**
 * @ClassName _1700
 * @Description TODO
 * @Author szh
 * @Date 2022年10月20日
 */
public class _1700 {


    public int countStudents(int[] students, int[] sandwiches) {
        int s1 = 0;
        for(int str : students){
            s1 += str;
        }
        int s0 = students.length - s1;

        for (int sand : sandwiches){
            if(sand == 1 && s1 > 0){
                s1 --;
            } else if (sand == 0 && s0 > 0) {
                s0 --;
            }else{
                break;
            }
        }
        return s0 + s1;
    }

    public static void main(String[] args){
        _1700 obj = new _1700();
        int[] students = {1,1,1,0,0,1};
        int[] sandwiches = {1,0,0,0,1,1};

        System.out.println(obj.countStudents(students , sandwiches));

    }



}
