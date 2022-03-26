package threadlocal;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *  1000个打印日期的任务，用线程池来执行
 *  加锁解决线程安全问题
 */
public class ThreadLocalNormalUsage04 {
    static ExecutorService threadPool = Executors.newFixedThreadPool(10);
    static SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 1000; i++) {
            int finalI = i;
            threadPool.submit(() -> {
                String date = new ThreadLocalNormalUsage04().date(finalI);
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
        String format = null;
        synchronized (ThreadLocalNormalUsage04.class) {
            format = ThreadLocalNormalUsage04.format.format(date);
        }
        return format;
    }


}
