package com.letcode.szh.bilibili;

import java.util.Stack;

/**
 * @ClassName IsPalindromeList
 * @Description 判断一个链表是否是一个回文单链表
 * @Author szh
 * @Date 2024年01月03日
 */
public class IsPalindromeList {

    public static class ListNode{
        int val;
        ListNode next;

        ListNode(){}
        ListNode(int val){
           this.val = val;
        }
        ListNode(int val , ListNode next){
            this.val = val;
            this.next = next;
        }
    }


    public boolean isPalindrome1(ListNode head) {
        Stack<Integer> stack = new Stack<>();
        ListNode cur = head;

        while (cur != null){
            stack.add(cur.val);
            cur = cur.next;
        }

        while (head!=null){
            if(head.val != stack.pop()){
                return false;
            }
            head = head.next;
        }
        return true;
    }


    public boolean isPalindrome2(ListNode head) {


        /**
         *
         * 1、奇数个节点
         *      a. 快指针走到头的时候，慢指针走到中间节点  => 1 -> 2 -> [3] -> 2 ->1
         *          while(p2.next != null && p2.next.next != null)
         *          ListNode p1 = head; ListNode p2 = head; => p2 走两步， p1 走一步 ， p2 走到头， p1 走到中间位置
         *      b. 快指针走到头的时候，慢指针走到中间节点靠左节点 => 1 -> [2] -> 3 -> 2 ->1
         *          while(p2.next != null && p2.next.next != null)
         *          ListNode p1 = head; ListNode p2 = head.next; => p2 走两步， p1 走一步 ， p2 走到头， p1 中间节点靠左节点
         *      c. 快指针走到头的时候，慢指针走到中间节点靠右节点 => 1 -> 2 -> 3 -> [2] ->1
         *          while(p2.next != null && p2.next.next != null)
         *          ListNode p1 = head.next; ListNode p2 = head; => p2 走两步， p1 走一步 ， p2 走到头， p1 中间节点靠右节点
         *
         * 2、偶数个节点
         *      a. 快指针走到头的时候，慢指针走到中间节点的左节点 => 1 -> 2 -> [3] -> 3 -> 2 ->1
         *          while(p2.next != null && p2.next.next != null)
         *          ListNode p1 = head; ListNode p2 = head; => p2 走两步， p1 走一步 ， p2 走到头， p1 中间节点的左节点
         *
         *      b. 快指针走到头的时候，慢指针走到中间节点的右节点 => 1 -> 2 -> 3 -> [3] -> 2 ->1
         *          while(p2.next != null && p2.next.next != null)
         *          ListNode p1 = head.next; ListNode p2 = head; => p2 走两步， p1 走一步 ， p2 走到头， p1 中间节点的右节点
         *
         *      c. 快指针走到头的时候，慢指针走到中间节点的左边节点 => 1 -> [2] -> 3 -> 3 -> 2 ->1
         *          while(p2.next != null && p2.next.next != null)
         *          ListNode p1 = dummyHead(虚拟头节点); ListNode p2 = head; => p2 走两步， p1 走一步 ， p2 走到头， p1 中间节点的左边节点
         *
         *      c. 快指针走到头的时候，慢指针走到中间节点的右边节点 => 1 -> 2 -> 3 -> 3 -> [2] ->1
         *          while(p2.next != null && p2.next.next != null)
         *          ListNode p1 = head.next; ListNode p2 = head; => p2 走两步， p1 走一步 ， p2 走到头， p1.next 中间节点的右边节点
         */


        // 1 -> 2 -> 3 -> 3 -> 2 ->1
        // 1 -> 2 -> 3 -> 2 ->1
        ListNode p1 = head.next;
        ListNode p2 = head;

        while(p2.next != null && p2.next.next != null){
            p1 = p1.next;
            p2 = p2.next.next;
        }

        Stack<Integer> stack = new Stack<>();

        while(p1 != null){
            stack.add(p1.val);
            p1 = p1.next;
        }

        while(!stack.isEmpty()){
            if(stack.pop() != head.val){
                return false;
            }
            head = head.next;
        }

        return true;
    }


    public boolean isPalindrome3(ListNode head) {

        // 找到前半部分链表的尾节点
        ListNode firstHalfEnd = endOfFirstHalf(head);

        // 反转链表
        ListNode secondHalfStart = reverseList(firstHalfEnd.next);;


       ListNode p1 = head;
       ListNode p2 = secondHalfStart;

        boolean res = true;

        //比较是否回文
        while(p2 != null){
            if(p1.val != p2.val){
                res = false;
                break;
            }
            p1 = p1.next;
            p2 = p2.next;
        }

        firstHalfEnd.next = reverseList(secondHalfStart);

        return res;
    }



    // 翻转一个列表 ， 并且返回一个新链表的头节点
    public static ListNode reverseList(ListNode head){
        ListNode node = null;
        ListNode curr = head;
        while(curr != null){
            ListNode next = curr.next;
            curr.next = node;
            node = curr;
            curr = next;
        }

        return node;
    }


    // 翻转一个列表 ， 并且返回一个新链表的头节点
    public static ListNode endOfFirstHalf(ListNode head){
        ListNode p1 = head;
        ListNode p2 = head;
         // p2 快指针 p1慢指针
        // p2 走到头的时候， 如果是奇数个节点 p1 指向 中间节点 ， 如果偶数个节点，p1指向中间节点的靠左节点
        while(p2.next != null && p2.next.next != null){
            p1 = p1.next;
            p2 = p2.next.next;
        }
        return p1;
    }






    public static void main(String[] args) {
        IsPalindromeList obj = new IsPalindromeList();
        ListNode head =
                new ListNode(1 , new ListNode(2 , new ListNode(3 , new ListNode(3 , new ListNode(2 , new ListNode(1 , null))))));

//        ListNode head =
//                new ListNode(1 , new ListNode(2 , new ListNode(3 , new ListNode(2 , new ListNode(1 , null)))));

        System.out.println(obj.isPalindrome3(head));


    }





}
