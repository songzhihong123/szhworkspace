package com.song.simple.day8;

import java.util.LinkedList;
import java.util.Queue;

public class _116 {

    public Node connect(Node root) {
        if(root == null){
            return null;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node poll = queue.poll();
                if (i < size - 1){
                    poll.next = queue.peek();
                }
                if(poll.left != null){
                    queue.offer(poll.left);
                    queue.offer(poll.right);
                }
            }

        }
        return root;
    }

    public Node connect1(Node root) {
        if(root == null){
            return root;
        }
        Node leftmost = root;

        while(leftmost.left != null){

            Node head = leftmost;

            while(head != null){
                head.left.next = head.right;

                if(head.next != null){
                    head.right.next = head.next.left;
                }

                head = head.next;

            }
            leftmost = leftmost.left;

        }

        return root;
    }



    public static void main(String[] args){



    }

}
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }
    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
}
