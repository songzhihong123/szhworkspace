package com.geely.design.pattern.behavioral.visitor;

/**
 * Created by Zhihong Song on 2021/1/17 10:16
 */

public class Visitor implements IVisitor {

    /**
     *  不同的Visitor对相同的数据产生不同的操作行为
     */

    @Override
    public void visit(FreeCourse freeCourse) {
        System.out.println("免费课程：" + freeCourse.getName());
    }

    @Override
    public void visit(CodingCourse codingCourse) {
        System.out.println("实战课程："+codingCourse.getName()+" 价格：" + codingCourse.getPrice());
    }
}
