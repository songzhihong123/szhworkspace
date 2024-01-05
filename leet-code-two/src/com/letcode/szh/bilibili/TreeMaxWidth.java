package com.letcode.szh.bilibili;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * @ClassName TreeMaxWidth
 * @Description TreeMaxWidth
 * @Author szh
 * @Date 2024年01月04日
 */
public class TreeMaxWidth {

    /**
     * 求一颗树的最大宽度 ， 即每一层的节点的最大个数
     *
     * 依赖层序遍历
     */


    public static class ListNode{
        int val;
        ListNode left;

        ListNode right;

        ListNode(){}
        ListNode(int val){
            this.val = val;
        }
        ListNode(int val , ListNode left , ListNode right){
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }


    // 使用hashMap
    public int maxWidth(ListNode head){

        Queue<ListNode> queue = new LinkedList<>();
        queue.add(head);

        // 层级Map ， 用来记录当前节点在那一层
        Map<ListNode, Integer> levelMap = new HashMap<>();
        levelMap.put(head , 1);

        //当前在第几层
        int currentLevel = 1;
        // 当前层节点个数
        int currentNodeCount = 0;
        // 最大宽度
        int maxWidth = Integer.MIN_VALUE;

        while(!queue.isEmpty()){
            ListNode poll = queue.poll();
            // 获取弹出节点的层数
            Integer pollLevel = levelMap.get(poll);
            if(pollLevel == currentLevel){
                // 弹出节点的层数在当前层 ， 当前层节点数加一
                currentNodeCount ++;
            }else{
                // 弹出节点不在当前层
                // 当前层树 加一
                currentLevel ++;
                // 求最大节点个数
                maxWidth = Math.max(maxWidth , currentNodeCount);
                // 当前层节点个数重置为1
                currentNodeCount = 1;
            }

            if(poll.left != null){
                levelMap.put(poll.left , pollLevel + 1);
                queue.add(poll.left);
            }
            if(poll.right != null){
                levelMap.put(poll.right , pollLevel + 1);
                queue.add(poll.right);
            }
        }

        return maxWidth;
    }


    // 不使用hashMap
    public int maxWidth1(ListNode head){

        Queue<ListNode> queue = new LinkedList<>();
        queue.add(head);

        // 当前层的最后一个节点
        ListNode curEnd = head;
        // 下一层的最后一个节点
        ListNode nextEnd = null;

        int curNodeCount = 0;

        // 最大宽度
        int maxWidth = Integer.MIN_VALUE;

        while(!queue.isEmpty()){
            ListNode poll = queue.poll();

            if(poll.left != null){
                queue.add(poll.left);
                nextEnd = poll.left;
            }
            if(poll.right != null){
                queue.add(poll.right);
                nextEnd = poll.right;
            }

            curNodeCount ++;

            // 当前弹出的节点是当前层最后一个节点
            if(poll == curEnd){
                // 求最大值
                maxWidth = Math.max(maxWidth , curNodeCount);
                // 初始化当前层的节点个数，准备开始下一层的遍历
                curNodeCount = 0;
                // 更新下一层的最后一个节点为当前层的最后一个节点， 准备开始下一层的遍历
                curEnd = nextEnd;
                // 初始化下一层的最后一个节点
                nextEnd = null;
            }

        }

        return maxWidth;
    }







}
