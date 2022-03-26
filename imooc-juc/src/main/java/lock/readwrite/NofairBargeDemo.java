package lock.readwrite;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/***
 * 插队：
 * 例子：
 *      线程2和线程4正在读取，线程三阻塞在队列里面，那么线程5要读进来了，要把他阻塞在队列里面
 * 公平锁结论：
 *      读锁写锁均不允许插队
 * 非公平锁结论：
 *      写锁是可以插队的，但是实质上他发现前面有读锁或者写锁的话是会自己阻塞到队列里面
 *      读锁仅在 等待队列列头结点不是想获取写锁的线程的时候可以插队，意思是如果队列里面是写锁不允许插入，如果是读锁是可以插队的
 */
public class NofairBargeDemo {

    private static ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock(true);
    private static ReentrantReadWriteLock.ReadLock readLock = readWriteLock.readLock();
    private static ReentrantReadWriteLock.WriteLock writeLock = readWriteLock.writeLock();

    private static void read(){
        System.out.println(Thread.currentThread().getName()+"开始尝试获取读锁");
        readLock.lock();
        try{
            System.out.println(Thread.currentThread().getName()+"获取读锁,正在读取....");
            Thread.sleep(20);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            System.out.println(Thread.currentThread().getName()+"释放读锁");
            readLock.unlock();
        }

    }

    private static void write(){
        System.out.println(Thread.currentThread().getName()+"开始尝试获取写锁");
        writeLock.lock();
        try{
            System.out.println(Thread.currentThread().getName()+"获取写锁,正在写入....");
            Thread.sleep(40);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            System.out.println(Thread.currentThread().getName()+"释放写锁");
            writeLock.unlock();
        }

    }

    public static void main(String[] args) {
        new Thread(NofairBargeDemo::write,"Thread1").start();
        new Thread(NofairBargeDemo::read,"Thread2").start();
        new Thread(NofairBargeDemo::read,"Thread3").start();
        new Thread(NofairBargeDemo::write,"Thread4").start();
        new Thread(NofairBargeDemo::read,"Thread5").start();
        new Thread(() -> {
            Thread[] threads = new Thread[1000];
            for (int i = 0; i < 1000; i++) {
                threads[i] = new Thread(NofairBargeDemo::read,"子线程创建的Thread"+i);
            }
            for (int i = 0; i < 1000; i++) {
                threads[i].start();
            }
        }).start();
    }
}
