package com.geely.design.pattern.behavioral.iterator;

/**
 * Created by Zhihong Song on 2020/12/23 21:46
 */

public interface CourseIterator {

    Course nextCourse();

    boolean isLastCourse();

}
