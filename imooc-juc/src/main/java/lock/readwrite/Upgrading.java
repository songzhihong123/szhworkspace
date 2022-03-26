package lock.readwrite;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 锁升级.
 */
public class Upgrading {
    private static ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock(false);
    private static ReentrantReadWriteLock.ReadLock readLock = readWriteLock.readLock();
    private static ReentrantReadWriteLock.WriteLock writeLock = readWriteLock.writeLock();

    private static void readUpgrading(){
        readLock.lock();
        try{
            System.out.println(Thread.currentThread().getName()+"得到了读锁，正在读取..");
            Thread.sleep(1000);
            System.out.println(Thread.currentThread().getName()+"升级会带来阻塞 ");
            writeLock.lock();
            System.out.println(Thread.currentThread().getName()+"获取到了写锁，升级成功!");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            writeLock.unlock();
            readLock.unlock();
            System.out.println(Thread.currentThread().getName()+"释放读锁");
        }
    }

    private static void writeDowngrading(){
        writeLock.lock();
        try{
            System.out.println(Thread.currentThread().getName()+"得到了写锁，正在写入...");
            Thread.sleep(1000);
            System.out.println("");
            readLock.lock();
            System.out.println(Thread.currentThread().getName()+"在不释放写锁的的情况下获取到了读锁，降级成功");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            readLock.unlock();
            System.out.println(Thread.currentThread().getName()+"释放读锁");
            writeLock.unlock();
            System.out.println(Thread.currentThread().getName()+"释放写锁");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        System.out.println("演示降级是可以的");
        Thread thread1 = new Thread(Upgrading::writeDowngrading, "Thread1");
        thread1.start();
        thread1.join();
        System.out.println("--------------------------------------");
        System.out.println("演示升级级是不可以的");
        new Thread(Upgrading::readUpgrading,"Thread2").start();
    }

}
