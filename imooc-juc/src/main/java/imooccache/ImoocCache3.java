package imooccache;

import imooccache.conputable.Computable;
import imooccache.conputable.ExpensiveFunction;

import java.util.HashMap;
import java.util.Map;

/**
 * 用装饰者模式，给计算器自动添加缓存功能
 * 多线程环境下，会有其他线程被阻塞在 被synchronized 修饰的外面
 */
public class ImoocCache3<A,V> implements Computable<A,V> {
    private final Map<A,V> cache = new HashMap<>();

    private Computable<A,V> c;

    public ImoocCache3(Computable<A, V> c) {
        this.c = c;
    }

    @Override
    public synchronized V compute(A arg) throws Exception {
        System.out.println("进入缓存机制...");
        V result = cache.get(arg);
        if(result == null){
            result = c.compute(arg);
            cache.put(arg,result);
        }
        return result;
    }

    public static void main(String[] args) throws Exception {
        ImoocCache3<String, Integer> computer = new ImoocCache3<>(new ExpensiveFunction());
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
