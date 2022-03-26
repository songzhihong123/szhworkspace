package com.imooc.datastructure.myself;

public class Main {


    private class Node{

        public Integer e;
        public Node next;

        public Node(Integer e , Node next){
            this.e = e;
            this.next = next;
        }

        public Node(Integer e){
            this(e , null);
        }

        public Node(){
            this(null, null);
        }

        @Override
        public String toString(){
            return e.toString();
        }

    }

    // 翻转列表
    public Node reverse(Node head){
        if(head == null || head.next == null){
            return head;
        }

        Node newHead = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }

    public Node foreachReverse(Node head){

        Node cur = head.next;
        Node pre = head;

        while(cur != null){
            Node temp = cur.next;
            cur.next = pre;


            pre = cur;
            cur = temp;

        }
        head.next = null;
        return pre;
    }


    public Node generHead(){
        Node head = new Node(1);
        Node node1 = new Node(2);
        Node node2 = new Node(3);
        Node node3 = new Node(4);

        head.next = node1;
        node1.next = node2;
        node2.next = node3;

        return head;
    }


    public static void main(String[] args){
        Main obj = new Main();
        Node head = obj.generHead();

//        while(head!=null){
//            System.out.println(head);
//            head = head.next;
//        }

        System.out.println();

//        Node reNode = obj.reverse(head);

        Node reNode = obj.foreachReverse(head);

        while(reNode!=null){
            System.out.println(reNode);
            reNode = reNode.next;
        }


    }






}
