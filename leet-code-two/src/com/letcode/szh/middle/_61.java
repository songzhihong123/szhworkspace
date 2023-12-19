package com.letcode.szh.middle;


/**
 * @ClassName _61
 * @Description _61
 * @Author szh
 * @Date 2023年12月18日
 */
public class _61 {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int val) {this.val = val;}
        ListNode(int val , ListNode next) {this.val = val ; this.next = next;}
    }


    public ListNode rotateRight(ListNode head, int k) {

        if (k == 0 || head == null || head.next == null) {
            return head;
        }

        // 求链表总长度
        int listLen = 1;
        ListNode hHead = head;
        while(hHead.next != null){
            hHead = hHead.next;
            listLen ++;
        }

        // 求移动多少位
        int index = k % listLen;
        int a = listLen - index;

        if(a == listLen){
            return head;
        }

        // 将链表链接起来
        hHead.next = head;

        //找到需要断的位置
        while (a-- > 0){
            hHead = hHead.next;
        }


        ListNode node = hHead.next;
        hHead.next = null;

        return node;
    }




}
