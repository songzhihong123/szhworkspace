package com.letcode.szh.bilibili;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName CopyListWithRandom
 * @Description CopyListWithRandom
 * @Author szh
 * @Date 2024年01月03日
 */
public class CopyListWithRandom {


    /**
     *
     * rand指针是单链表节点结构中新增的指针，rand可能指向链表中任意一个节点，也可能指向null ,
     * 给定一个由Node即诶单类型组成的无还单链表的头节点head,请实现一个函数完成这个链表的复制，
     * 并返回复制新链表的头节点
     *
     */


    public static class ListNode{
        int val;
        ListNode next;

        ListNode random;

        ListNode(){}
        ListNode(int val){
            this.val = val;
        }
        ListNode(int val , ListNode next , ListNode random){
            this.val = val;
            this.next = next;
            this.random = random;
        }
    }

    public static ListNode copyListWithRand1(ListNode head){
        Map<ListNode , ListNode> map = new HashMap<>();

        ListNode curr = head;

        while(curr != null){
            map.put(curr , new ListNode(curr.val));
            curr = curr.next;
        }
        curr = head;
        while(curr != null){
            map.get(curr).next = map.get(curr.next);
            map.get(curr).random = map.get(curr.random);
            curr = curr.next;
        }
        return map.get(head);
    }


    public static ListNode copyListWithRand2(ListNode head){

        ListNode curr = head;

        // 在每个节点后面加上自己节点的拷贝节点
        // 1 -> 1' -> 2 -> 2'
        while(curr != null){
            ListNode next = curr.next;
            curr.next = new ListNode(curr.val);
            curr.next.next = next;
            curr = next;
        }

        curr = head;

        // 设置我们生成拷贝节点的random指针
        while(curr != null){
            ListNode copyNode = curr.next;
            copyNode.random = curr.random != null ? curr.random.next : null;
            curr = curr.next.next;
        }

        ListNode res = head.next;
        curr = head;

        // 分离我们的链表节点和原链表节点
        while(curr != null){
            ListNode next = curr.next.next;
            ListNode copyNode = curr.next;
            curr.next = next;
            copyNode.next = next != null ? next.next : null;
            curr = next;
        }
        return res;
    }


    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);

        node1.next = node2;
        node1.random = node3;

        node2.next = node3;
        node2.random = node1;

        node3.next = null;
        node3.random = null;



        ListNode listNode = copyListWithRand2(node1);


        System.out.println(listNode);


    }




}
