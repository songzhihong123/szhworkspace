package com.imooc.datastructure.myself;

import java.util.concurrent.TimeUnit;

public class Test1 {


    public static void main(String[] args) throws CloneNotSupportedException {

        Address address = new Address();
        address.setAddressId("123456");
        address.setAddressName("address_name");

        Person person = new Person();
        person.setName("persion_name");
        person.setAddress(address);

        System.out.println(person);
        System.out.println("============================");

        Person personCopy = person.clone();
        System.out.println(person.getAddress() == personCopy.getAddress());

        personCopy.setName("person_name_copy");
        Address address1 = new Address();
        address1.setAddressId("123456789");
        address1.setAddressName("address_name789");
        personCopy.setAddress(address1);
        System.out.println(personCopy);
        System.out.println("============================");


        System.out.println(person);



    }




}
