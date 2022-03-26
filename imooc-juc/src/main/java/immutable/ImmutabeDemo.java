package immutable;

import java.util.HashSet;
import java.util.Set;

/**
 * 描述： 一个属性是对象，但是整体不可变，其他类无法修改set里面的数据.
 * 满足以下条件，对象才是不可变的
 * 1.对象创建之后，其状态就不能修改
 * 2.所有的属性都是final修饰的
 * 3.对象创建的过程当中没有发生溢出
 */
public class ImmutabeDemo {

    private final Set<String> students = new HashSet<>();

    public ImmutabeDemo(){
        students.add("lixiaomei");
        students.add("wangzhuang");
        students.add("xufuji");
    }

    public boolean isStudent(String name){
        return students.contains(name);
    }


    public static void main(String[] args) {
        ImmutabeDemo demo = new ImmutabeDemo();
        demo.students.add("12346");
        System.out.println(demo.students);
    }

}
