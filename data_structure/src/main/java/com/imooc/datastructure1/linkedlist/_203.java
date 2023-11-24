package com.imooc.datastructure1.linkedlist;

/**
 * @ClassName _203
 * @Description _203
 * @Author szh
 * @Date 2023年08月13日
 */
public class _203 {

    public static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }


    public ListNode removeElements(ListNode head, int val) {
        // 处理头节点是val
        while(head != null && head.val == val){
            ListNode delNode = head;
            head = head.next;
            delNode.next = null;
        }

        if(head == null){
            return null;
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

        ListNode dummyHead = new ListNode(-1 , head);

        ListNode prev = dummyHead;
        while(prev.next != null){
            if(prev.next.val == val){
                ListNode delNode = prev.next;
                prev.next = delNode.next;
                delNode.next = null;
            }else{
                prev = prev.next;
            }
        }

        return dummyHead.next;
    }


    public ListNode removeElements3(ListNode head, int val) {
        if(head == null){
            return null;
        }

        head.next = removeElements3(head.next , val);

        return head.val == val ? head.next : head;
    }




}
