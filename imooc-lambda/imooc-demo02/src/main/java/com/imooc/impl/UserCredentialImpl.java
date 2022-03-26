package com.imooc.impl;

import com.imooc.IUserCredential;

/**
 * @description:
 * @author: szh
 * @create: 2021-06-03 21:11
 **/
public class UserCredentialImpl implements IUserCredential {

    @Override
    public String verifyUser(String username) {
        if("admin".equals(username)){
            return "系统管理员";
        }else if("manager".equals(username)){
            return "用户管理员";
        }
        return "普通会员";
    }

}
