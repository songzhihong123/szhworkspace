package com.geely.design.pattern.behavioral.visitor;

/**
 * Created by Zhihong Song on 2021/1/17 10:13
 */

public interface IVisitor {

    void visit(FreeCourse freeCourse);

    void visit(CodingCourse codingCourse);

}
