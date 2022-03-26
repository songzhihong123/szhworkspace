package threadlocal;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 用两个线程分别打印日期
 */
public class ThreadLocalNormalUsage00 {

    public static void main(String[] args) {
        new Thread( () -> {
            String date = new ThreadLocalNormalUsage00().date(10);
            System.out.println(date);
        }).start();

        new Thread( () -> {
            String date = new ThreadLocalNormalUsage00().date(10007);
            System.out.println(date);
        }).start();

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
