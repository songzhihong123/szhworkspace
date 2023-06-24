package lock.lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * a++ 处理
 */

public class Test{

    static  int a ;

    static AtomicInteger atomicInteger = new AtomicInteger(0);

    public static void main(String[] args) throws InterruptedException {
//        AtomicInteger atomicInteger = new AtomicInteger();
//        atomicInteger.incrementAndGet();

        Runnable runnable = () -> {

            for (int i = 0 ;i < 100 ; i ++){
//                a ++;
                atomicInteger.incrementAndGet();
                try {
                    Thread.sleep(30);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            System.out.println(atomicInteger.get());
        };

        new Thread(runnable).start();
        new Thread(runnable).start();


    }


}
