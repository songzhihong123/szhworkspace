package com.imooc.impl;

import com.imooc.IMessageFormat;

/**
 * @description:
 * @author: szh
 * @create: 2021-06-03 21:21
 **/
public class MessageFormatImpl implements IMessageFormat {
    @Override
    public String format(String message, String format) {
        System.out.println("消息转换....");
        return message;
    }
}
