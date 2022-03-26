package collections.copyonwrite;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * 演示CopyOnWriteArrayList在迭代的过程中可以修改数组的内容，但是ArrList不可以
 */
public class CopyOnWriteArrayListDemo1 {

    public static void main(String[] args) {
//        ArrayList<String> list = new ArrayList();
        CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        list.add("5");

        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()){
            System.out.println("list is "+list);
            String next = iterator.next();
            System.out.println(next);
            if("2".equals(next)){
                list.remove("5");
            }
            if("3".equals(next)){
                list.add("3 found");
            }
        }

    }
}
