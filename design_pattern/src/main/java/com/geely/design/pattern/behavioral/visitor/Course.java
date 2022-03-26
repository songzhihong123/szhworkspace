package com.geely.design.pattern.behavioral.visitor;

/**
 * Created by Zhihong Song on 2021/1/17 10:06
 */

public abstract class Course {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public abstract void accept(IVisitor visitor);

}
