package imooccache;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * 最简单的形式：HashMap
 */
public class ImoocCache1 {

    private final Map<String,Integer> cache = new HashMap<>();

    public synchronized Integer compute(String userId) throws InterruptedException {
        Integer result = cache.get(userId);
        //先检查HashMap中里面有没有保存过之前的计算结果
        if(result == null){
            //如果缓存中找不到，那么需要现在计算一下结构并且保存到HashMap中
            result = doCompute(userId);
            cache.put(userId,result);
        }
        return result;
    }

    public Integer doCompute(String userId) throws InterruptedException {
        TimeUnit.SECONDS.sleep(5);
        return new Integer(userId);
    }

    public static void main(String[] args) throws InterruptedException {
        ImoocCache1 imoocCache1 = new ImoocCache1();
        System.out.println("开始计算了");
        Integer result = imoocCache1.compute("13");
        System.out.println("第一次计算结果"+result);
        result = imoocCache1.compute("13");
        System.out.println("第二次计算结果"+result);
    }

}
