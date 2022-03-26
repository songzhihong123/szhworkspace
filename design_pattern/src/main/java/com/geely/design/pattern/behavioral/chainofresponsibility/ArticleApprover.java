package com.geely.design.pattern.behavioral.chainofresponsibility;

import com.github.pagehelper.StringUtil;

/**
 * Created by Zhihong Song on 2021/1/16 15:16
 */

public class ArticleApprover extends Approver {


    @Override
    public void deploy(Course course) {
        if (StringUtil.isNotEmpty(course.getArticle())){
            System.out.println(course.getName() + "含有手记，批准");
            if(approver!=null){
                approver.deploy(course);
            }
        }else{
            System.out.println(course.getName() + "不包含手记，不批准，流程结束");
            return;
        }
    }


}
