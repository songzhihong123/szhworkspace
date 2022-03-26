package com.atguigu.task;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMailMessage;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.test.context.junit4.SpringRunner;

import javax.mail.internet.MimeMessage;
import java.io.File;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Springboot04TaskApplicationTests {

    @Autowired
    JavaMailSenderImpl javaMailSender;

    @Test
    public void contextLoads() {
        SimpleMailMessage message = new SimpleMailMessage();
        //邮件设置
        message.setSubject("通知今晚开会");
        message.setText("今晚10点20开会");
        message.setTo("1056153570@qq.com");
        message.setFrom("1743261139@qq.com");
        javaMailSender.send(message);
    }

    @Test
    public void test02() throws Exception{
        //创建一个复杂的消息邮件
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage,true);



       //邮件设置
        helper.setSubject("通知今晚开会");
        helper.setText("<b style='color:red'>今晚10点20开会</b>",true);
        helper.setTo("1056153570@qq.com");
        helper.setFrom("1743261139@qq.com");
        //上传文件
        helper.addAttachment("4478426460441610685.jpg",new File("G:\\桌面照片\\林允儿\\4478426460441610685.jpg"));

        javaMailSender.send(mimeMessage);
    }


}
