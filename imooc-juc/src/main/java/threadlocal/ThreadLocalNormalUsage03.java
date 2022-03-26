package threadlocal;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *  1000个打印日期的任务，用线程池来执行
 *  将SimpleDateFormat对象申明为静态变量，出现线层安全问题【这里不加volatile关键字，加上就好了，我不知道为啥不加】
 *  解释：因为 SimpleDateFormat 自身是非线程安全的，所以加上volatile并不能解决问题
 */
public class ThreadLocalNormalUsage03 {
    static ExecutorService threadPool = Executors.newFixedThreadPool(10);
    /*volatile*/ static SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
    public static void main(String[] args) throws InterruptedException {

        for (int i = 0; i < 1000; i++) {
            int finalI = i;
            threadPool.submit(() -> {
                String date = new ThreadLocalNormalUsage03().date(finalI);
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
        return format.format(date);
    }


}
