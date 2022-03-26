package com.imooc;

import com.imooc.impl.MessageFormatImpl;
import com.imooc.impl.UserCredentialImpl;

import java.util.UUID;
import java.util.function.*;

/**
 * Hello world!
 * 需求改动，可以同时获取用户的验证信息
 */
public class App 
{
    public static void main( String[] args )
    {

//        IUserCredential ic = new UserCredentialImpl();
//        System.out.println(ic.verifyUser("admin"));
//        System.out.println(ic.getCredential("admin"));
//
//
//
//        String msg = "hello , word";
//        if(IMessageFormat.verifyMesage(msg)){
//            IMessageFormat messageFormat = new MessageFormatImpl();
//            messageFormat.format("hello","json");
//        }
//
//        // 匿名内部类
//        IUserCredential ic2 = new IUserCredential() {
//            @Override
//            public String verifyUser(String username) {
//                return "admin".equals(username) ? "管理员":"会员";
//            }
//        };
//        System.out.println(ic2.verifyUser("admin"));
//        System.out.println(ic2.getCredential("admin"));
//
//        // lambda
//        IUserCredential ic3 = (username) ->{return "admin".equals(username) ? "管理员":"会员";};
//
//        System.out.println(ic3.verifyUser("admin"));

        /*Predicate<String> pre = (username) -> {return "admin".equals(username);};
        System.out.println(pre.test("manage"));
        System.out.println(pre.test("admin"));

        Consumer<String> consumer = (message) -> {
            System.out.println("发送的消息：" + message);
        };
        consumer.accept("imooc");

        Function<String,Integer> fun = (gender) -> {
            return "male".equals(gender) ? 1 : 0;
        };
        System.out.println(fun.apply("male"));

        Supplier<String> sup = () -> {
            return UUID.randomUUID().toString();
        };
        System.out.println(sup.get());

        UnaryOperator<String> uo = (img) -> {
            img += "[100x200]";
            return img;
        };
        System.out.println(uo.apply("123.jpg"));

        BinaryOperator<Integer> bo = (Integer i1 , Integer i2) -> {
          return i1 > i2 ? i1 : i2;
        };
        System.out.println(bo.apply(12, 13));*/

        /**
         *   java.util.function提供了大量的函数式接口
         *         Predicate 接收参数T对象，返回一个boolean类型结果
         *         Consumer 接收参数T对象，没有返回值
         *         Function 接收参数T对象，返回R对象
         *         Supplier 不接受任何参数，直接通过get()获取指定类型的对象
         *         UnaryOperator 接口参数T对象，执行业务处理后，返回更新后的T对象
         *         BinaryOperator 接口接收两个T对象，执行业务处理后，返回一个T对象
         **/
        ILambda1 i1 = () -> {
            System.out.println("hello");
        };
        i1.test();

        ILambda1 i2 = () -> System.out.println("hello imooc");
        i2.test();

        ILambda2 i21 = (n ,a) -> {
            System.out.println(n + "say , my age is "+ a);
        };
        i21.test("jerry", 18);

        ILambda3 i3 = (x ,y) -> {return x + y;};
        System.out.println(i3.test(21, 22));

        ILambda3 i32 = (x ,y) -> x + y ;
        System.out.println(i32.test(33, 11));

          /*
            1. lambda表达式，必须和接口进行绑定。
            2. lambda表达式的参数，可以附带0个到n个参数，括号中的参数类型可以不用指定，jvm在运行时，会自动根据绑定的抽象方法中电参数进行推导。
            3. lambda表达式的返回值，如果代码块只有一行，并且没有大括号，不用写return关键字，单行代码的执行结果，会自动返回。
            如果添加了大括号，或者有多行代码，必须通过return关键字返回执行结果。
         */

    }

    interface ILambda1{
        void test();
    }

    interface ILambda2{
        void test(String name , int age);
    }

    interface ILambda3{
        int test(int x , int y);
    }

}
