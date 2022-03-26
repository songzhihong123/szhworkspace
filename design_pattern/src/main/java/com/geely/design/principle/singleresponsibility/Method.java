package com.geely.design.principle.singleresponsibility;

public class Method {

    private void updateUserInfo(String userName,String address){
        userName = "geely";
        address = "beijing";
    }

    private void updateUserInfo(String userName,String... properties){
        userName = "geely";

    }

    private void updateUserName(String userName){
        userName = "geely";
    }

    private void updateUserAddress(String address){
        address = "geely";
    }


    private void updateUserInfo(String userName,String address,boolean bool){
        if(bool){
            //todosomething
        }else {
            //todosomething
        }
        userName = "geely";
        address = "beijing";
    }


}
