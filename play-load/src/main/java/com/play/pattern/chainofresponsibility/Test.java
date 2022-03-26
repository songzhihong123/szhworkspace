package com.play.pattern.chainofresponsibility;

public class Test {



    public static void main(String[] args){
        Course course = new Course();
        course.setName("java");
        course.setArticle("java-article");
        course.setVideo("java-video");

        Approve approve = new ArticleApprover();
        Approve approve1 = new VideoApprover();
        Approve approve2 = new ArticleApprover();


        approve.setNextApprove(approve1);
        approve1.setNextApprove(approve2);


        approve.deplay(course);

    }



}
