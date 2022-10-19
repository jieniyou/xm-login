package com.xiaomin.xmloginbackground.service;

import com.xiaomin.xmloginbackground.entity.AdminEntity;
import com.xiaomin.xmloginbackground.req.LoginReq;
import com.xiaomin.xmloginbackground.resp.LoginResp;

/**
 * @Author: XiaoMin
 * @PRODUCT_NAME: IntelliJ IDEA
 * @PROJECT_NAME: xm-login-background
 * @Date_Time: 2022/10/11 10:51
 */
public interface AdminService {
    LoginResp login(LoginReq loginReq);

    String getPasswordByName(String account);
}
