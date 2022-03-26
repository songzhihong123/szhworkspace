package com.song;

import java.util.ArrayList;
import java.util.Collections;

public class Main {

    public static void main(String[] args) {
        System.out.println("pride-and-prejudice.txt");
        ArrayList<String> words = new ArrayList<>();
        if(FileOperation.readFile("pride-and-prejudice.txt",words)) {
            System.out.println("Total words: " + words.size());

//            Collections.sort(words);

            long startTime = System.nanoTime();
            //Test BST
            BST<String, Integer> map = new BST<String, Integer>();
            for (String word : words) {
                if (map.contains(word)) {
                    map.set(word, map.get(word) + 1);
                } else {
                    map.add(word, 1);
                }
            }
            for (String word : words) {
                map.contains(word);
            }

            long endTime = System.nanoTime();

            double time = (endTime - startTime) / 1000000000.0;

            System.out.println("BST: " + time + " s");

            startTime = System.nanoTime();
            //Test AVL
            AVLTree<String, Integer> avl = new AVLTree<String, Integer>();
            for (String word : words) {
                if (avl.contains(word)) {
                    avl.set(word, avl.get(word) + 1);
                } else {
                    avl.add(word, 1);
                }
            }
            for (String word : words) {
                avl.contains(word);
            }

            endTime = System.nanoTime();

            time = (endTime - startTime) / 1000000000.0;

            System.out.println("AVL: " + time + " s");

            startTime = System.nanoTime();
            //Test RBT
            RBTree<String, Integer> retree = new RBTree<String, Integer>();
            for (String word : words) {
                if (retree.contains(word)) {
                    retree.set(word, retree.get(word) + 1);
                } else {
                    retree.add(word, 1);
                }
            }
            for (String word : words) {
                retree.contains(word);
            }

            endTime = System.nanoTime();

            time = (endTime - startTime) / 1000000000.0;

            System.out.println("RBT: " + time + " s");

        }
    }
}
