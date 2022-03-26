package com.song;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main3 {

    public static void main(String[] args) {
        int n = 20000000;
        Random random  = new Random();
        List<Integer> testData = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            testData.add(i);
        }

        //Test BST
//        long startTime = System.nanoTime();
//        BST<Integer,Integer> bst = new BST<>();
//        for (Integer x: testData) {
//            bst.add(x,null);
//        }
//        long endTime = System.nanoTime();
//        double time = (endTime - startTime) / 1000000000.0;
//        System.out.println("BST: "+time + " s");


        //Test AVL
        long startTime = System.nanoTime();
        AVLTree<Integer,Integer> avl = new AVLTree<>();
        for (Integer x: testData) {
            avl.add(x,null);
        }
        long endTime = System.nanoTime();
        double time1 = (endTime - startTime) / 1000000000.0;
        System.out.println("AVL: "+time1 + " s");


        startTime = System.nanoTime();
        RBTree<Integer,Integer> rbt = new RBTree<>();
        for (Integer x: testData) {
            rbt.add(x,null);
        }
        endTime = System.nanoTime();
        double time2 = (endTime - startTime) / 1000000000.0;
        System.out.println("RBT : "+time2 + " s");



    }

}
