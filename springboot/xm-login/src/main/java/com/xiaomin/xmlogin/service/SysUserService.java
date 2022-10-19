package com.xiaomin.xmlogin.service;

import com.xiaomin.xmlogin.req.SysUserLoginReq;
import com.xiaomin.xmlogin.req.SysUserSaveReq;
import com.xiaomin.xmlogin.resp.SysUserLoginResp;

/**
 * @Author: XiaoMin
 * @PRODUCT_NAME: IntelliJ IDEA
 * @PROJECT_NAME: xm-login
 * @Date_Time: 2022/9/20 18:17
 */
public interface SysUserService {
    int register(SysUserSaveReq req);

    SysUserLoginResp login(SysUserLoginReq req);
}
