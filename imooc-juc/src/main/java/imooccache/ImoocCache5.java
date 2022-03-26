package imooccache;

import imooccache.conputable.Computable;
import imooccache.conputable.ExpensiveFunction;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 *  使用现有的并发工具类  ConcurrentHashMap
 */
public class ImoocCache5<A,V> implements Computable<A,V> {
    private final Map<A,V> cache = new ConcurrentHashMap<>();

    private Computable<A,V> c;

    public ImoocCache5(Computable<A, V> c) {
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
        ImoocCache5<String, Integer> computer = new ImoocCache5<>(new ExpensiveFunction());
        Integer result = computer.compute("666");
        System.out.println("第一次计算结果: "+result);
        result = computer.compute("666");
        System.out.println("第二次计算结果是:"+result);
    }

}
