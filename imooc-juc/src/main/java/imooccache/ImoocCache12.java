package imooccache;

import imooccache.conputable.Computable;
import imooccache.conputable.ExpensiveFunction;
import imooccache.conputable.MayFail;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.concurrent.*;


public class ImoocCache12{

    public static ImoocCache11<String,Integer> expensiveComputer = new ImoocCache11<>(new ExpensiveFunction());

    public static CountDownLatch latch = new CountDownLatch(1);

    public static void main(String[] args) throws InterruptedException {
        ExecutorService service = Executors.newFixedThreadPool(100);
        long start = System.currentTimeMillis();
        for (int i = 0; i < 100; i++) {
            service.submit(() -> {
                Integer result = null;
                try {
                    System.out.println(Thread.currentThread().getName()+"开始等待");
                    latch.await();
                    SimpleDateFormat format = ThreadSafeFormatter.dateFormater.get();
                    String time = format.format(new Date());
                    System.out.println(Thread.currentThread().getName()+"==="+time+"被放行");
                    result = expensiveComputer.compute("666");
                } catch (ExecutionException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(result);
            });
        }
        Thread.sleep(5000);
        latch.countDown();
        service.shutdown();
    }
}

class ThreadSafeFormatter{
    public static ThreadLocal<SimpleDateFormat> dateFormater = ThreadLocal.withInitial(() -> new SimpleDateFormat("mm:ss"));


}