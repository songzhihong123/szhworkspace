package test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Zhihong Song on 2021/1/30 15:31
 */

public class Test1 {

    //   给一个无序的整数数组，找出所有两两相加和为 100  的元素对下标。例如数组 [10, 30, 90, 70] 得到的下标为：[[0,2], [1,3]]


    public List<Integer> find(int[] target) {
        int len = target.length;
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                if(target[i] + target[j] == 100){
                    result.add(i);
                    result.add(j);
                }
            }
        }
        return result;
    }


    public static void main(String[] args) {
        Test1 obj = new Test1();
        int[] target = {10, 30, 90, 70};
        obj.find(target).stream().forEach(System.out::print);

    }


}

