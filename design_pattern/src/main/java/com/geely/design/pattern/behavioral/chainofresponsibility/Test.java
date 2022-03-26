package com.geely.design.pattern.behavioral.chainofresponsibility;

/**
 * Created by Zhihong Song on 2021/1/16 16:53
 *
 * 责任链模式.
 */

public class Test {

    public static void main(String[] args) {
        Approver articleApprove = new ArticleApprover();
        Approver videoApprove = new VideoApprover();

        Course course = new Course();
        course.setName("Java设计模式精讲");
        course.setArticle("Java设计模式精讲的手记");
        course.setVideo("Java设计模式精讲的视频");


        articleApprove.setNextApprover(videoApprove);
        articleApprove.deploy(course);


    }

}
