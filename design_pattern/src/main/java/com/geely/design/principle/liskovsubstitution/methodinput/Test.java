package com.geely.design.principle.liskovsubstitution.methodinput;

import java.util.HashMap;
import java.util.Map;

public class Test {
    public static void main(String[] args) {
        Child child = new Child();
        HashMap map = new HashMap();
        child.method(map);
        Map map1 = new HashMap();
        child.method(map1);

    }
}
