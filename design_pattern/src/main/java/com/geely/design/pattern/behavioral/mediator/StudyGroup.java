package com.geely.design.pattern.behavioral.mediator;

import java.util.Date;

/**
 * Created by Zhihong Song on 2021/1/16 14:53
 */

public class StudyGroup {

    public static void showMessage (User user,String message){
        System.out.println(new Date().toString() + " [" + user.getName() + "] ： "+message);
    }

}
