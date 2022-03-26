package com.song.simple;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * Created by Zhihong Song on 2021/3/23 15:53
 */

public class _706 {



    public class MyHashMap {

        private class Pair{
            private int key;
            private int value;

            public Pair(int key, int value){
                this.key =  key;
                this.value = value;
            }

            public int getKey() {
                return key;
            }

            public void setKey(int key) {
                this.key = key;
            }

            public int getValue() {
                return value;
            }

            public void setValue(int value) {
                this.value = value;
            }
        }


        private int BASE = 965;
        private LinkedList[] linkedList;

        public MyHashMap() {
            linkedList = new LinkedList[BASE];
            for (int i = 0; i < BASE; i++) {
                linkedList[i] = new LinkedList<Pair>();
                
            }
        }

        /** value will always be non-negative. */
        public void put(int key, int value) {
            int hashKey = hash(key);
            Iterator<Pair> iterator = linkedList[hashKey].iterator();
            while(iterator.hasNext()){
                Pair pair = iterator.next();
                if(pair.getKey() == key){
                    pair.setValue(value);
                    return;
                }
            }
            linkedList[hashKey].offerLast(new Pair(key,value));
        }

        /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
        public int get(int key) {
            int hashKey = hash(key);
            Iterator<Pair> iterator = linkedList[hashKey].iterator();
            while(iterator.hasNext()){
                Pair pair = iterator.next();
                if(pair.getKey() == key){
                    return pair.getValue();
                }
            }
            return -1;
        }

        /** Removes the mapping of the specified value key if this map contains a mapping for the key */
        public void remove(int key) {
            int hashKey = hash(key);
            Iterator<Pair> iterator = linkedList[hashKey].iterator();
            while(iterator.hasNext()){
                Pair pair = iterator.next();
                if(pair.getKey() == key){
                    linkedList[hashKey].remove(pair);
                    return;
                }
            }
        }

        public int hash(int key){
            return key % BASE;
        }
    }



}
