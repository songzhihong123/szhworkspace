package com.geely.design.myself;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Zhihong Song on 2020/12/7 8:24
 */

public class Test {

    private static Integer or = new Integer(0);
    public static void main(String[] args) {
        List<User> list = new ArrayList<>();
        list.add(new User("1",5,0));
        list.add(new User("1",8,0));
        list.add(new User("1",2,0));
        list.add(new User("1",3,0));
        list.add(new User("1",1,0));
        list.forEach(System.out::println);
        System.out.println("------------------我是分割线---------------------");


        //重点来了
        // 在 lambda 表达式内部引用动态变量有两个要求
        //  局部变量 必须是 final 修饰 的不可变变量
        // 解决办法 ：
        //   1. 使用一个全局的静态变量
        //  2. 使用一个数组来实现

        int[] count = {0};
        List<User> collect = list.stream().sorted(Comparator.comparing(User::getProgress)).map(user -> {
            user.setOrder(count[0]++);
            return user;
        }).collect(Collectors.toList());
        collect.forEach(System.out::println);

    }






}

class User{

    private String id;
    private Integer progress;
    private Integer order;

    public User() {
    }

    public User(String id, Integer progress, Integer order) {
        this.id = id;
        this.progress = progress;
        this.order = order;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getProgress() {
        return progress;
    }

    public void setProgress(Integer progress) {
        this.progress = progress;
    }

    public Integer getOrder() {
        return order;
    }

    public void setOrder(Integer order) {
        this.order = order;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", progress=" + progress +
                ", order=" + order +
                '}';
    }
}
