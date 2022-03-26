package com.geely.design.pattern.creational.prototype;

/**
 * Created by Zhihong Song on 2020/11/12 8:38
 *
 * 原型模式。
 *
 * 在内存模式中以二进制流形式进行拷贝，比直接new出来一个对象性能高
 *
 */

public class T {

    public static void main(String[] args) throws CloneNotSupportedException {
        Mail mail = new Mail();
        mail.setContent("初始化模板");
        System.out.println("...............初始化mail"+mail);
        for (int i = 0; i < 10; i++) {
            Mail tempMail = (Mail)mail.clone();
            tempMail.setName("姓名" + i);
            tempMail.setEmailAddress("姓名" + i +"imooc.com");
            tempMail.setContent("恭喜您，慕课网活动中奖了");
            MailUtil.sendMail(tempMail);
            System.out.println(".............克隆的mailTemp：" + tempMail);
        }
        MailUtil.saveOrginMailRecord(mail);

    }


}
