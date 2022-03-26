package atomic;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/**
 *  演示AtomicIntegerFieldUpdater的用法
 *  局限：
 *      1.可见范围
 *      2.不支持static
 */
public class AtomicIntegerFieldUpdaterDemo implements Runnable{

    static  Candidate tom;
    static Candidate peter;

    public static AtomicIntegerFieldUpdater<Candidate> scoreUpdater = AtomicIntegerFieldUpdater.newUpdater(Candidate.class,"score");

    @Override
    public void run() {
        for (int i = 0; i < 10000; i++) {
            peter.score ++ ;
            scoreUpdater.getAndIncrement(tom);
        }
    }
    static class Candidate{
        volatile int score;
    }
    public static void main(String[] args) throws InterruptedException {
        tom = new Candidate();
        peter = new Candidate();
        AtomicIntegerFieldUpdaterDemo demo = new AtomicIntegerFieldUpdaterDemo();
        Thread thread1 = new Thread(demo);
        Thread thread2 = new Thread(demo);
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        System.out.println("普通的变量"+peter.score);
        System.out.println("升级后的结果"+tom.score);
    }



}
