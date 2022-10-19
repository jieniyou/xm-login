package com.xiaomin.xmloginbackground.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.xiaomin.xmloginbackground.entity.AdminEntity;
import com.xiaomin.xmloginbackground.mapper.AdminMapper;
import com.xiaomin.xmloginbackground.req.LoginReq;
import com.xiaomin.xmloginbackground.resp.LoginResp;
import com.xiaomin.xmloginbackground.service.AdminService;
import com.xiaomin.xmloginbackground.utils.CopyUtil;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import javax.annotation.Resource;

/**
 * @Author: XiaoMin
 * @PRODUCT_NAME: IntelliJ IDEA
 * @PROJECT_NAME: xm-login-background
 * @Date_Time: 2022/10/11 10:52
 */
@Service
public class AdminServiceImpl implements AdminService {
    @Resource
    private AdminMapper adminMapper;
    @Override
    public LoginResp login(LoginReq loginReq) {
        AdminEntity admin;
        admin=selectByAccountAndPassword(loginReq.getAccount(),loginReq.getPassword());
        if (ObjectUtils.isEmpty(admin)) {
            return null;
        }else {
            LoginResp loginResp;
            try {
                loginResp=CopyUtil.copy(admin,LoginResp.class);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            return loginResp;
        }


    }

    @Override
    public String getPasswordByName(String account) {
        QueryWrapper<AdminEntity> wrapper=new QueryWrapper<>();
        wrapper.lambda().eq(AdminEntity::getAccount,account);
        AdminEntity admin = adminMapper.selectOne(wrapper);
        return admin.getPassword();
    }

    private AdminEntity selectByAccountAndPassword(String account, String password) {
        QueryWrapper<AdminEntity> wrapper=new QueryWrapper<>();
        wrapper.lambda().eq(AdminEntity::getAccount,account);
        wrapper.lambda().eq(AdminEntity::getPassword,password);
        if (ObjectUtils.isEmpty(wrapper)) {
            return null;
        }else {
            return adminMapper.selectOne(wrapper);
        }

    }
}
