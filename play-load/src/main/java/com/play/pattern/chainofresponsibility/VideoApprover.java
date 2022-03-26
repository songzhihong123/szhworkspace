package com.play.pattern.chainofresponsibility;

public class VideoApprover extends Approve{


    @Override
    public void deplay(Course course) {
        if(!"".equals(course.getVideo())){
            System.out.println(course.getName() + "having video , verfiy pass!!");
            if(approve != null){
                approve.deplay(course);
            }
        }else{
            System.out.println(course.getArticle() + " not video , verfify is not pass!!");
            return;
        }
    }
}
