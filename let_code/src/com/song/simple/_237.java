package com.song.simple;

public class _237 {

    public void deleteNode(ListNode node) {
        ListNode tailPreNde = null;
        while(node.next != null){
            if(node.next.next == null){
                tailPreNde = node;
            }
            node.val = node.next.val;
            node = node.next;
        }
        tailPreNde.next = null;

    }



    public static void main(String[] args){
        ListNode node = new ListNode(4);
        ListNode node1 = new ListNode(5);
        ListNode node2 = new ListNode(1);
        ListNode node3 = new ListNode(9);

        node.next = node1;
        node1.next = node2;
        node2.next = node3;

        _237 obj = new _237();
        obj.deleteNode(node1);

    }





}

class ListNode{
    int val;
    ListNode next;
    ListNode(int val){
        this.val = val;
    }
}