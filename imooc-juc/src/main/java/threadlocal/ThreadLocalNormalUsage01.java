package threadlocal;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * 用十个线程分别打印日期
 */
public class ThreadLocalNormalUsage01 {

    public static void main(String[] args) throws InterruptedException {

        for (int i = 0; i < 30; i++) {
            int finalI = i;
            new Thread( () -> {
                String date = new ThreadLocalNormalUsage01().date(finalI);
                System.out.println(date);
            }).start();
            TimeUnit.MILLISECONDS.sleep(100);
        }

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
