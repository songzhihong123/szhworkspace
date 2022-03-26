package com.song.simple.day5;

public class _19 {


    public ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode dummyNode = new ListNode(0 , head);

       ListNode left = head;
       ListNode perLeft = dummyNode;

       for(int i = 0 ; i < n ; i++){
           left = left.next;
       }

       while(left != null){
           left = left.next;
           perLeft = perLeft.next;
       }

       perLeft.next = perLeft.next.next;

        return dummyNode.next;

    }


    public static void main(String[] args){
        _19 obj = new _19();
    }

}