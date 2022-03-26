package lock.reentrantlock;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 演示公平和不公平两种情况
 */
public class FairLock {

    public static void main(String[] args) {
     PrintQueue printQueue = new PrintQueue();
     Thread[] threads = new Thread[10];
        for (int i = 0; i < 10; i++) {
            threads[i] = new Thread(new Job(printQueue));
        }
        Arrays.stream(threads).forEach(thread -> {
            thread.start();
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
    }
}

class Job implements Runnable{

    private  PrintQueue printQueue;
    public Job(PrintQueue printQueue){
        this.printQueue = printQueue;
    }
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+"开始打印");
        printQueue.printJob(new Object());
        System.out.println(Thread.currentThread().getName()+"打印完毕");
    }
}

/**
 * 公平：当一个线程执行玩一个任务之后就算发现下一个任务还是它自己的话，也会释放锁，和其他线程抢夺这一把锁，谁抢到谁用。
 * 不公平:当线程一执行完一个任务之后发现在下一个任务还需要用到这个吧锁，她就会执行玩第二个任务释放锁。
 */
class PrintQueue{
    private Lock queueLock = new ReentrantLock(false);

    public void printJob(Object document){
        queueLock.lock();
        try{
            int duration = new Random().nextInt(5);
            System.out.println(Thread.currentThread().getName()+"正在打印，需要 "+duration+"秒");
            Thread.sleep(duration*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            queueLock.unlock();
        }

        queueLock.lock();
        try{
            int duration = new Random().nextInt(5);
            System.out.println(Thread.currentThread().getName()+"正在打印，需要 "+duration+"秒");
            Thread.sleep(duration*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            queueLock.unlock();
        }

    }
}


