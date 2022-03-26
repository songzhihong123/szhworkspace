package com.wiggin.lock;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantLock;

public class MyReentrantLock extends Thread {

    TestReentrantLock testReentrantLock;
    private int id;

    public MyReentrantLock(TestReentrantLock testReentrantLock,int id){
        this.testReentrantLock = testReentrantLock;
        this.id = id;
    }

    @Override
    public void run() {
        testReentrantLock.print(id);
    }

    public static void main(String[] args){
        ExecutorService service = Executors.newCachedThreadPool();
        TestReentrantLock lock = new TestReentrantLock();
        for(int i=0;i<10;i++){
            service.submit(new MyReentrantLock(lock,i));
        }
        service.shutdown();
    }


    static class TestReentrantLock {
        private ReentrantLock reentrantLock = new ReentrantLock();

        public void print(int str){
            try{
                reentrantLock.lock();
                System.out.println(str+"获得");
                Thread.sleep((int)(Math.random()*1000));
            }catch (Exception e){
                e.printStackTrace();
            }finally {
                System.out.println(str+"释放");
                reentrantLock.unlock();
            }
        }
    }
}
