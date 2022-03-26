package com.song;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        System.out.println("Pride and Prejudice");
        ArrayList<String> words = new ArrayList<>();
        if(FileOperation.readFile("pride-and-prejudice.txt",words)){
            long startTime = System.nanoTime();
            BSTSet<String> bst = new BSTSet<>();
            for(String word:words)
                bst.add(word);
            for(String word:words)
                bst.contains(word);
            long endTime = System.nanoTime();
            double time = (endTime - startTime) / 1000000000.0;
            System.out.println("Total different words: "+bst.getSize());
            System.out.println("BSTSet : " + time + " s");


            startTime = System.nanoTime();
            Trie trie = new Trie();
            for(String word:words)
                trie.add(word);
            for(String word:words)
                trie.contains(word);
            endTime = System.nanoTime();
            time = (endTime - startTime) / 1000000000.0;
            System.out.println("Total different words: "+trie.getSize());
            System.out.println("Trie : " + time + " s");

        }

    }
}
