package com.geely.design.principle.openclose;

/**
 * 开闭原则.
 */
public class Test {

    public static void main(String[] args) {
        ICourse iCourse = new JavaDiscountCourse(96,"java",348d);
        JavaDiscountCourse javaCourse = (JavaDiscountCourse)iCourse;
        System.out.println("课程ID:"+javaCourse.getId()+" 课程名称："+javaCourse.getName() + "课程原价："+javaCourse.getOriginPrice() + " 课程折后价格 ：" + javaCourse.getPrice());
    }
}
