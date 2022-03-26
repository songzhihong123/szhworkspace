package threadlocal;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *  1000个打印日期的任务，用线程池来执行
 *  利用ThreadLocal给每个线程分配自己的DateFomrmat对象，保证了线程安全，高效的利用内存
 */
public class ThreadLocalNormalUsage05 {
    static ExecutorService threadPool = Executors.newFixedThreadPool(10);
    public static void main(String[] args) throws InterruptedException {

        for (int i = 0; i < 1000; i++) {
            int finalI = i;
            threadPool.submit(() -> {
                String date = new ThreadLocalNormalUsage05().date(finalI);
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
        //SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        SimpleDateFormat format = ThreadSafeFormatter.dateFormatThreadLocal2.get();
        return format.format(date);
    }
}

class ThreadSafeFormatter {
    public static ThreadLocal<SimpleDateFormat> dateFormatThreadLocal = new ThreadLocal<SimpleDateFormat>(){
        @Override
        protected SimpleDateFormat initialValue() {
            return new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        }
    };
    public static ThreadLocal<SimpleDateFormat> dateFormatThreadLocal2 = ThreadLocal.withInitial(() -> new SimpleDateFormat("yyyy-MM-dd hh:mm:ss"));

}
