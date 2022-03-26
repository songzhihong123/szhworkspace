package atomic;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicLong;

/**
 * 演示高并发场景下，LongAdder 比 AtomicLong 性能好
 */
public class AtomicLongDemo {

    public static void main(String[] args) throws InterruptedException {
        AtomicLong atomicLong = new AtomicLong(0);
        ExecutorService service = Executors.newFixedThreadPool(20);
        long start = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            service.submit(new Task(atomicLong));
        }
        service.shutdown();
        while(!service.isTerminated()){

        }
        long end = System.currentTimeMillis();
        System.out.println(atomicLong.get());
        System.out.println("AtomicLong耗时："+(end - start));


    }

    public static class Task implements Runnable{
        AtomicLong atomicLong;

        public Task(AtomicLong atomicLong) {
            this.atomicLong = atomicLong;
        }

        @Override
        public void run() {
            for (int i = 0; i < 10000; i++) {
                atomicLong.getAndIncrement();
            }
        }
    }
}
