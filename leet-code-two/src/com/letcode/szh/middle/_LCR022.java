package com.letcode.szh.middle;

import java.util.HashSet;
import java.util.Set;

/**
 * @ClassName _LCR022
 * @Description _LCR022
 * @Author szh
 * @Date 2024年01月04日
 */
public class _LCR022 {

    /**
     *
     *
     * 给定一个链表，返回链表开始入环的第一个节点。
     * 从链表的头节点开始沿着 next 指针进入环的第一个节点为环的入口节点。如果链表无环，则返回 null。
     *
     *
     */

    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }


    // 1、 利用容器
    public ListNode detectCycle1(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        ListNode curr = head;

        while(curr != null){
            if(set.contains(curr)){
                return curr;
            }
            set.add(curr);
            curr = curr.next;
        }
        return null;
    }


    // 1、 快慢指针
    public ListNode detectCycle2(ListNode head) {
        if(head == null || head.next == null || head.next.next == null){
            return null;
        }

        ListNode p1 = head.next;
        ListNode p2 = head.next.next;

        // p1 = p2 的时候说明链表有环
        while(p1 != p2){
            if(p2.next == null || p2.next.next == null){
                return null;
            }
            p1 = p1.next;
            p2 = p2.next.next;
        }

        // 快指针指向头节点， 快慢指针每次走一步，相遇的时候就是入环即诶单
        p2 = head;

        while(p1 != p2){
            p1 = p1.next;
            p2 = p2.next;
        }


        return p2;
    }




}
