package com.letcode.szh.bilibili;

/**
 * @ClassName FindFirstIntersectNode
 * @Description FindFirstIntersectNode
 * @Author szh
 * @Date 2024年01月03日
 */
public class FindFirstIntersectNode {


    /**
     *
     *
     *  给定两个可能有环也可能无环的单链表 ， 头节点head1 和 head2 。 请实现一个函数，如果两个链表相交，
     *  请返回相交的第一个节点。如果不相交， 返回null.
     *
     *
     *  两个无环链表 noLoop(ListNode head1 , ListNode head2)
     *  两个链表一个链表有环， 一个链表无环 ， 两个链表不可能相交， 因为链表上的节点不可能出现两个指针
     *
     *
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


    public static ListNode getIntersectNode(ListNode head1 , ListNode head2){


        ListNode loop1 = getLoopNode(head1);
        ListNode loop2 = getLoopNode(head2);

        // 表示两个无环链表
        if(loop1 == null && loop2 == null){
            return  noLoop(head1 , head2);
        }

        //表示两个有环链表
        if(loop1 != null && loop2 != null){
            return both(head1 , loop1 , head2 , loop2);
        }

        //两个链表一个链表有环， 一个链表无环 ， 两个链表不可能相交， 因为链表上的节点不可能出现两个指针
        return null;
    }






    // 判断一个以head为头节点的链表有没有环
    // 方法：快慢指针，开始快慢指针都指向头节点
    // 1、慢指针p1每次走一步，快指针 p2每次走两步， 当p1和p2相遇的时候说明链表有环
    // 2、慢指针不动，快指针回到头节点，快慢指针每次走一步，再次相遇即为入环节点
    public static ListNode getLoopNode(ListNode head){
        ListNode n1 = head.next;
        ListNode n2 = head.next.next;

        while(n1 != n2){
            if(n2.next == null || n2.next.next == null){
                return null;
            }
            n2 = n2.next.next;
            n1 = n1.next;
        }
        n2 = head;
        while (n1 != n2){
            n1 = n1.next;
            n2 = n2.next;
        }
        return n1;
    }


    // 如果两个链表无环， 返回第一个相交节点， 如果不相交，返回null
    // 第一个链表遍历到最后一个节点，记录链表长度 例如 10
    // 第二个链表遍历到最后一个节点，记录链表长度 例如 8
    // 比较两个链表最后一个值是否相同，不相同则表示不相交
    // 将较长链表先移动差值 (10 - 2) 步
    // 然后两个链表一起移动 ， 两个值相等的时候，就是入环的节点
    public static ListNode noLoop(ListNode head1 , ListNode head2){

        ListNode cur1 = head1;
        ListNode cur2 = head2;

        int n = 0;
        // 第一个链表遍历到最后一个节点，记录链表长度
        while(cur1.next != null){
            n ++;
            cur1 = cur1.next;
        }
        // 第二个链表遍历到最后一个节点，记录链表长度
        while(cur2.next != null){
            n --;
            cur2 = cur2.next;
        }

        // 比较两个链表最后一个值是否相同，不相同则表示不相交
        if(cur1 != cur2){
            return null;
        }

        // 将长链表给 cur1 , 将短链表给cur2
        cur1 = n > 0 ? head1 : head2;
        cur2 = cur1 == head1 ? head2 : head1;
        n = Math.abs(n);
        // 将较长链表先移动差值 n 步
        while(n != 0){
            n --;
            cur1 = cur1.next;
        }

        // 然后两个链表一起移动 ， 两个值相等的时候，就是入环的节点
        while(cur1 != cur2){
            cur1 = cur1.next;
            cur2 = cur2.next;
        }

        return cur1;
    }


    // 两个有环链表， 返回第一个相交节点， 如果不相交返回null
    // head1 ， head2 两个有环列表的头节点， loop1 , loop2 两个有环列表的入环节点
    // 如果两个链表在入环前相交 -> 与 【如果两个链表无环， 返回第一个相交节点】 流程一样
    // 如果两个链表环上不相同的节点相交 -> 则从任一链表的入环节点开始遍历， 在回到入环节点之后和另一个入环节点相遇，返回loop1； 不相遇则表示两个不相交，返回null
    public static ListNode both(ListNode head1 , ListNode loop1 , ListNode head2 , ListNode loop2){
        ListNode cur1 = null;
        ListNode cur2 = null;

        // 与【两个链表无环， 返回第一个相交节点】类似
        if(loop1 == loop2){
            cur1 = head1;
            cur2 = head2;
            int n = 0;

            while (cur1.next != loop1){
                n ++;
                cur1 = cur1.next;
            }
            while (cur2.next != loop2){
                n --;
                cur2 = cur2.next;
            }
            cur1 = n > 0 ? head1 : head2;
            cur2 = cur1 == head1 ? head2 : head1;
            n = Math.abs(n);

            while(n != 0){
                cur1 = cur1.next;
                n --;
            }

            while(cur1 != cur2){
                cur1 = cur1.next;
                cur2 = cur2.next;
            }
            return cur1;
        }else{
            cur1 = loop1.next;
            while(cur1 != loop1){
                if(cur1 == loop2){
                    return loop1;
                }
                cur1 = cur1.next;
            }
            return null;
        }

    }




}
