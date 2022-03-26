package collections.concurrenthashmap;

import java.util.concurrent.ConcurrentHashMap;

public class OptionsNotSafe implements Runnable{

    private static  ConcurrentHashMap<String,Integer> socres = new ConcurrentHashMap<>();

    public static void main(String[] args) throws InterruptedException {
        socres.put("小明",0);
        OptionsNotSafe optionsNotSafe = new OptionsNotSafe();
        Thread t1 = new Thread(optionsNotSafe);
        Thread t2 = new Thread(optionsNotSafe);

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println(socres);

    }

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            while (true){
                Integer score = socres.get("小明");
                Integer newScore = score + 1;
                boolean b = socres.replace("小明", score, newScore);
                if(b){
                    break;
                }
            }

        }
    }
}
