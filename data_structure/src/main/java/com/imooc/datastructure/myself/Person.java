package com.imooc.datastructure.myself;

public class Person implements Cloneable{

    private String name;
    private Address address;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public Person clone() throws CloneNotSupportedException{
//        Person per = (Person) super.clone();
//        per.setAddress(per.getAddress().clone());
//        return per;
        return (Person) super.clone();
    }

    @Override
    public String toString() {
        return "Persion{" +
                "name='" + name + '\'' +
                ", address=" + address +
                '}';
    }
}
