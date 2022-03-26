package com.mmall.concurrent.example.syncContainer;

import com.mmall.concurrent.annoation.NotThreadSafe;

import java.util.Iterator;
import java.util.Vector;


public class VectorExample3 {
    /**
     *使用foreach和iteraor的过程当中最好不要进行删除或者更新操作，如果非要删除
     * 那就在遍历的过程当中做好标记，在遍历之后在进行相关的删除操作
     */

    //java.util.ConcurrentModificationException
    private static void test1(Vector<Integer> v){ //foreach
        for(Integer i : v){
            if(i.equals(3)){
                v.remove(i);
            }
        }
    }

    //java.util.ConcurrentModificationException
    private static void test2(Vector<Integer> v){ //iterator
        Iterator<Integer> iterator = v.iterator();
        while(iterator.hasNext()){
            Integer i = iterator.next();
            if(i.equals(3)){
                v.remove(i);
            }
        }
    }

    //success
    private static void test3(Vector<Integer> v){ // 正常for
        for(int i = 0;i<v.size();i++){
            if(v.get(i).equals(3)){
                v.remove(i);
            }
        }
    }

    public static void main(String[] args) {
        Vector<Integer> vector = new Vector<>();
        vector.add(1);
        vector.add(2);
        vector.add(3);
        test3(vector);
    }
}
