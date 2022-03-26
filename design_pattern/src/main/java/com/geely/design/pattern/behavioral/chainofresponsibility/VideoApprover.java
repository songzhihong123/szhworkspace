package com.geely.design.pattern.behavioral.chainofresponsibility;

import com.github.pagehelper.StringUtil;

/**
 * Created by Zhihong Song on 2021/1/16 16:51
 */

public class VideoApprover extends Approver {
    @Override
    public void deploy(Course course) {
        if (StringUtil.isNotEmpty(course.getVideo())){
            System.out.println(course.getName() + "含有视频，批准");
            if(approver!=null){
                approver.deploy(course);
            }
        }else{
            System.out.println(course.getName() + "不包含视频，不批准，流程结束");
            return;
        }
    }
}
