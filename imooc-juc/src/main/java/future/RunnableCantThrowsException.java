package future;

import java.util.concurrent.Future;

/**
 * Runnable 两大缺陷：
 *      1、在run方法中无法抛出checked Exception
 *      2、没有返回值
 */
public class RunnableCantThrowsException {


    public void ddd() throws Exception{

    }

    public static void main(String[] args) {
        Runnable runnable = () -> {
            try {
                throw new Exception();
            } catch (Exception e) {
                e.printStackTrace();
            }
        };
    }

}
