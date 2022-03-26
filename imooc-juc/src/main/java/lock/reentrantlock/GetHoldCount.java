package lock.reentrantlock;

import java.util.concurrent.locks.ReentrantLock;

public class GetHoldCount {
    private static ReentrantLock lock = new ReentrantLock();

    public static void main(String[] args) {
        //获取多少次锁
        System.out.println(lock.getHoldCount());
        lock.lock();
        System.out.println(lock.getHoldCount());
        lock.lock();
        System.out.println(lock.getHoldCount());
        lock.lock();
        System.out.println(lock.getHoldCount());
        lock.unlock();
        System.out.println(lock.getHoldCount());
        lock.unlock();
        System.out.println(lock.getHoldCount());
        lock.unlock();
        System.out.println(lock.getHoldCount());
    }

}
