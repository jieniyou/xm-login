package com.xiaomin.xmlogin.controller;

import com.xiaomin.xmlogin.resp.CommonResp;
import com.xiaomin.xmlogin.resp.EmailResp;
import com.xiaomin.xmlogin.service.EmailService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

/**
 * @Author: XiaoMin
 * @PRODUCT_NAME: IntelliJ IDEA
 * @PROJECT_NAME: xm-login
 * @Date_Time: 2022/9/23 18:32
 */
@RestController
@RequestMapping("/sys-user")
public class EmailController {
    @Resource
    private EmailService emailService;
    @GetMapping("sendEmail")
    public CommonResp commonEmail(@RequestParam String emailAddress){
        System.out.println(emailAddress);
        CommonResp resp=new CommonResp<>();
        EmailResp emailResp = emailService.commonEmail(emailAddress);
        resp.setContent(emailResp);
        return resp;
    }
}
