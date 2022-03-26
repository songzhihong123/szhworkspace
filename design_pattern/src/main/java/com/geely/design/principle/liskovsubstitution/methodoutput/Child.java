package com.geely.design.principle.liskovsubstitution.methodoutput;

import java.util.HashMap;
import java.util.Map;

public class Child extends Base {

    @Override
    public Map method() {
        HashMap map = new HashMap();
        System.out.println("子类method被执行");
        map.put("message","子类method被执行");
        return map;
    }
}
