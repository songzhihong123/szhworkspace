package com.imooc;

/**
 * @Description: 用户身份认证标记接口
 * @Author: szh
 **/
@FunctionalInterface
public interface IUserCredential {

    /**
     * @Description: 通过用户账号，验证用户身份信息的接口
     * @Author: szh
     **/
    String verifyUser(String username);


    default String getCredential(String username){
        // 模拟放发
        if("admin".equals(username)){
            return "admin + 系统管理员用户";
        }else if("manager".equals(username)){
            return "manager + 用户管理员用户";
        }else {
            return "common + 普通会员用户";
        }
    }

}
