package lock.lock;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 乐观锁和悲观锁
 */
public class PessimisOptimismLock {

    int a;

    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger();
        atomicInteger.incrementAndGet();
    }

    public synchronized  void testMethon(){
        a++;
    }



}
