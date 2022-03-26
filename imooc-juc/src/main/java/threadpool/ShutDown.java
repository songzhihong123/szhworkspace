package threadpool;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * 描述：  演示关闭线程池
 */
public class ShutDown {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService =
                Executors.newFixedThreadPool(10);
        for (int i = 0; i < 100; i++) {
            executorService.execute(new ShutDownTask());
        }
        TimeUnit.MILLISECONDS.sleep(1500);

        //关闭线程池并且将在队列中的没有完成任务返回，之后为了程序的优雅性，可以选择比较轻的线程池去执行之后的任务
        List<Runnable> runnables = executorService.shutdownNow();




//        executorService.shutdown();
//        //这个是用来判断任务是否执行完，不饿关闭线程池没有任何的关系
//        boolean b = executorService.awaitTermination(7L, TimeUnit.SECONDS);
//        System.out.println(b);



//        System.out.println(executorService.isShutdown());
//        executorService.shutdown();
        //executorService.execute(new ShutDownTask());
        //虽然线程池停掉了，但是里面的任务还没有结束
//        System.out.println(executorService.isShutdown());
        //如果线程里面的任务没有结束，那么打印出来的永远都是false
//        System.out.println(executorService.isTerminated());
//        TimeUnit.SECONDS.sleep(10);
//        System.out.println(executorService.isTerminated());
    }
}

class ShutDownTask implements Runnable{
    @Override
    public void run() {
        try {
            TimeUnit.MILLISECONDS.sleep(500);
            System.out.println(Thread.currentThread().getName());
        } catch (InterruptedException e) {
            System.out.println(Thread.currentThread().getName()+"被中断了");
        }
    }
}