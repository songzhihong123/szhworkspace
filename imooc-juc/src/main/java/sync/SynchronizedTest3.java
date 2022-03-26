package sync;

public class SynchronizedTest3 {

    private Object object2 = null;

    public  void someMethod2(){
        this.object2 = someMethod();
    }

    private Object someMethod(){
        Object object = new Object();
        synchronized (object){
            return object;
        }
    }

}
