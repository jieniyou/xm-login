package com.xiaomin.xmlogin.controller;

import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.xiaomin.xmlogin.req.SysUserLoginReq;
import com.xiaomin.xmlogin.req.SysUserSaveReq;
import com.xiaomin.xmlogin.resp.CommonResp;
import com.xiaomin.xmlogin.resp.EmailResp;
import com.xiaomin.xmlogin.resp.SysUserLoginResp;
import com.xiaomin.xmlogin.service.EmailService;
import com.xiaomin.xmlogin.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

/**
 * @Author: XiaoMin
 * @PRODUCT_NAME: IntelliJ IDEA
 * @PROJECT_NAME: xm-login
 * @Date_Time: 2022/9/20 18:15
 */
@RestController
@RequestMapping("/sys-user")
public class SysUserController {
    @Resource
    private SysUserService sysUserService;

    @PostMapping("register")
    public CommonResp register(@RequestBody SysUserSaveReq req){
        CommonResp resp = new CommonResp<>();
            if (StringUtils.isNotEmpty(req.getUserName())||
                StringUtils.isNotEmpty(req.getPassword())||
                StringUtils.isNotEmpty(req.getEmail())){
                req.setPassword(DigestUtils.md5DigestAsHex(req.getPassword().getBytes()));
                int i = sysUserService.register(req);
                if (i==1){
                    resp.setMessage("注册成功!!!");
                    resp.setSuccess(true);
                }else if (i==0){
                    resp.setMessage("用户已存在,请重新注册!!!");
                    resp.setSuccess(false);
                }else {
                    resp.setMessage("邮箱与验证码不匹配!!!");
                    resp.setSuccess(false);
                }
            }else {
                resp.setMessage("请填写全部信息");
                resp.setSuccess(false);
            }
        System.out.println("Message为:"+resp.getMessage());
        System.out.println("code==>"+req.getCode());
        return resp;
    }

    @PostMapping("login")
    public CommonResp login(@RequestBody SysUserLoginReq req){
        req.setPassword(DigestUtils.md5DigestAsHex(req.getPassword().getBytes()));
        CommonResp resp=new CommonResp<>();
        SysUserLoginResp loginResp = sysUserService.login(req);
        if (loginResp!=null) {
            resp.setContent(loginResp);
            resp.setMessage("登陆成功");
            System.out.println(loginResp.getUserName() + "登陆了");
        }else {
            resp.setMessage("账户名或密码错误");
            resp.setSuccess(false);
        }
        return resp;
    }
}
