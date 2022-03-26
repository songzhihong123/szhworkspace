package com.song;

import java.util.ArrayList;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        BST<Integer> bst = new BST<>();

        bst.add(10);
        bst.add(8);
        bst.add(12);
        bst.add(7);
        bst.add(9);
        bst.add(11);
        bst.add(13);
        ArrayList<Integer> nums = new ArrayList<>();
        while(!bst.isEmpty()){
            nums.add(bst.removeMin());
        }
        System.out.println(nums);
        /*for (int i = 1; i < nums.size(); i++) {
            if(nums.get(i-1) > nums.get(i)){
                throw new IllegalArgumentException("Error");
            }
        }
        System.out.println("removeMin test completed.");*/

        //test removeMax
        /*for (int i = 0; i < n; i++) {
            bst.add(random.nextInt(10000));
        }
        nums = new ArrayList<>();
        while(!bst.isEmpty()){
            nums.add(bst.removeMax());
        }
        System.out.println(nums);
        for (int i = 1; i < nums.size(); i++) {
            if(nums.get(i-1) < nums.get(i)){
                throw new IllegalArgumentException("Error");
            }
        }
        System.out.println("removeMax test completed.");*/

    }

}
