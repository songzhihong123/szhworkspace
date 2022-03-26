package imooccache;

import imooccache.conputable.Computable;
import imooccache.conputable.ExpensiveFunction;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 *  使用现有的并发工具类  ConcurrentHashMap
 *  会发生重复计算的行为
 */
public class ImoocCache6<A,V> implements Computable<A,V> {

    private final Map<A,V> cache = new ConcurrentHashMap<>();

    private Computable<A,V> c;

    public ImoocCache6(Computable<A, V> c) {
        this.c = c;
    }

    @Override
    public  V compute(A arg) throws Exception {
        System.out.println("进入缓存机制...");
        V result = cache.get(arg);
        if(result == null){
            result = c.compute(arg);
            cache.put(arg,result);
        }
        return result;
    }

    public static void main(String[] args) throws Exception {
        ImoocCache6<String, Integer> computer = new ImoocCache6<>(new ExpensiveFunction());
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
