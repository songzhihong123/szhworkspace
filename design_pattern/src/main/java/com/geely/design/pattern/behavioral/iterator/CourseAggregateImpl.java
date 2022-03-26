package com.geely.design.pattern.behavioral.iterator;

import java.util.List;

/**
 * Created by Zhihong Song on 2020/12/23 21:48
 */

public class CourseAggregateImpl implements CourseAggregate {

    private List<Course> list;

    @Override
    public void addCourse(Course course) {
        list.add(course);
    }

    @Override
    public void removeCourse(Course course) {
        list.remove(course);
    }

    @Override
    public CourseIterator getCourseIterator() {
        return new CourseIteratorImpl(list);
    }
}
