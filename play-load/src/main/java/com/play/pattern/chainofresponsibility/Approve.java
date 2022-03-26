package com.play.pattern.chainofresponsibility;

public abstract class Approve {

    Approve approve;


    public void setNextApprove(Approve approve){
        this.approve = approve;
    }


    abstract public void deplay(Course course);


}
