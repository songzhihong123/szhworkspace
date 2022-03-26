package com.imooc.datastructure.linkedList;

public class _203 {


    public ListNode removeElements(ListNode head, int val) {
        while (head != null && head.val == val){
            ListNode delNode = head;
            head = head.next;
            delNode.next = null;
        }
        if(head == null){
            return head;
        }
        ListNode prev = head;
        while(prev.next != null){
            if(prev.next.val == val){
                ListNode delNode = prev.next;
                prev.next = delNode.next;
                delNode.next = null;
            }else{
                prev = prev.next;
            }
        }
        return head;
    }

    public ListNode removeElements1(ListNode head, int val) {
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode prev = dummyHead;
        while(prev.next != null){
            if(prev.next.val == val){
                prev.next = prev.next.next;
            }else{
                prev = prev.next;
            }
        }
        return dummyHead.next;
    }


    public ListNode removeElements3(ListNode head, int val) {
        if(head == null){
            return head;
        }
        head.next = removeElements3(head.next , val);
        return head.val == val ? head.next : head;
    }






      public class ListNode {
          int val;
          ListNode next;
          ListNode(int x) { val = x; }
      }

}
