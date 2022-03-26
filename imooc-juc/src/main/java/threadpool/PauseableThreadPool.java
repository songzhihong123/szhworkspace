package threadpool;

import java.util.concurrent.*;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 演示每个任务的执行前后放钩子函数
 */
public class PauseableThreadPool extends ThreadPoolExecutor {

    private ReentrantLock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();
    private boolean isPause;

    public PauseableThreadPool(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue) {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue);
    }

    public PauseableThreadPool(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue, ThreadFactory threadFactory) {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue, threadFactory);
    }

    public PauseableThreadPool(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue, RejectedExecutionHandler handler) {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue, handler);
    }

    public PauseableThreadPool(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue, ThreadFactory threadFactory, RejectedExecutionHandler handler) {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue, threadFactory, handler);
    }

    @Override
    protected void beforeExecute(Thread t, Runnable r) {
        super.beforeExecute(t, r);
        lock.lock();
        try{
            while(isPause){
                condition.await();
            }
        }catch (InterruptedException ex){
            ex.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    private void pause(){
        lock.lock();
        try{
            isPause = true;
        }finally {
            lock.unlock();
        }
    }

    private void resume(){
        lock.lock();
        try{
            isPause = false;
            condition.signalAll();
        }finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        PauseableThreadPool pauseableThreadPool = new PauseableThreadPool(10,20,10,TimeUnit.SECONDS,new LinkedBlockingDeque<>());
        for (int i = 0; i < 10000; i++) {
            pauseableThreadPool.execute(() -> {
                System.out.println("我被执行了");
                try {
                    TimeUnit.MILLISECONDS.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
        TimeUnit.MILLISECONDS.sleep(1500);
        pauseableThreadPool.pause();
        System.out.println("线程池被暂停了");
        TimeUnit.MILLISECONDS.sleep(1500);
        pauseableThreadPool.resume();
        System.out.println("线程池恢复了");

    }

}
