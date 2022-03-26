package com.geely.design.principle.dependenceinversion;

public class PythonCource implements ICourse {
    @Override
    public void studyCource() {
        System.out.println("Geely在学习Python课程");
    }
}
