package collections.queue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * put take : 取值放值会阻塞
 * add remove element : 取值取不到或者放值放不进去就会抛出异常
 * offer poll peek : 取值取不到会返回一个null,放值放不进去会返回一个boolean类型的false。
 *                   另外：poll会在取出值的时候删除元素，peek只会取出来不会把元素删除。
 */
public class ArrayBlockingQueueDemo {

    public static void main(String[] args) {
        ArrayBlockingQueue<String> queue = new ArrayBlockingQueue<>(3);
        Interviewer provider = new Interviewer(queue);
        Consumer consumer = new Consumer(queue);
        new Thread(provider).start();
        new Thread(consumer).start();


    }


}

class Interviewer implements Runnable{
    BlockingQueue<String> queue;
    Interviewer(BlockingQueue queue){
        this.queue = queue;
    }

    @Override
    public void run() {
        System.out.println("10个候选人都来了");
        for (int i = 0; i < 10; i++) {
            String candidate = "Candidate"+i;
            try {
                queue.put(candidate);
                System.out.println("安排好了"+candidate);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        try {
            queue.put("stop");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class Consumer implements Runnable{
    BlockingQueue<String> queue;
    Consumer(BlockingQueue queue){
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String msg;
        try {
            while(!(msg = queue.take()).equals("stop")){
                System.out.println(msg+"到了");
            }
            System.out.println("所有候选人全部结束");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}