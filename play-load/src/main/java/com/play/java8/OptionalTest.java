package com.play.java8;

import java.util.Optional;

/**
 * @ClassName OptionalTest
 * @Description TODO
 * @Author szh
 * @Date 2022年04月07日
 */
public class OptionalTest {

    public static void main(String[] args){

        User user = new User();
        // 不管user为null还是不为null都会执行
//        user = Optional.ofNullable(user).orElse(createUser());

        // 只有user为null的时候才会执行
//        user = Optional.ofNullable(user).orElseGet(() -> createUser());

        // 只有不为null的时候才会执行
//        Optional.ofNullable(null).ifPresent(u -> createUser());

        System.out.println(Optional.ofNullable(user).isPresent());
    }

    public static User createUser(){
        User user = new User();
        user.setName("zhangsan");
        System.out.println("==========");
        return user;
    }

}
