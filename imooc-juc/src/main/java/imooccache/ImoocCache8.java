package imooccache;

import imooccache.conputable.Computable;
import imooccache.conputable.ExpensiveFunction;

import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

/**
 *  利用Future，避免重复计算
 */
public class ImoocCache8<A,V> implements Computable<A,V> {

    private final Map<A, Future<V>> cache = new ConcurrentHashMap<>();

    private Computable<A,V> c;

    public ImoocCache8(Computable<A, V> c) {
        this.c = c;
    }

    @Override
    public  V compute(A arg) throws Exception{
        Future<V> f = cache.get(arg);
        if(f == null){
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
            f = cache.putIfAbsent(arg,futureTask);
            if(f == null){
                f = futureTask;
                System.out.println("从futureTask调用了计算函数");
                futureTask.run();
            }
        }
        return f.get();
    }


    public static void main(String[] args) throws Exception {
        ImoocCache8<String, Integer> computer = new ImoocCache8<>(new ExpensiveFunction());
        new Thread(() -> {
            try {
                Integer result = computer.compute("666");
                System.out.println("第一次计算结果是:"+result);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(() -> {
            try {
                Integer result = computer.compute("666");
                System.out.println("第三次计算结果是:"+result);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(() -> {
            try {
                Integer result = computer.compute("667");
                System.out.println("第二次计算结果是:"+result);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();
    }

}
