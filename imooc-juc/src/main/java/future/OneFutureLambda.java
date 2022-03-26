package future;

import java.util.Random;
import java.util.concurrent.*;

/**
 * 演示一个Future的用法,用Lambda的形式
 */
public class OneFutureLambda {

    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(10);
        Future<Integer> future = service.submit(() -> {
                Thread.sleep(3000);
                return new Random().nextInt();
        });
        try {
            System.out.println(future.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        service.shutdown();
    }


}
