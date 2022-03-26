package com.geely.design.pattern.behavioral.visitor;

/**
 * Created by Zhihong Song on 2021/1/17 10:13
 */

public class FreeCourse extends Course {


    @Override
    public void accept(IVisitor visitor) {
        visitor.visit(this);
    }
}
