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
public class ImoocCache7<A,V> implements Computable<A,V> {

    private final Map<A, Future<V>> cache = new ConcurrentHashMap<>();

    private Computable<A,V> c;

    public ImoocCache7(Computable<A, V> c) {
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
            f = futureTask;
            cache.put(arg,futureTask);
            System.out.println("从futureTask调用了计算函数");
            futureTask.run();
        }
        return f.get();
    }


    public static void main(String[] args) throws Exception {
        ImoocCache7<String, Integer> computer = new ImoocCache7<>(new ExpensiveFunction());
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
