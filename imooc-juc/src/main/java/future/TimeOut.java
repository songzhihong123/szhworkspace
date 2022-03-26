package future;

import java.util.concurrent.*;

/**
 * 演示get的超时方法，需要注意超时后的如何处理，调用future.cancel().演示cancel传入的true和false的区别代表的时候是否中断正在执行的任务
 */
public class TimeOut {

    private static final Ad DEAULT_ID = new Ad("无网络时候默认的广告");
    private static final ExecutorService service = Executors.newFixedThreadPool(10);

    static class Ad{
        String name;
        public Ad(String name){
            this.name = name;
        }

        @Override
        public String toString() {
            return "Ad{" +
                    "name='" + name + '\'' +
                    '}';
        }
    }

    static class FathchAdTask implements Callable<Ad>{
        @Override
        public Ad call() throws Exception {
            try{
                Thread.sleep(3000);
            }catch (InterruptedException e){
                System.out.println("sleep期间被中断了");
                return new Ad("被中断的默认广告");
            }
            return new Ad("旅游订票哪家强，找某程");
        }
    }

    public void printAd(){
        Future<Ad> future = service.submit(new FathchAdTask());
        Ad ad;
        try {
            ad = future.get(2,TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            ad = new Ad("被中断时候的默认广告!");
        } catch (ExecutionException e) {
            ad = new Ad("异常时候的默认广告!");
        } catch (TimeoutException e) {
            ad = new Ad("超时的默认广告!");
            System.out.println("超时，为获取到广告");
            // 传入参数为是说如果任务正在执行我们是否需要打断任务。
            //false : 不中断
            //true : 中断
            boolean cancel = future.cancel(true);
            System.out.println("cancel的结果："+cancel);
        }
        service.shutdown();
        System.out.println(ad);
    }

    public static void main(String[] args) {
        TimeOut timeOut = new TimeOut();
        timeOut.printAd();
    }

}
