package atomic;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicIntegerArray;

public class AtomicArrayDemo {

    public static void main(String[] args) {
        AtomicIntegerArray atomicIntegerArray = new AtomicIntegerArray(1000);
        Incrementer incrementer = new Incrementer(atomicIntegerArray);
        Decrementer decrementer = new Decrementer(atomicIntegerArray);
        Thread[] incrThreads = new Thread[100];
        Thread[] decrThreads = new Thread[100];
        for (int i = 0; i < 100; i++) {
            incrThreads[i] = new Thread(incrementer);
            decrThreads[i] = new Thread(decrementer);
            incrThreads[i].start();
            decrThreads[i].start();

        }
        for (int i = 0; i < 100; i++) {
            try {
                incrThreads[i].join();
                decrThreads[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        for (int i = 0; i < atomicIntegerArray.length(); i++) {
//            if(atomicIntegerArray.get(i) != 0){
//                System.out.println("发现了错误"+i);
//            }
            System.out.println(atomicIntegerArray.get(i));
        }
        System.out.println("运行结束!");

    }



}

class Decrementer implements Runnable{
    private AtomicIntegerArray array;
    public Decrementer(AtomicIntegerArray array) {
        this.array = array;
    }
    @Override
    public void run() {
        for (int i = 0; i < array.length(); i++) {
            array.getAndDecrement(i);
        }
    }
}

class Incrementer implements Runnable{
    private AtomicIntegerArray array;
    public Incrementer(AtomicIntegerArray array) {
        this.array = array;
    }
    @Override
    public void run() {
        for (int i = 0; i < array.length(); i++) {
            array.getAndIncrement(i);
        }
    }
}
