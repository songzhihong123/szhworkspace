package com.song.myself.proxytest;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class PersonProxy implements InvocationHandler {

    private Person target;

    public Object getInstance(Person person){
        this.target = person;
        return Proxy.newProxyInstance(person.getClass().getClassLoader(), person.getClass().getInterfaces() , this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        method.invoke(target,args);
        return target;
    }
}
