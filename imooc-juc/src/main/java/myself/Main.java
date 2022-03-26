package myself;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {

    public static void main(String[] args) {

        List<Future<Integer>> target = new ArrayList<>();

        //list 里面有很多百万+ 的数据，需要插入到数据库里面
        List<String> list = new ArrayList<>();

        //计划创建1000个线程去执行插入数据的操作
        int nThread = 50;
        ExecutorService service = Executors.newFixedThreadPool(nThread);

        // 拆分 list
        //....


        for (int i = 0; i < nThread; i++) {
            Callable<Integer> task = () -> {
                //insert option
                return -1;
            };
            target.add(service.submit(task));
        }
        service.shutdown();
    }



}
