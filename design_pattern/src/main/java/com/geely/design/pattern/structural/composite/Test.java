package com.geely.design.pattern.structural.composite;

/**
 * Created by Zhihong Song on 2020/12/10 17:50
 *
 * 组合模式
 */

public class Test {

    public static void main(String[] args) {
        CatalogComponent linuxCourse = new Course("Linux",11d);
        CatalogComponent windowsCourse = new Course("Windows",12d);

        CatalogComponent javaCourseCataLog = new CourseCatalog("java目录",2);
        CatalogComponent mmallCourse1 = new Course("Java电商1期",55d);
        CatalogComponent mmallCourse2 = new Course("Java电商2期",55d);
        CatalogComponent designPattern = new Course("Java设计模式",20d);
        javaCourseCataLog.add(mmallCourse1);
        javaCourseCataLog.add(mmallCourse2);
        javaCourseCataLog.add(designPattern);

        CatalogComponent imoocMainCourseCatalog = new CourseCatalog("慕课网课程主目录",1);
        imoocMainCourseCatalog.add(linuxCourse);
        imoocMainCourseCatalog.add(windowsCourse);
        imoocMainCourseCatalog.add(javaCourseCataLog);

        imoocMainCourseCatalog.print();
    }

}
