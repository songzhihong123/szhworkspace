package com.song.simple.day5;

public class _876 {


    public ListNode middleNode(ListNode head) {
        ListNode left = head;
        ListNode right = head;

        while(right != null && right.next != null){
            right = right.next.next;
            left = left.next;
        }
       return left;
    }



    public static void main(String[] args){
        _876 obj = new _876();



    }




}
class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }