package com.imooc;

/**
 * @description: 消息传输格式化接口
 * @author: szh
 * @create: 2021-06-03 21:08
 **/
@FunctionalInterface
public interface IMessageFormat {

    /**
     * @Description:消息转换接口
     * @Author: szh
     **/
    String format(String message , String format);

    /**
     * @Description:消息合法性的判断
     * @Author: szh
     **/
    static boolean verifyMesage(String msg){
        if(msg != null){
            return true;
        }
        return false;
    }


}
