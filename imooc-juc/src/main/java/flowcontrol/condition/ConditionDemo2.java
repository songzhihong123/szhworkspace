package flowcontrol.condition;

import java.util.PriorityQueue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 *   用Condition实现生产者消费者模式
 */
public class ConditionDemo2 {

    private final int maxSize = 10;
    private PriorityQueue queue = new PriorityQueue<Integer>();
    private ReentrantLock lock = new ReentrantLock();
    private Condition notFull = lock.newCondition();
    private Condition isEmpty = lock.newCondition();


    public static void main(String[] args) {
        ConditionDemo2 demo2 = new ConditionDemo2();
        Consumer consumer = demo2.new Consumer();
        Provider provider = demo2.new Provider();
        provider.start();
        consumer.start();
    }
    class Consumer extends Thread{
        @Override
        public void run() {
            consume();
        }
        public void consume(){
            while(true){
                lock.lock();
                try{
                    while (queue.size() == 0){
                        System.out.println("队列空，等待提供数据!");
                        try {
                            isEmpty.await();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    queue.poll();
                    notFull.signalAll();
                    System.out.println("从队列里面取走一个数据，队列剩余"+(maxSize - queue.size())+"个元素");
                }finally {
                    lock.unlock();
                }
            }
        }
    }
    class Provider extends Thread{
        @Override
        public void run() {
            produce();
        }
        public void produce(){
            while(true){
                lock.lock();
                try{
                    while (queue.size() == maxSize){
                        System.out.println("队列满，等待消费数据!");
                        try {
                            notFull.await();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    queue.offer(1);
                    isEmpty.signalAll();
                    System.out.println("从队列里面插入一个数据，队列剩余空间"+queue.size()+"个元素");
                }finally {
                    lock.unlock();
                }
            }
        }
    }

}
