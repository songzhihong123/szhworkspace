package com.geely.design.principle.dependenceinversion;

public class Geely {

    private ICourse iCourse;

    public void setiCourse(ICourse iCourse) {
        this.iCourse = iCourse;
    }

    public void  studyImoocCource(){
        iCourse.studyCource();
    }

}
