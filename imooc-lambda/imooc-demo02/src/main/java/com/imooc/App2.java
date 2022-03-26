package com.imooc;

/**
 * @description:
 * @author: szh
 * @create: 2021-06-04 17:16
 **/
public class App2 {

    String s1 = "全局变量";

    // 1.匿名内部类中对于变量的控制
    public void testInnerClass(){
        String s2 = "局部变量";

        new Thread(new Runnable() {
            String s3 = "内部变量";
            @Override
            public void run() {
                // 访问全局变量
//                System.out.println(this.s1);
                System.out.println(s1);

                System.out.println(s2);
//                s2 = "hello";

                System.out.println(s3);
                System.out.println(this.s3);
            }
        }).start();
    }

    // 2.lambda 表达式变量捕获
    public void testLambda(){
        String s2 = "局部变量";

        new Thread(() -> {
            String s3 = "内部变量";
            // 访问全局变量
            // this关键字，表示的就是所属方法所在类型的对象
            // lambda 不在单独建立对象作用域
            System.out.println(this.s1);
            System.out.println(s1);
            //访问局部变量
            System.out.println(s2);
            // 不能进行数据修改，默认推导变量的修饰符：final
//            s2 = "hello";
            System.out.println(s3);
            s3 = "lambda 内部变量直接修改";
            System.out.println(s3);

        }).start();
    }


    public static void main(String[] args) {
        App2 app2 = new App2();
//        app2.testInnerClass();
        System.out.println();
        app2.testLambda();

    }

}
