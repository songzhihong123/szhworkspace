package com.geely.design.pattern.creational.prototype;

import java.text.MessageFormat;

/**
 * Created by Zhihong Song on 2020/11/12 8:32
 */

public class MailUtil {

    public static void sendMail(Mail mail){
        String outputContent = "向{0}同学，邮件地址: {1},邮件内容:{2} 发送邮件";
        System.out.println(MessageFormat.format(outputContent,mail.getName(),mail.getEmailAddress(),mail.getContent()));
    }

    public static void saveOrginMailRecord(Mail mail){
        System.out.println("存储orginMail记录，orginMail: " + mail.getContent());
    }

}
