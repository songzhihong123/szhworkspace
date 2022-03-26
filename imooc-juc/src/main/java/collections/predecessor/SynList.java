package collections.predecessor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Collections.synchronizedList(new ArrayList<>());
 */
public class SynList {

    public static void main(String[] args) {
        List<Integer> list = Collections.synchronizedList(new ArrayList<>());
        list.add(500);
        System.out.println(list.get(0));
    }

}
