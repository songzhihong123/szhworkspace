package com.song.simple;

import java.util.HashSet;
import java.util.Set;

/**
 * @description:
 * @author: szh
 * @create: 2021-06-04 14:22
 **/
public class _160 {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Set<ListNode> visited = new HashSet<>();
        ListNode temp = headA;
        while(temp != null){
            visited.add(temp);
            temp = temp.next;
        }
        temp = headB;
        while (temp != null){
            if(visited.contains(temp)){
                return temp;
            }
            temp = temp.next;
        }
        return null;
    }


    public ListNode getIntersectionNode1(ListNode headA, ListNode headB) {
       if(headA == null || headB == null){
           return null;
       }
       ListNode curra = headA;
       ListNode currb = headB;

       while (curra != currb){
           curra = curra == null ? headB : curra.next;
           currb = currb == null ? headA : currb.next;
       }
       return curra;
    }



    public static void main(String[] args){



    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
        ListNode(int x,ListNode next) {
            val = x;
            this.next = next;
        }
    }

}


