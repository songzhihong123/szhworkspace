package com.letcode.szh.bilibili;

/**
 * @ClassName MorrisTraversal
 * @Description morris 遍历二叉树
 * @Author szh
 * @Date 2024年01月08日
 */
public class MorrisTraversal {

    /*
    假设来到当前节点cur，开始时cur来到头节点位置
		1、如果cur没有左孩子，cur向右移动
		2、如果cur有左孩子，找到左子树上最右的节点mostRight：
			a.如果mostRight的右指针指向空，让其指向cur，然后cur向左移动。
			b.如果mostRight的右指针指向cur，让其指向null，然后cur向右移动
		3、cur为空的时候遍历停止

     */

    public static class Node{
        public int value;
        public Node left;
        public Node right;
        public Node(int value){
            this.value = value;
        }
    }

    // morris 版本遍历二叉树
    // 特点： 有左子树的节点会被走过两次 ， 没有左子树的的节点走过一次
    public static void morris(Node head){
        if(head == null){
            return;
        }
        Node cur = head;
        Node mostRight = null;
        while(cur != null){
            mostRight = cur.left;
            if(mostRight != null){ // 有左子树
                // 找到左子树上最右的节点mostRight：
                while(mostRight.right != null && mostRight.right != cur){
                    mostRight = mostRight.right;
                }
                // mostRight 变成了cur左子树上，最右的节点
                // 如果mostRight的右指针指向空，让其指向cur，然后cur向左移动。
                if(mostRight.right == null){ // 第一次来到cur
                    mostRight.right = cur;
                    cur = cur.left;
                    continue;
                }else{ //第二次来到cur
                    // 如果mostRight的右指针指向cur，让其指向null
                    mostRight.right = null;
                }

            }
            cur = cur.right;
        }
    }

    // morris 版本的前序遍历
    public static void morrisPreOrder(Node head){
        if(head == null){
            return;
        }
        Node cur = head;
        Node mostRight = null;
        while(cur != null){
            mostRight = cur.left;
            if(mostRight != null){ // 有左子树
                // 找到左子树上最右的节点mostRight：
                while(mostRight.right != null && mostRight.right != cur){
                    mostRight = mostRight.right;
                }
                // mostRight 变成了cur左子树上，最右的节点
                // 如果mostRight的右指针指向空，让其指向cur，然后cur向左移动。
                if(mostRight.right == null){ // 第一次来到cur
                    System.out.println(cur.value);
                    mostRight.right = cur;
                    cur = cur.left;
                    continue;
                }else{ //第二次来到cur
                    // 如果mostRight的右指针指向cur，让其指向null
                    mostRight.right = null;
                }

            }else{
                System.out.println(cur.value);
            }
            cur = cur.right;
        }
    }

    // morris 版本的中序遍历
    public static void morrisInOrder(Node head){
        if(head == null){
            return;
        }
        Node cur = head;
        Node mostRight = null;
        while(cur != null){
            mostRight = cur.left;
            if(mostRight != null){ // 有左子树
                // 找到左子树上最右的节点mostRight：
                while(mostRight.right != null && mostRight.right != cur){
                    mostRight = mostRight.right;
                }
                // mostRight 变成了cur左子树上，最右的节点
                // 如果mostRight的右指针指向空，让其指向cur，然后cur向左移动。
                if(mostRight.right == null){ // 第一次来到cur
                    mostRight.right = cur;
                    cur = cur.left;
                    continue;
                }else{ //第二次来到cur
                    // 如果mostRight的右指针指向cur，让其指向null
                    mostRight.right = null;
                }

            }
            System.out.println(cur.value);
            cur = cur.right;
        }
    }



    // morris 版本的后序遍历
    // 第二次来到当前节点，逆序打印当前节点左树的右边界
    // 遍历完了之后，逆序打印整棵树的右边界
    public static void morrisPostOrder(Node head){
        if(head == null){
            return;
        }
        Node cur = head;
        Node mostRight = null;
        while(cur != null){
            mostRight = cur.left;
            if(mostRight != null){ // 有左子树
                // 找到左子树上最右的节点mostRight：
                while(mostRight.right != null && mostRight.right != cur){
                    mostRight = mostRight.right;
                }
                // mostRight 变成了cur左子树上，最右的节点
                // 如果mostRight的右指针指向空，让其指向cur，然后cur向左移动。
                if(mostRight.right == null){ // 第一次来到cur
                    mostRight.right = cur;
                    cur = cur.left;
                    continue;
                }else{ //第二次来到cur
                    // 如果mostRight的右指针指向cur，让其指向null
                    mostRight.right = null;
                    //第二次来到当前节点，逆序打印当前节点左树的右边界
                    printEdge(cur.left);
                }

            }
            cur = cur.right;
        }
        // 遍历完了之后，逆序打印整棵树的右边界
        printEdge(head);
    }


    // 以X为头的数 ， 逆序打印这棵树的右边界
    public static void printEdge(Node X){
        Node tail = reverseEdge(X);
        Node cur = tail;
        while(cur != null){
            System.out.println(cur.value);
            cur = cur.right;
        }
        reverseEdge(tail);
    }

    // 翻转一个列表
    public static Node reverseEdge(Node node){
        Node pre = null;
        Node cur = node;

        while(cur.right != null){
            Node next = cur.right;
            cur.right = pre;
            pre = cur;
            cur = next;
        }

        return pre;
    }



    public static boolean isBST(Node head){
        if(head == null){
            return true;
        }
        Node cur = head;
        Node mostRight = null;
        int preValue = Integer.MIN_VALUE;
        while(cur != null){
            mostRight = cur.left;
            if(mostRight != null){ // 有左子树
                // 找到左子树上最右的节点mostRight：
                while(mostRight.right != null && mostRight.right != cur){
                    mostRight = mostRight.right;
                }
                // mostRight 变成了cur左子树上，最右的节点
                // 如果mostRight的右指针指向空，让其指向cur，然后cur向左移动。
                if(mostRight.right == null){ // 第一次来到cur
                    mostRight.right = cur;
                    cur = cur.left;
                    continue;
                }else{ //第二次来到cur
                    // 如果mostRight的右指针指向cur，让其指向null
                    mostRight.right = null;
                }

            }

            // ==========原本中序遍历的地方来做数据的比较===========
            if(cur.value <= preValue){
                return false;
            }
            preValue = cur.value;
            // ==========原本中序遍历的地方来做数据的比较===========

            cur = cur.right;
        }

        return true;
    }





}
