package com.song;

public class LinkedList<E> {

    private class Node{
        public E e;
        public Node next;

        public Node(E e,Node next){
            this.e = e;
            this.next = next;
        }

        public Node(E e){
            this(e,null);
        }

        public Node(){
            this(null,null);
        }

        @Override
        public String toString(){
            return e.toString();
        }
    }

    //设置一个虚拟的空的头结点，这样一来所有的节点都有前一个节点
    //在进行添加删除时候简化了操作.
    private Node dummyHead;
    private int size;

    public LinkedList(){
        dummyHead = new Node(null,null);
        size = 0;
    }

    //获取链表中元素的个数
    public int getSize(){
        return size;
    }

    //返回链表是否为空
    public boolean isEmpty(){
        return size == 0;
    }

    // 在链表的index(0-based)位置添加新的元素e
    // 在链表中不是一个常用的操作，练习的时候用
    public void add(int index,E e){
        if(index < 0 || index > size){
            throw new IllegalArgumentException("Add failed. Illegal index");
        }

        Node prev = dummyHead;
        for (int i = 0; i < index; i++){
            prev = prev.next;
        }
        /*Node node = new Node(e);
        node.next = prev.next;
        prev.next = node;*/
        prev.next = new Node(e,prev.next);
        size ++;
    }

    //在链表的头添加一个属性
    public void addFirst(E e){
        add(0,e);
    }

    //在链表的尾部添加一个元素
    public void addLast(E e){
        add(size,e);
    }

    // 获取index(0-based)位置的元素e
    // 在链表中不是一个常用的操作，练习的时候用
    public E get(int index){
        if(index < 0 || index > size){
            throw new IllegalArgumentException("Get failed. Illegal index");
        }
        Node cur = dummyHead.next;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        return cur.e;
    }

    //获取第一个元素
    public E getFirst(){
        return get(0);
    }

    //获取最后一个元素
    public E getLast(){
        return get(size-1);
    }

    // 修改index(0-based)位置的元素e
    // 在链表中不是一个常用的操作，练习的时候用
    public void set(int index,E e){
        if(index < 0 || index > size){
            throw new IllegalArgumentException("Set failed. Illegal index");
        }
        Node cur = dummyHead.next;
        for(int i = 0; i < index ; i ++){
            cur = cur.next;
        }
        cur.e = e;
    }

    //查找链表中是否包含元素e
    public boolean contains(E e){
        Node cur = dummyHead.next;
        while (cur != null){
            if(cur.e.equals(e)){
                return true;
            }
            cur = cur.next;
        }
        return false;
    }

    // 删除index(0-based)位置的元素，返回删除的元素.
    // 在链表中不是一个常用的操作，练习的时候用
    public E remove(int index){
        if(index < 0 || index > size){
            throw new IllegalArgumentException("Get failed. Illegal index");
        }
        Node prev = dummyHead;
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }
        Node retNode = prev.next;
        prev.next = retNode.next;
        //删除节点next置为null，为了让垃圾回收机制回收。
        retNode.next = null;
        size --;
        return retNode.e;
    }

    //从链表中删除第一个元素，返回删除的元素
    public E removeFirst(){
        return remove(0);
    }

    //从链表中删除最后一个元素，返回删除的元素
    public E removeLast(){
        return remove(size-1);
    }



    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();
        Node cur = dummyHead.next;
        while(cur != null){
            res.append(cur + "->");
            cur = cur.next;
        }
       /* for (Node cur = dummyHead.next; cur != null; cur = cur.next){
            res.append(cur + "->");
        }*/
        res.append("NULL");
        return res.toString();
    }


}
