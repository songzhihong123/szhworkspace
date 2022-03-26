package com.play.pattern.chainofresponsibility;

public class ArticleApprover extends Approve{

    @Override
    public void deplay(Course course) {
        if(!"".equals(course.getArticle())){
            System.out.println(course.getName() + "having article , verfiy pass!!");
            if(approve != null){
                approve.deplay(course);
            }
        }else{
            System.out.println(course.getArticle() + " not article , verfify is not pass!!");
            return;
        }
    }


}
