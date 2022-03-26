package com.song.medium;

/**
 * Created by Zhihong Song on 2021/3/27 9:22
 */

public class _61 {

    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null || k <= 0){
            return head;
        }
        ListNode countNode = head;
        int size = 1;
        while(countNode.next != null){
            size ++;
            countNode  = countNode.next;
        }
        int realCount = k % size;
        if(realCount == 0){
            return head;
        }
        int needFindCount = size - realCount;

        int  counter = 1;
        ListNode curr = head;
        while(curr.next != null){
            if(counter == needFindCount){
                break;
            }
            counter ++;
            curr = curr.next;
        }

        ListNode targetNode = curr.next;
        curr.next = null;

        ListNode lastNode = targetNode;
        while(lastNode != null && lastNode.next != null){
            lastNode =lastNode.next;
        }
        lastNode.next = head;

        return targetNode;
    }

    public static void main(String[] args){
//        ListNode head = new ListNode(1,new ListNode(2, new ListNode(3 , new ListNode(4, new ListNode(5)))));
        ListNode head = new ListNode(1,new ListNode(2 ));
        _61 obj = new _61();
        obj.rotateRight(head,1);

    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }


}
