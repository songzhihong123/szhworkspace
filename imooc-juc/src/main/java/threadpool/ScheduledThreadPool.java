package threadpool;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduledThreadPool {
    public static void main(String[] args) {
        ScheduledExecutorService scheduledExecutorService =
                Executors.newScheduledThreadPool(10);
//        scheduledExecutorService.schedule(new Task(),5, TimeUnit.SECONDS);
        scheduledExecutorService.scheduleAtFixedRate(new PrintTask(),1,3,TimeUnit.SECONDS);
        //scheduledExecutorService.scheduleWithFixedDelay()
    }
}


class PrintTask implements Runnable{

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "########");
    }
}

