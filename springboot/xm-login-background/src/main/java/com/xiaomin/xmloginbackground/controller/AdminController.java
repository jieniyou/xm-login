package com.xiaomin.xmloginbackground.controller;

import com.xiaomin.xmloginbackground.req.LoginReq;
import com.xiaomin.xmloginbackground.resp.LoginResp;
import com.xiaomin.xmloginbackground.service.AdminService;
import com.xiaomin.xmloginbackground.utils.JWTUtil;
import com.xiaomin.xmloginbackground.utils.Result;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author: XiaoMin
 * @PRODUCT_NAME: IntelliJ IDEA
 * @PROJECT_NAME: xm-login-background
 * @Date_Time: 2022/10/10 18:08
 */
@RestController
@RequestMapping("admin")
public class AdminController {

    @Resource
    private AdminService adminService;

    @PostMapping("login")
    public Result login(@RequestBody LoginReq loginReq){
        System.out.println("loginReq====>"+loginReq);
        LoginResp loginResp = adminService.login(loginReq);
        if (ObjectUtils.isEmpty(loginResp)){
            return Result.no();
        }else {
            System.out.println("login====>"+loginResp);
            String token = JWTUtil.getToken(loginResp.getAccount(), loginResp.getPassword());
            loginResp.setToken(token);
            return Result.ok(loginResp);
        }

    }
}
