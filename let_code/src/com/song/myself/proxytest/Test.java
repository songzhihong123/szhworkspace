package com.song.myself.proxytest;

import java.lang.reflect.Field;

public class Test {


    public static void main(String[] args) throws Exception {
        Person person = (Person)new PersonProxy().getInstance(new PersonImpl());
        person.doWork();
        System.out.println(person.getClass());
        System.out.println(getTarget(person));
    }

    public static Object getTarget(Object proxy) throws Exception{
        Field field = proxy.getClass().getSuperclass().getDeclaredField("h");
        field.setAccessible(true);

        PersonProxy personProxy = (PersonProxy)field.get(proxy);
        Field person = personProxy.getClass().getDeclaredField("target");
        person.setAccessible(true);
        return person.get(personProxy);
    }


}
