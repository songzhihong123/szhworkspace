package atomic;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntegerDemo2 implements Runnable{
    private static AtomicInteger atomicInteger = new AtomicInteger();
    private static int a = 0;
    public static void main(String[] args) {
        AtomicIntegerDemo2 demo2 = new AtomicIntegerDemo2();
        Thread[] threads = new Thread[10000];
        for (int i = 0; i < 10000; i++) {
            threads[i] = new Thread(demo2);
            threads[i].start();
        }

        for (int i = 0; i < threads.length; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(atomicInteger.get());
        System.out.println(a);

    }

    @Override
    public void run() {
        a++;
        atomicInteger.getAndIncrement();
    }
}
