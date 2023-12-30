package com.imooc.datastructure1.bst;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @ClassName Main
 * @Description TODO
 * @Author szh
 * @Date 2023年09月10日
 */
public class Main {

    public static void main(String[] args) {

        BST<Integer> bst = new BST<>();
//        int[] nums = {5, 3, 6, 8, 4, 2};
//        for (int num : nums) {
//            bst.add(num);
//        }

//        bst.preOrder();

//        System.out.println();

//        bst.perOrderNR();

//        System.out.println(bst);

//        bst.inOrder();
//
//        System.out.println();
//
//        bst.postOrder();


        Random random = new Random();
        int n = 1000;
        for(int i = 0 ; i < n ; i ++){
            bst.add(random.nextInt(10000));
        }

        List<Integer> list = new ArrayList<>();
        while(!bst.isEmpty()){
            list.add(bst.removeMin());
        }

        System.out.println(list);


        for(int i = 1 ;i < list.size() ; i++){
            if(list.get(i - 1) > list.get(i)){
                throw new IllegalArgumentException("Error");
            }
        }




    }


}
