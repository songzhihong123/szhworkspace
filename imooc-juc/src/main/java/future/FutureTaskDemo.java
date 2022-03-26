package future;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.atomic.LongAccumulator;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * 演示FutureTask的用法.
 */
public class FutureTaskDemo {
    public static void main(String[] args) {
        Task task = new Task();
        FutureTask<Integer> integerFutureTask = new FutureTask<>(task);
        //new Thread(integerFutureTask).start();
        ExecutorService service = Executors.newCachedThreadPool();
        service.submit(integerFutureTask);
        try {
            Integer integer = integerFutureTask.get();
            System.out.println("========="+integer);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }finally {
            service.shutdown();
        }

    }

    static class Task implements Callable<Integer>{
        @Override
        public Integer call() throws Exception {
            System.out.println("子线程正在计算");
            Thread.sleep(3000);
            int sum = 0;
            System.out.println(IntStream.range(0, 101).toArray());
            return sum;
        }
    }
}
