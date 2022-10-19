package com.xiaomin.xmlogin.service.impl;

import com.xiaomin.xmlogin.resp.EmailResp;
import com.xiaomin.xmlogin.service.EmailService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.concurrent.TimeUnit;

/**
 * @Author: XiaoMin
 * @PRODUCT_NAME: IntelliJ IDEA
 * @PROJECT_NAME: xm-login
 * @Date_Time: 2022/9/23 10:22
 */
@Service
public class EmailServiceImpl implements EmailService {
    @Resource
    private JavaMailSender mailSender;
    @Value("${spring.mail.username}")
    private String username;
    @Resource
    private RedisTemplate redisTemplate;

    @Override
    public EmailResp commonEmail(String emailAddress){
        EmailResp emailResp=null;
        String code=null;
        for(int j = 0; j< 100; j++){
            code= String.valueOf((int)((Math.random()*9+1)*100000));
        }
        SimpleMailMessage message=new SimpleMailMessage();
        message.setFrom(username);
        message.setTo(emailAddress);
        message.setSubject("xm-login邮箱验证");
        message.setText("您的邮箱验证码为:"+code+",请在三分钟内填写验证码完成注册");

        redisTemplate.opsForValue().set("email",emailAddress);
        redisTemplate.opsForValue().set("code",code,3l, TimeUnit.MINUTES);
        try {
            mailSender.send(message);
            emailResp=new EmailResp(emailAddress,code);
        }catch (MailException e) {
            e.printStackTrace();
        }
        return emailResp;
    }
}
