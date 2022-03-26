package collections.predecessor;

import java.util.Hashtable;
import java.util.Map;

public class HashtableDemo {

    public static void main(String[] args) {
        Map<String, String> table = new Hashtable<>();
        table.put("1","123");
        System.out.println(table.get("1"));
    }

}
