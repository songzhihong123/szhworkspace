package lock.readwrite;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * ReentrantReadWriteLock
 * 一、允许插队
 * 二、允许降级，但是不允许升级(目前写锁可以去获得读锁，目前是读锁不可以获取写锁)
 */
public class CinemaReadWrite {
//    private static ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock(false);
    private static ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    private static ReentrantReadWriteLock.ReadLock readLock = readWriteLock.readLock();
    private static ReentrantReadWriteLock.WriteLock writeLock = readWriteLock.writeLock();

    private static void read(){
        readLock.lock();
        try{
            System.out.println(Thread.currentThread().getName()+"得到了读锁，正在读取..");
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            readLock.unlock();
            System.out.println(Thread.currentThread().getName()+"释放读锁");
        }
    }

    private static void write(){
        writeLock.lock();
        try{
            System.out.println(Thread.currentThread().getName()+"得到了写锁，正在写入...");
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            writeLock.unlock();
            System.out.println(Thread.currentThread().getName()+"释放写锁");
        }
    }

    public static void main(String[] args) {
       /* new Thread(CinemaReadWrite::write,"Thread1").start();
        new Thread(CinemaReadWrite::write,"Thread2").start();
        new Thread(CinemaReadWrite::read,"Thread3").start();
        new Thread(CinemaReadWrite::read,"Thread4").start();*/
        new Thread(CinemaReadWrite::write,"Thread1").start();
        new Thread(CinemaReadWrite::read,"Thread2").start();
        new Thread(CinemaReadWrite::read,"Thread3").start();
        new Thread(CinemaReadWrite ::write,"Thread4").start();
        new Thread(CinemaReadWrite::read, "Thread5").start();

    }

}
