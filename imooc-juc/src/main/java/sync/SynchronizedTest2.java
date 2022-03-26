package sync;

public class SynchronizedTest2 {

    public static void main(String[] args){
        someMethod();
    }

    private static void someMethod(){
        Object object = new Object();
        synchronized (object){
            System.out.println(object);
        }
    }

}
