package com.mmall.concurrent.example.singleton;

import com.mmall.concurrent.annoation.Recommend;
import com.mmall.concurrent.annoation.ThreadSafe;

/**
 * 枚举模式：最安全
 */
@ThreadSafe
@Recommend
public class SinglentonExample7 {

    //私有构造函数
    private SinglentonExample7(){

    }

    public static SinglentonExample7 getInstance(){
        return Singeton.INSTANCE.getInstance();
    }

    private enum Singeton{
        INSTANCE;

        private SinglentonExample7 singlenton;

        //JVM保证这个方法被调用一次绝对的
        Singeton() {
            singlenton = new SinglentonExample7();
        }

        public SinglentonExample7 getInstance(){
            return singlenton;
        }
    }

}
