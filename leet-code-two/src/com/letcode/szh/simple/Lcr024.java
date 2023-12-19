package com.letcode.szh.simple;

/**
 * @ClassName Lcr024
 * @Description Lcr024
 * @Author szh
 * @Date 2023年12月18日
 */
public class Lcr024 {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int val) {this.val = val;}
        ListNode(int val , ListNode next) {this.val = val ; this.next = next;}
    }

    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;

        while(curr != null){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;

        }
        return prev;
    }




    public static void main(String[] args) {

    }


}
