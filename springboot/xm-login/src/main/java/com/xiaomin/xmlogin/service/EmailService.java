package com.xiaomin.xmlogin.service;

import com.xiaomin.xmlogin.resp.EmailResp;

import javax.servlet.http.HttpSession;

/**
 * @Author: XiaoMin
 * @PRODUCT_NAME: IntelliJ IDEA
 * @PROJECT_NAME: xm-login
 * @Date_Time: 2022/9/23 10:21
 */
public interface EmailService {

    EmailResp commonEmail(String emailAddress);
}
