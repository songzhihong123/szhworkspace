package threadlocal;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 *  1000个打印日期的任务，用线程池来执行
 */
public class ThreadLocalNormalUsage02 {
    static ExecutorService threadPool = Executors.newFixedThreadPool(10);
    public static void main(String[] args) throws InterruptedException {

        for (int i = 0; i < 1000; i++) {
            int finalI = i;
            threadPool.submit(() -> {
                String date = new ThreadLocalNormalUsage02().date(finalI);
                System.out.println(date);
            });
        }
        threadPool.shutdown();
    }

    /**
     * 把秒转化为字符串.
     * @param seconds
     * @return
     */
    public String date(int seconds){
        //参数的单位
        Date date = new Date(1000*seconds);
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        return format.format(date);
    }


}
