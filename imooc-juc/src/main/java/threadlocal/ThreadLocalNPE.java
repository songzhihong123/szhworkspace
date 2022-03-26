package threadlocal;

public class ThreadLocalNPE {

    ThreadLocal<Long> longThreadLocal = new ThreadLocal<>();


    public void set(){
        longThreadLocal.set(Thread.currentThread().getId());
    }

    public Long get(){
        return longThreadLocal.get();
    }
    public static void main(String[] args) {

        ThreadLocalNPE threadLocalNPE = new ThreadLocalNPE();
//        threadLocalNPE.set();
        System.out.println(threadLocalNPE.get());

        new Thread(() -> {
            threadLocalNPE.set();
            System.out.println(threadLocalNPE.get());
        }).start();
    }

}
