package lock.reentrantlock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 演示多线程预订电影院座位
 */
public class CinemaBookSeat {

    private static ReentrantLock lock = new ReentrantLock();

    private static void bookSeat(){
        lock.lock();
        try{
            System.out.println(Thread.currentThread().getName()+"开始预订座位!");
            Thread.sleep(1000);
            System.out.println(Thread.currentThread().getName()+"完成预订座位!");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        new Thread(CinemaBookSeat::bookSeat).start();
        new Thread(CinemaBookSeat::bookSeat).start();
        new Thread(CinemaBookSeat::bookSeat).start();
        new Thread(CinemaBookSeat::bookSeat).start();

    }


}
