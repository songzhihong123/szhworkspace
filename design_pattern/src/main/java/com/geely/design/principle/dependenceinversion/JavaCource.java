package com.geely.design.principle.dependenceinversion;

public class JavaCource implements ICourse {

    @Override
    public void studyCource() {
        System.out.println("Geely在学习java课程");
    }
}
