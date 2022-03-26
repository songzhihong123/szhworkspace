package atomic;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.LongAdder;

/**
 * 演示高并发场景下，LongAdder 比 AtomicLong 性能好
 */
public class LongAdderDemo {

    public static void main(String[] args) throws InterruptedException {
        LongAdder atomicLong = new LongAdder();
        ExecutorService service = Executors.newFixedThreadPool(20);
        long start = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            service.submit(new Task(atomicLong));
        }
        service.shutdown();
        while(!service.isTerminated()){

        }
        long end = System.currentTimeMillis();
        System.out.println(atomicLong.sum());
        System.out.println("LongAdder耗时："+(end - start));


    }

    public static class Task implements Runnable{
        LongAdder longAdder;

        public Task(LongAdder longAdder) {
            this.longAdder = longAdder;
        }

        @Override
        public void run() {
            for (int i = 0; i < 10000; i++) {
                longAdder.increment();
            }
        }
    }
}
