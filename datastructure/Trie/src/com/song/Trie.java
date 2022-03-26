package com.song;

import java.util.Stack;
import java.util.TreeMap;

/**
 * Trie，专门处理字符串，然后判断是否是一个单词。
 */
public class Trie {

    private class Node{
        public boolean isWord;
        public TreeMap<Character,Node> next;

        public Node(boolean isWord){
            this.isWord = isWord;
            next = new TreeMap<Character, Node>();
        }
        public Node(){
            this(false);
        }

    }

    private Node root;
    private int size;

    public Trie(){
        root = new Node();
        size = 0;
    }

    //获得Trie中存储的单词数量
    public int getSize(){
        return size;
    }

    //向Trie中添加一个新的单词
    public void add(String word){
        Node cur = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if(cur.next.get(c) == null){
                cur.next.put(c,new Node());
            }
            cur = cur.next.get(c);
        }
        if(!cur.isWord){
            cur.isWord = true;
            size ++;
        }

    }

    //向Trie中添加一个新的单词，递归实现
    public void addDG(String word){
        addDG(root,word,0);
    }

    private void addDG(Node node,String word,int index){
        if(index == word.length()){
            if(!node.isWord){
                node.isWord = true;
                size++;
            }
            return;
        }
        char c = word.charAt(index);
        if(node.next.get(c) == null){
            node.next.put(c,new Node());
        }
        addDG(node.next.get(c),word,index+ 1);
    }

    //查询单词word是否在Trie中
    public boolean contains(String word){
        Node cur = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if(cur.next.get(c) == null)
                return false;
            cur = cur.next.get(c);
        }
        return cur.isWord;
    }

    public boolean containsDG(String word){
        return containsDG(root,word,0);
    }

    private boolean containsDG(Node node , String word , int index){
        if(index == word.length()){
            return node.isWord;
        }
        char c = word.charAt(index);
        if(node.next.get(c) == null)
            return false;
        return containsDG(node.next.get(c),word,index+1);
    }

    //查询是否在trie中有单词以prefix为前缀
    public boolean isPrefix(String prefix){
        Node cur = root;
        for (int i = 0; i < prefix.length(); i++) {
            char c  = prefix.charAt(i);
            if(cur.next.get(c) == null){
                return false;
            }
            cur = cur.next.get(c);
        }
        return true;
    }

    public boolean isPerfixDG(String prefix){
        return isPerfixDG(root,prefix,0);
    }

    private boolean isPerfixDG(Node node, String prefix , int index){
        if(prefix.length() == index){
            return true;
        }

        char c = prefix.charAt(index);
        if(node.next.get(c) == null){
            return false;
        }
        return isPerfixDG(node.next.get(c),prefix,index + 1);
    }

    //删除word，返回是否删除成功
    public boolean remove(String word){
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        for (int i = 0; i < word.length(); i++) {
            if(!stack.peek().next.containsKey(word.charAt(i)))
                return false;
            stack.push(stack.peek().next.get(word.charAt(i)));
        }
        if(!stack.peek().isWord){
            return false;
        }
        //将该单词结尾isWord置空
        stack.peek().isWord = false;
        size --;

        if (stack.peek().next.size()>0)
                return true;
        else
            stack .pop();
        for (int i = word.length() - 1; i >= 0 ; i--) {
            stack.peek().next.remove(word.charAt(i));
            if(stack.peek().isWord || stack.peek().next.size() > 0){
                return true;
            }
            stack.pop();
        }
        return true;
    }

    //删除word，返回是否删除成功, 递归算法
    public boolean removeDG(String word){
        if ("".equals(word))
            return false;
        return removeDG(root,word,0);
    }

    private boolean removeDG(Node node , String word , int index){
        if(word.length() == index){
            if(!node.isWord){
                return false;
            }
            node.isWord = false;
            size -- ;
            return true;
        }
        char c = word.charAt(index);
        if (!node.next.containsKey(c))
            return false;
        boolean ret = removeDG(node.next.get(c),word,index + 1);
        Node nextNode = node.next.get(c);
        if (!nextNode.isWord && nextNode.next.size() == 0)
                node.next.remove(word.charAt(index));
        return ret;
    }


}
