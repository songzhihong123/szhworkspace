package com.letcode.szh.sort;

import java.util.TreeMap;

/**
 * @ClassName Trie
 * @Description Trie 前缀树
 * @Author szh
 * @Date 2024年01月01日
 */
public class Trie {

    private class Node{

        // 表示是否是一个单词
        public boolean isWord;

        public TreeMap<Character , Node> data;

        public Node(boolean isWord){
            this.isWord = isWord;
            data = new TreeMap<>();
        }

        public Node(){
            this(false);
        }

    }

    private Node root;

    private int size;

    public Trie(){
        root = new Node();
    }

    public int getSize(){
        return size;
    }

    // 向Trie中添加一个单词
    public void add(String word){
        Node cur = root;

        for(int i = 0 ; i < word.length() ; i ++){
            char c = word.charAt(i);
            if(cur.data.get(c) == null){
                cur.data.put(c , new Node());
            }
            cur = cur.data.get(c);
        }
        if(!cur.isWord){
            cur.isWord = true;
            size ++;
        }
    }


    // 判断trie中是否包含word单词
    public boolean contains(String word){
        Node cur = root;

        for(int i = 0 ; i < word.length() ; i ++){
            char c = word.charAt(i);
            if(cur.data.get(c) == null){
                return false;
            }
            cur = cur.data.get(c);
        }
       return cur.isWord;
    }

    // 判断一个单词是不是Trie的前缀
    public boolean isPrefix(String prefix){
        Node cur = root;

        for(int i = 0 ; i < prefix.length() ; i ++){
            char c = prefix.charAt(i);
            if(cur.data.get(c) == null){
                return false;
            }
            cur = cur.data.get(c);
        }
        return true;
    }







}
