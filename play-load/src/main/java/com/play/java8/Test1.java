package com.play.java8;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Test1 {



    public static void main(String[] args){

        List<User> list = new ArrayList<>();

        list.add(new User("张三","111"));
        list.add(new User("李四","222"));



        List<User> collect = list.stream().peek(user -> {
            user.setGender(user.getGender() + "##");
        }).collect(Collectors.toList());

        System.out.println(collect);



    }


}

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
class User{

    private String name;
    private String gender;

}
