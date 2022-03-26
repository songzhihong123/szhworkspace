package com.song.leetcode;

/**
 * 删除链表中等于给定值 val 的所有节点。
 *  输入: 1->2->6->3->4->5->6, val = 6
 *  输出: 1->2->3->4->5
 */
class Solution2 {
    public ListNode removeElements(ListNode head, int val) {

        ListNode dummHead = new ListNode(-1);
        dummHead.next = head;

        ListNode prev = dummHead;
        while (prev.next != null){
            if(prev.next.val == val){
               prev.next = prev.next.next;
            }else{
                prev = prev.next;
            }
        }
        return dummHead.next;

    }
}