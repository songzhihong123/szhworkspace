package sync;

import java.util.List;
import java.util.Vector;

public class SynchronizedTest4 {

    /**
     * 开启锁粗化  668ms
     * -server -XX:+DoEscapeAnalysis -XX:+EliminateLocks
     * 关闭锁粗化 822ms
     * -server -XX:-DoEscapeAnalysis -XX:-EliminateLocks
     */
    public static void main(String[] args){
        List<Integer> list = new Vector<>();
        long start = System.currentTimeMillis();
        for (int i = 0; i < 10000000; i++) {
            synchronized (list){
                list.add(i);
            }
        }
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }

}
