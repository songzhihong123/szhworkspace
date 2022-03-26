package com.song;

import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        /*System.out.println("Pride and Prejudice");
        ArrayList<String> words = new ArrayList<>();
        if (FileOperation.readFile("pride-and-prejudice.txt", words)) {

            Collections.sort(words);
            //Test BST
            long startTime = System.nanoTime();
            BST<String,Integer> bst = new BST<>();
            for (String word: words) {
                if(bst.contains(word)){
                    bst.set(word,bst.get(word)+1);
                }else{
                    bst.add(word,1);
                }
            }
            for(String word : words)
                bst.contains(word);
            long endTime = System.nanoTime();
            double time = (endTime - startTime) / 1000000000.0;
            System.out.println("BST: "+time + " s");

            //Test AVL Tree
            startTime = System.nanoTime();
            AVLTree<String,Integer> avl = new AVLTree<>();
            for (String word: words) {
                if(avl.contains(word)){
                    avl.set(word,avl.get(word)+1);
                }else{
                    avl.add(word,1);
                }
            }
            for(String word : words)
                avl.contains(word);
            endTime = System.nanoTime();
            time = (endTime - startTime) / 1000000000.0;
            System.out.println("AVL: "+time + " s");


        }*/
        List<Map<String,String>> resultList = new ArrayList<>();
        Random random = new Random();
//        for (int i = 0; i < 10; i++) {
//            Map<String,String> map = new HashMap<>();
//            map.put("user","11");
//            map.put("age",String.valueOf(random.nextInt(100)));
//            resultList.add(map);
//        }
        Map<String,String> map = new HashMap<>();
        map.put("user","11");
        map.put("age","20");
        resultList.add(map);
        Map<String,String> map1 = new HashMap<>();
        map1.put("user","11");
        map1.put("age","20");
        resultList.add(map1);

       /* Double user = resultList.stream().map(m -> m.remove("user")).collect(Collectors.summingDouble(Double::valueOf));
        System.out.println(user);*/
        //System.out.println(resultList.stream().map(m -> m.get("age")).collect(Collectors.summingDouble(Double::valueOf)));
//        System.out.println(resultList.stream().map(m -> Double.parseDouble(m.get("age"))).reduce(0.0,Double::sum));
        System.out.println(resultList.stream().map(m -> m.get("age") + m.get("user")).distinct().collect(Collectors.toList()));


//        System.out.println(resultList.stream().collect(Collectors.groupingBy(m -> m.get("age") + m.get("user"),Collectors.toList())));
        System.out.println(resultList);

    }






}
