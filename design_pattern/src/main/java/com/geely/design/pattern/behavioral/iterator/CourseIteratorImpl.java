package com.geely.design.pattern.behavioral.iterator;

import java.util.List;

/**
 * Created by Zhihong Song on 2020/12/23 21:49
 */

public class CourseIteratorImpl implements CourseIterator {

    private List<Course> list;

    private int position;

    public CourseIteratorImpl(List<Course> list){
        this.list = list;
    }

    @Override
    public Course nextCourse() {
        System.out.println("返回课程，位置是："+position);
        return list.get(position++);
    }

    @Override
    public boolean isLastCourse() {
        if(position < list.size()){
            return false;
        }
        return true;
    }
}
