package com.mmall.concurrent.example.lock;

import com.google.common.collect.Maps;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;
import java.util.Set;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * ReentrantReadWriteLock的一大特性就是，在没有任何读写锁的时候才可以进行写操作
 */
@Slf4j
public class LockExample3 {

    private final Map<String,Data> map = Maps.newTreeMap();

    private  final ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

    private final Lock readLock = lock.readLock();

    private final Lock writeLock = lock.writeLock();

    public Data get(String key){
        readLock.lock();
        try{
            return map.get(key);
        }finally {
            readLock.unlock();
        }
    }

    public Set<String> getAllKeys(){
        readLock.lock();
        try{
            return map.keySet();
        }finally {
            readLock.unlock();
        }
    }

    public Data put(String key,Data value){
        writeLock.lock();
        try{
            return map.put(key,value);
        }finally {
            writeLock.unlock();
        }
    }

    class Data {

    }



}
