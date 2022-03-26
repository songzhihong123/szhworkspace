package immutable;

public class FinalVariableDemo {

    //一、
    //private final int a = 5;

    //二、
//    private final int a;
//    public FinalVariableDemo(int a) {
//        this.a = a;
//    }

    //三、
//    private final int a;
//    {
//        a = 5;
//    }



      //一、
//    private static final int a = 7;

    //二、
//    private static final int a;
//    static {
//        a = 7;
//    }

    //方法中的final变量不要求赋值时机，只要求在使用之前必须赋值。
    void testFinal(){
        final int b;

        b = 5;
        int c = b;

    }


}
