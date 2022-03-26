package com.geely.design.pattern.behavioral.mediator;

/**
 * Created by Zhihong Song on 2021/1/16 14:54
 */

public class User {

    private String name;

    public User(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void sendMessage(String message){
        StudyGroup.showMessage(this,message);
    }


    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                '}';
    }
}
