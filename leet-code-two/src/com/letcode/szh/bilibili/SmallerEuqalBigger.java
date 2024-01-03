package com.letcode.szh.bilibili;

/**
 * @ClassName SmallerEuqalBigger
 * @Description SmallerEuqalBigger
 * @Author szh
 * @Date 2024年01月03日
 */
public class SmallerEuqalBigger {

    /**
     * 将单链表按某值划分成左边小、中间相等、右边大的形式
     *
     */

    public static class ListNode{
        int val;
        ListNode next;

        ListNode(){}
        ListNode(int val){
            this.val = val;
        }
        ListNode(int val , ListNode next){
            this.val = val;
            this.next = next;
        }
    }


    public static ListNode listPartition2(ListNode head , int pivot){
        ListNode sH = null; // small head
        ListNode sT = null; // small tail
        ListNode eH = null; // euqal head
        ListNode eT = null; // euqal tail
        ListNode mH = null; // big head
        ListNode mT = null; // big tail

        ListNode next = null;
        while(head != null){
            next = head.next;
            head.next = null;
            int val = head.val;
            if(val < pivot){
                if(sH == null){
                    sH = head;
                    sT = head;
                }else{
                    sT.next = head;
                    sT = head;
                }
            }else if(val == pivot){
                if(eH == null){
                    eH = head;
                    eT = head;
                }else{
                    eT.next = head;
                    eT = head;
                }
            }else { //val > pivot
                if(mH == null){
                    mH = head;
                    mT = head;
                }else{
                    mT.next = head;
                    mT = head;
                }
            }
            head = next;
        }
        // 1 -> 2 -> 3 -> 3 -> 2 ->1
        // 小于区域不为空
        if(sT != null){
            sT.next = eH;
            eT = eT == null ? sT : eT; // 谁去连大于区域的头，谁就变成eT
        }

        if(eT != null){
            eT.next = mH;
        }

        return sH != null ? sH : (eH != null ? eH : mH);

    }


    public static void main(String[] args) {
        ListNode head =
                new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(3, new ListNode(2, new ListNode(1, null))))));

//        ListNode head =
//                new ListNode(1 , new ListNode(2 , new ListNode(3 , new ListNode(2 , new ListNode(1 , null)))));

        System.out.println(listPartition2(head, 4));

    }

}
