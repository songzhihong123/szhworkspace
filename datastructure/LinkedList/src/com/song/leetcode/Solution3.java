package com.song.leetcode;

/**
 * 删除链表中等于给定值 val 的所有节点。
 *  输入: 1->2->6->3->4->5->6, val = 6
 *  输出: 1->2->3->4->5
 */
class Solution3 {
    public ListNode removeElements(ListNode head, int val) {
        if(head == null){
            return head;
        }
       /* ListNode res = removeElements(head.next,val);
        if(head.val == val){
            return res;
        }else{
            head.next = res;
            return head;
        }*/
        head.next = removeElements(head.next,val);
        /*if(head.val == val){
            return head.next;
        }else{
            return head;
        }*/
        return head.val == val ? head.next:head;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,6,3,4,5,6};
        ListNode head = new ListNode(nums);
        System.out.println(head);

        //ListNode res = new Solution3().removeElements(head, 6);

        ListNode res = new Solution3().removeElements1(head, 6,0);
        System.out.println(res);
    }


    public ListNode removeElements1(ListNode head, int val,int depth) {

        String depthString = generateDepthString(depth);
        System.out.print(depthString);
        System.out.println("Call: remove " + val + " in " + head);
        if(head == null){
            System.out.print(depthString);
            System.out.println("Return: "+head);
            return head;
        }
        ListNode res = removeElements1(head.next,val,depth + 1);
        System.out.print(depthString);
        System.out.println("After remove "+ val + ": "+res);

        ListNode ret;
        if(head.val == val){
            ret  = res;
        }else{
            head.next = res;
            ret = head;
        }
        System.out.print(depthString);
        System.out.println("Return:  "+ ret);
        return ret;
    }

    private String generateDepthString(int depth){
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < depth; i++) {
            res.append("--");
        }
        return res.toString();
    }



}