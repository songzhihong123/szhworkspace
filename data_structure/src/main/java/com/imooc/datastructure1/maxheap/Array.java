package com.imooc.datastructure1.maxheap;

/**
 * @ClassName Array
 * @Description Array
 * @Author szh
 * @Date 2023年07月09日
 */
public class Array<E> {

    private E[] data;

    private int size;

    public Array(int capacity){
        data = (E[])new Object[capacity];
        size = 0;
    }

    public Array(E[] arr){
        data = (E[])new Object[arr.length];
        for(int i = 0 ; i < arr.length ; i ++){
            data[i] = arr[i];
        }
        size = arr.length;;
    }

    public Array(){
        this(10);
    }


    public void addLast(E e){
        add(size , e);
    }

    public void addFirst(E e){
        add(0 , e);
    }

    public void add(int index , E e){

        if(index < 0 || index > size){
            throw new IllegalArgumentException("failed");
        }

        if(size == data.length){
            resize(2 * data.length);
        }

        for (int i = size - 1  ; i >= index ; i --){
            data[i + 1] = data[i];
        }

        data[index] = e;
        size ++;
    }

    public E get(int index){
        if(index < 0 || index >= size){
            throw new IllegalArgumentException("Index is illegal");
        }
        return data[index];
    }

    public void set(int index , E e){
        if(index < 0 || index >= size){
            throw new IllegalArgumentException("Index is illegal");
        }
        data[index] = e;
    }

    public boolean contains(E e){
        for (int i = 0 ; i < size ; i ++){
            if(data[i].equals(e)){
                return true;
            }
        }
        return false;
    }

    public int find(E e){
        for (int i = 0 ; i < size ; i ++){
            if(data[i].equals(e)){
                return i;
            }
        }
        return -1;
    }

    public E remove(int index){
        if(index < 0 || index >= size){
            throw new IllegalArgumentException("remove failed");
        }
        E res = data[index];
        for (int i = index + 1; i < size ; i++){
            data[i - 1] = data[i];
        }
        size --;
        // loitering objects != memory leak
        data[size] = null;
        // 防止复杂度的震荡，改为达到数据的 data.length / 4 在缩容
        // 之前是 data.length / 2 ， 会发生扩容之后立即缩容的情况
        if(size == data.length / 4 && data.length / 2 != 0){
            resize(data.length / 2);
        }

        return res;
    }

    public E removeFirst(){

        return remove(0);
    }

    public E removeLast(){

        return remove(size - 1);
    }

    public void removeElement(E e){
        int index = find(e);
        if(index != -1){
            remove(index);
        }
    }

    public int getSize(){
        return size;
    }

    public int getCapacity(){
        return data.length;
    }

    public boolean isEmpty(){
        return size == 0;
    }


    public void swap(int i , int j){
        if(i < 0 || i >= size || j < 0 || j >= size){
            throw new IllegalArgumentException("Index is illegal");
        }
        E t = data[i];
        data[i] = data[j];
        data[j] = t;
    }

    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();
        res.append(String.format("size = %d , capacity = %d\n" , size , data.length));
        res.append("[");
        for (int i = 0 ; i< size ; i++){
            res.append(data[i]);
            if(i != size - 1){
                res.append(", ");
            }
        }
        res.append("]");
        return res.toString();
    }


    private void resize(int newCapacity){
        E[] newData = (E[])new Object[newCapacity];
        for(int i = 0 ; i < size ; i ++ ){
            newData[i] = data[i];
        }
        data = newData;
    }

}
