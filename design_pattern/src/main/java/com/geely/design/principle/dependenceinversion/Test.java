package com.geely.design.principle.dependenceinversion;

/**
 * 依赖倒置原则.
 */
public class Test {
    // v1
//    public static void main(String[] args) {
//        Geely geely = new Geely();
//        geely.studyJavaCource();
//        geely.studyFECource();
//
//    }

    // v2
//    public static void main(String[] args) {
//        Geely geely = new Geely();
//        geely.studyImoocCource(new JavaCource());
//        geely.studyImoocCource(new FECourse());
//        geely.studyImoocCource(new PythonCource());
//    }

    //v3
//    public static void main(String[] args) {
//        Geely geely = new Geely(new JavaCource());
//        geely.studyImoocCource();
//    }

//v4
    public static void main(String[] args) {
        Geely geely = new Geely();
        geely.setiCourse(new JavaCource());
        geely.studyImoocCource();

        geely.setiCourse(new FECourse());
        geely.studyImoocCource();
    }




}
