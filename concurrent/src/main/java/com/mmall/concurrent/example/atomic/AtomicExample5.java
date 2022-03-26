package com.mmall.concurrent.example.atomic;

import com.mmall.concurrent.annoation.ThreadSafe;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReference;

@ThreadSafe
public class AtomicExample5 {

    public static Logger LOOGER = LoggerFactory.getLogger(AtomicExample5.class);

    //fieldName 要求必须是volatile修饰的而且是非static修饰的
    public static AtomicIntegerFieldUpdater<AtomicExample5> updater =
            AtomicIntegerFieldUpdater.newUpdater(AtomicExample5.class,"count");

    public volatile int count = 100;



    public int getCount(){
        return count;
    }

    public static void main(String[] args) {
        AtomicExample5 example5 = new AtomicExample5();
        if(updater.compareAndSet(example5,100,120)){
            LOOGER.info("update success1,{}",example5.getCount());
        }
        if(updater.compareAndSet(example5,100,120)){
            LOOGER.info("update success2,{}",example5.getCount());
        }else{
            LOOGER.info("update failed,{}",example5.getCount());
        }

    }


}
