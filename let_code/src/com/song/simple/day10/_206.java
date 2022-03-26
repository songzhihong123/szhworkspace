package com.song.simple.day10;

public class _206 {




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

    public ListNode reverseList1(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }

        ListNode listNode = reverseList1(head.next);
        head.next.next = head;
        head.next = null;

        return listNode;

    }


    public static void main(String[] args){




    }



}
