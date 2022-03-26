package com.geely.design.pattern.behavioral.visitor;

/**
 * Created by Zhihong Song on 2021/1/17 10:12
 */

public class CodingCourse extends Course {

    private int price;

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public void accept(IVisitor visitor) {
        visitor.visit(this);
    }
}
