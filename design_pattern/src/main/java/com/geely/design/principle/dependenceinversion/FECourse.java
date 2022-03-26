package com.geely.design.principle.dependenceinversion;

public class FECourse implements ICourse {
    @Override
    public void studyCource() {
        System.out.println("Geely在学习FE课程");
    }
}
