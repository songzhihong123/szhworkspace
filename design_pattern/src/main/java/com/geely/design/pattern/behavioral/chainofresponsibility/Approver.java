package com.geely.design.pattern.behavioral.chainofresponsibility;

/**
 * Created by Zhihong Song on 2021/1/16 15:13
 */

public abstract class Approver {


    protected Approver approver;

    public void  setNextApprover(Approver approver){
        this.approver = approver;
    }

    public abstract void deploy(Course course);



}
