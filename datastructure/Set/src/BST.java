import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BST<E extends Comparable<E>> {

    private class Node{
        public E e;
        public Node left,right;
        public Node(E e){
            this.e = e;
            this.left = null;
            this.right = null;
        }
    }

    private Node root;
    private int size;

    public BST(){
        root = null;
        size = 0;
    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return  size == 0;
    }

    //添加元素的非递归实现
    public void add1(E e){
        if(root == null){
            root = new Node(e);
            size++;
        }else{
            Node cur = root;
            while(true){
                if(e.equals(cur.e)){
                    return;
                }else if(e.compareTo(cur.e) < 0){
                    if(cur.left == null){
                        cur.left = new Node(e);
                        break;
                    }else{
                        cur = cur.left;
                    }
                }else if(e.compareTo(cur.e) > 0){
                    if(cur.right == null){
                        cur.right = new Node(e);
                        break;
                    }else{
                        cur = cur.right;
                    }
                }
            }
        }
    }

    //向二分搜索树中添加一个新元素e，递归实现
    public void add(E e){
        root = add(root,e);
    }

    //向以node为根的二分搜索树中插入元素E，递归算法
    // 返回插入新节点后二分搜索树的根
    private Node add(Node node,E e){
        if(node == null){
            size ++;
            return new Node(e);
        }
        if(e.compareTo(node.e) < 0){
            node.left = add(node.left,e);
        }else if(e.compareTo(node.e) > 0){
            node.right = add(node.right,e);
        }
        return node;
    }

    //看二分搜索树中是否包含元素e
    public boolean contains(E e){
        return contains(root,e);
    }

    //看以node为根的二分搜索树中是否包含元素e，递归算法
    private boolean contains(Node node,E e){
        if(node == null){
            return false;
        }
        if(e.compareTo(node.e) < 0){
            return contains(node.left,e);
        }else if(e.compareTo(node.e) > 0){
            return contains(node.right,e);
        }else{
            return true;
        }
    }

    //二分搜索树的前序遍历.
    public void perOrder(){
        perOrder(root);
    }

    //前序遍历以node为根的二分搜索树，递归算法
    private void perOrder(Node node){
        if(node == null){
            return;
        }
        System.out.println(node.e);
        perOrder(node.left);
        perOrder(node.right);
    }

    //二分搜索树的非递归前序遍历
    //深度优先遍历 需要使用栈数据结构
    public void perOrderNR(){
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
            Node cur = stack.pop();
            System.out.println(cur.e);
            //因为栈是LIFO 所以想加入右节点
            if(cur.right != null){
                stack.push(cur.right);
            }
            if (cur.left != null){
                stack.push(cur.left);
            }
        }
    }

    //二分搜索树的中序遍历.
    public void inOrder(){
        inOrder(root);
    }

    //中序遍历以node为根的二分搜索树，递归算法
    private void inOrder(Node node){
        if(node == null){
            return;
        }
        inOrder(node.left);
        System.out.println(node.e);
        inOrder(node.right);
    }

    //二分搜索树的后序遍历.
    public void postOrder(){
        postOrder(root);
    }

    //后序遍历以node为根的二分搜索树，递归算法
    private void postOrder(Node node){
        if(node == null){
            return;
        }
        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node.e);
    }

    //广度优先遍历
    public void levelOrder(){
        if (root == null){
            return;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            Node cur = queue.remove();
            System.out.println(cur.e);
            //队列是FIFO 所以左子树先入队
            if(cur.left != null){
                queue.add(cur.left);
            }
            if(cur.right != null){
                queue.add(cur.right);
            }
        }
    }


    //寻找二分搜索树的最小元素
    public E minimum(){
        if(size == 0)
            throw new IllegalArgumentException("BST is empty");
        return minimum(root).e;
    }

    //返回以node为根的二分搜索树的最小键值所在的节点.
    public Node minimum(Node node){
        if(node.left == null){
            return node;
        }
        return minimum(node.left);
    }

    //寻找二分搜索树的最大元素
    public E maximum(){
        if(size == 0)
            throw new IllegalArgumentException("BST is empty");
        return maximum(root).e;
    }

    //返回以node为根的二分搜索树的最大键值所在的节点.
    public Node maximum(Node node){
        if(node.right == null){
            return node;
        }
        return maximum(node.right);
    }

    //从二分搜索树中删除最小值所在的节点，返回最小值
    public E removeMin(){
        E ret = minimum();
        root = removeMin(root);
        return ret;
    }

    /**
     * 删除掉以node为根的二分搜索树中最小的节点
     * 返回删除节点后新的二分搜索树的根
     * 原理：
     *      如果当前节点有左子树，那么当前节点就不是最小值，需要一直找到左子树为null的时候
     *      就说明当前节点是最小值所在的节点，需要删除这个节点，但是这个节点有可能有右子树
     *      首先将当前节点的右子树保存下来，之后将当前节点的右子树置空，让垃圾回收机制回收，
     *      然后返回右子树的根节点。
     */
    private Node removeMin(Node node){
        if(node.left == null){
            Node rightNode = node.right;
            node.right = null;
            size --;
            return rightNode;
        }
        node.left = removeMin(node.left);
        return node;
    }

    //从二分搜索树中删除最大值所在的节点，返回最大值
    public E removeMax(){
        E ret = maximum();
        root = removeMax(root);
        return ret;
    }

    private Node removeMax(Node node){
        if(node.right == null){
            Node leftNode = node.left;
            node.left = null;
            size --;
            return leftNode;
        }
        node.right = removeMax(node.right);
        return node;
    }

    //从二分搜索树中删除元素为e的节点
    public void remove(E e){
        root = remove(root,e);
    }

    /**
     * 删除以node为根的二分搜索树中值为e的节点，递归算法
     * 返回删除节点后新的二分搜索树的根
     */
    private Node remove(Node node,E e){
        if(node == null)
            return null;
        if(e.compareTo(node.e) < 0){
            node.left = remove(node.left,e);
            return node;
        }else if(e.compareTo(node.e) > 0){
            node.right = remove(node.right,e);
            return node;
        }else{//e == node.e
            /**
             * 三种情况：
             *  1、只有右子树，左子树为空
             *  2、只有左子树、右子树为空
             *  3、左子树和右子树都不为空
             */
            //待删除节点的左子树为空
            if(node.left == null){
                Node rightNode = node.right;
                node.right = null;
                size --;
                return rightNode;
            }
            //待删除节点的右子树为空
            if(node.right == null){
                Node leftNode = node.left;
                node.left = null;
                size --;
                return leftNode;
            }
            //待删除节点的左右子树都不为空
            //找到比待删除节点大的最小的节点，即待删除节点的右子树的最小节点
            //用找到的这个节点去代替待删除节点位置
            /*总结：找到当前节点的后继节点去代替当前节点*/
            Node successor = minimum(node.right);
            successor.right = removeMin(node.right);
            successor.left = node.left;
            node.left = node.right = null;
            return successor;

        }

    }


    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();
        generateBSTString(root,0,res);
        return res.toString();
    }


    //生成以node为根节点，深度为depth的描述二叉树的字符串
    private void generateBSTString(Node node,int depth,StringBuilder res){
        if(node == null){
            res.append(generateDepthStrig(depth) + "null\n");
            return;
        }
        res.append(generateDepthStrig(depth)+node.e+"\n");
        generateBSTString(node.left,depth+1,res);
        generateBSTString(node.right,depth+1,res);
    }

    private String generateDepthStrig(int depth){
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < depth; i++) {
            res.append("--");
        }
        return res.toString();
    }

}
