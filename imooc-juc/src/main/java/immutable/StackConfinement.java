package immutable;

import java.util.stream.IntStream;

/**
 * 栈封闭 演示两种情况，基本变量和对象
 *      先演示线程争抢带来的错误结果，然后把变量放到方法内，情况就变了
 */
public class StackConfinement implements Runnable{

    int index = 0;

    /**
     * 在方法里面面新建的局部变量，实际上是储存在每个线程私有的栈空间，
     * 而每个栈占的空间是不能被其他线程锁访问到的，所以不会有线程安全问题。
     * 这就是著名的“栈封闭” 技术，是“线程封闭”技术的一种情况.
     */
    public void inThread(){
        int neverGoOut = 0;
        for (int i = 0; i < 10000; i++) {
            neverGoOut++;
        }
        System.out.println(Thread.currentThread().getName()+"栈内保护的数字是线程安全的："+ neverGoOut);
    }

    @Override
    public void run() {
        IntStream.range(0,10000).forEach(i -> index ++);
        inThread();
    }

    public static void main(String[] args) throws InterruptedException {
        StackConfinement r = new StackConfinement();
        Thread t1 = new Thread(r);
        Thread t2 = new Thread(r);
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(r.index);

    }
}
