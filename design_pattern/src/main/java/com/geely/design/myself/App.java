package com.geely.design.myself;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @description:
 * @author: szh
 * @create: 2021-06-05 10:15
 **/
public class App {

    public static void main(String[] args) {
        IPerson person = Person.PersonBuilder::new;
        System.out.println(person.buildPerson());
    }

}

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
class Person{
    private String name;
    private String gender;
    private int age;
}

interface IPerson{
    Person.PersonBuilder buildPerson();
}
