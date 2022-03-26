package com.song;

import java.util.TreeMap;

public class HashTable<K,V> {

    private static final int upperTol = 10;
    private static final int lowerTol = 2;
    private static final int initCapacity = 7;

    private TreeMap<K,V>[] hashTable;
    private int M;
    private int size;

    public HashTable(int M){
        this.M = M;
        size = 0;
        hashTable = new TreeMap[M];
        for (int i = 0; i < M; i++) {
            hashTable[i] = new TreeMap<>();
        }
    }

    public HashTable(){
        this(initCapacity);
    }

    private int hash(K key){
        return (key.hashCode() & 0x7fffffff) % M;
    }

    public int getSize(){
        return size;
    }

    public void add(K key,V value){
        TreeMap<K,V> map = hashTable[hash(key)];
        if(map.containsKey(key)){
            map.put(key,value);
        }else {
            map.put(key,value);
            size ++;
            /**
             * 平均每个地址承载的元素多过一定的程度的时候，即扩容
             *  N / M >= upperTol 扩容
             */
            if (size >= upperTol * M)
                resize(2*M);
        }
    }

    public V remove(K key){
        TreeMap<K,V> map = hashTable[hash(key)];
        V ret = null;
        if (map.containsKey(key)){
            ret = map.remove(key);
            size --;
            /**
             * 平均每个地址承载的元素少过一定的程度的时候，即缩容
             *  N / M < lowerTol 缩容
             */
            if (size < lowerTol * M && M / 2 >= initCapacity)
                resize(M / 2);

        }
        return ret;
    }

    public void set(K key, V value){
        TreeMap<K,V> map = hashTable[hash(key)];
        if(!map.containsKey(key)){
            throw new IllegalArgumentException(key +" doesn't exist!");
        }
        map.put(key, value);
    }

    public boolean contains(K key){
        return hashTable[hash(key)].containsKey(key);
    }

    public V get(K key){
        return hashTable[hash(key)].get(key);
    }

    private void resize(int newM){
        TreeMap<K,V>[] newHashTable= new TreeMap[newM];
        for (int i = 0; i < newM; i++) {
            newHashTable[i] = new TreeMap<>();
        }
        /**
         * 在hash中有一个陷阱，因为hash函数中的的模M是对全局变量M取模
         * 所以在扩容或者缩容的过程当中需要提前将newM的值赋值给全局变量M
         */
        int oldM = M;
        this.M = newM;
        for (int i = 0; i < oldM; i++) {
            TreeMap<K,V> map = hashTable[i];
            for(K key:map.keySet()){
                newHashTable[hash(key)].put(key,map.get(key));
            }
        }
        this.hashTable = newHashTable;

    }



}
