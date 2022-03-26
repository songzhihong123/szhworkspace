package com.song.medium;

import java.util.TreeMap;

/**
 * Created by Zhihong Song on 2021/4/14 8:53
 */

public class _208 {

    public class Trie{

        private class Node{
            boolean isWord;
            TreeMap<Character,Node> next;
            public Node(boolean isWord){
                this.isWord = isWord;
                next = new TreeMap<>();
            }
            public Node(){
                this(false);
            }
        }

        private Node root;
        private int size;

        /** Initialize your data structure here. */
        public Trie() {
            root = new Node();
            size = 0;
        }

        public int getSize(){
            return size;
        }

        /** Inserts a word into the trie. */
        public void insert(String word) {
            Node cur = root;
            int len = word.length();
            for (int i = 0; i < len; i++) {
                char c = word.charAt(i);
                if(cur.next.get(c) == null){
                    cur.next.put(c , new Node());
                }
                cur = cur.next.get(c);
            }
            if(!cur.isWord){
                cur.isWord = true;
                size ++;
            }
        }


        public void insertDG(String word){
            insertDG(root , word , 0);
        }

        private void insertDG(Node node , String word , int index){
            if(index == word.length()){
                if (!node.isWord){
                    node.isWord = true;
                    size++;
                }
                return;
            }
            char c = word.charAt(index);
            if(node.next.get(c) == null){
                node.next.put(c,new Node());
            }
            insertDG(node.next.get(c) , word , index + 1);
        }


        /** Returns if the word is in the trie. */
        public boolean search(String word) {
            Node cur = root;
            int len = word.length();
            for (int i = 0; i < len; i++) {
                char c = word.charAt(i);
                if(cur.next.get(c) == null){
                    return false;
                }
                cur = cur.next.get(c);
            }
            return cur.isWord;
        }

        public boolean searchDG(String word){
            return searchDG(root , word , 0);
        }

        private boolean searchDG(Node node , String word , int index){
            if(index == word.length()){
                return node.isWord;
            }
            char c = word.charAt(index);
            if(node.next.get(c) == null){
                return false;
            }
            return searchDG(node.next.get(c) , word , index + 1);
        }

        /** Returns if there is any word in the trie that starts with the given prefix. */
        public boolean startsWith(String prefix) {
            Node cur = root;
            int len = prefix.length();
            for (int i = 0; i < len; i++) {
                char c = prefix.charAt(i);
                if(cur.next.get(c) == null){
                    return false;
                }
                cur = cur.next.get(c);
            }
            return true;
        }
    }



}
