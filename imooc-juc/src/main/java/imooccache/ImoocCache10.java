package imooccache;

import imooccache.conputable.Computable;
import imooccache.conputable.MayFail;

import java.util.Map;
import java.util.concurrent.*;

/**
 *  缓存需要设置有效期，到期自动失效，如果缓存一直不失效，可能会导致缓存不一致的问题。
 */
public class ImoocCache10<A, V> implements Computable<A, V> {

    private final Map<A, Future<V>> cache = new ConcurrentHashMap<>();

    private Computable<A, V> c;

    public ImoocCache10(Computable<A, V> c) {
        this.c = c;
    }

    @Override
    public V compute(A arg) throws ExecutionException, InterruptedException {
        while (true) {
            Future<V> f = cache.get(arg);
            if (f == null) {
                Callable<V> callable = new Callable<V>() {
                    @Override
                    public V call() throws Exception {
                        return c.compute(arg);
                    }
                };
                FutureTask<V> futureTask = new FutureTask<>(callable);
                /**
                 * 关于putIfAbsent 的理解：
                 *      这个方法是本身是currentHashMap的原子组合操作，先判断有没有值，没有的话就直接放值，然后返回放值之前的key对应的value值
                 *      首先第一个线程放值并且返回null，当第二个线程去放值的时候会发现第一个线程已经放过值了那他就会自己返回一个futureTask，这个futureTask并不为null，
                 *      所以不执行if，直接去执行get()
                 *      FutureTask的get方法本身就会阻塞，知道计算出来值才会去取
                 */
                f = cache.putIfAbsent(arg, futureTask);
                if (f == null) {
                    f = futureTask;
                    System.out.println("从futureTask调用了计算函数");
                    futureTask.run();
                }
            }
            try {
                return f.get();
            } catch (CancellationException e) {
                System.out.println("被取消了");
                cache.remove(arg);
                throw e;
            } catch (InterruptedException e) {
                cache.remove(arg);
                throw e;
            } catch (ExecutionException e) {
                System.out.println("计算错误需要重试！");
                cache.remove(arg);
            }
        }
    }

    public static final ScheduledExecutorService service = Executors.newScheduledThreadPool(5);

    public V compute(A arg, long expire) throws ExecutionException, InterruptedException {
        if(expire > 0){
            service.schedule(new Runnable() {
                @Override
                public void run() {
                    expire(arg);
                }
            },expire,TimeUnit.MILLISECONDS);
        }
        return compute(arg);
    }
    private synchronized void expire(A arg){
        Future<V> future = cache.get(arg);
        if(future != null){
            if(!future.isDone()){
                System.out.println("Future任务被取消！");
                future.cancel(true);
            }
            System.out.println("过期时间到，缓存被清除!");
            cache.remove(arg);
        }
    }


    public static void main(String[] args) throws Exception {
        ImoocCache10<String, Integer> computer = new ImoocCache10<>(new MayFail());
        new Thread(() -> {
            try {
                Integer result = computer.compute("666",5000L);
                System.out.println("第一次计算结果是:" + result);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(() -> {
            try {
                Integer result = computer.compute("666");
                System.out.println("第三次计算结果是:" + result);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(() -> {
            try {
                Integer result = computer.compute("667");
                System.out.println("第二次计算结果是:" + result);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();

        Thread.sleep(6000);
        Integer result = computer.compute("666");
        System.out.println("主线程计算结果是:" + result);

    }

}
