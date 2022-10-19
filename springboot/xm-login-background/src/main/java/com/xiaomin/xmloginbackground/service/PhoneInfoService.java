package com.xiaomin.xmloginbackground.service;

import com.xiaomin.xmloginbackground.resp.PhoneInfoResp;

import java.util.Collection;

/**
 * @Author: XiaoMin
 * @PRODUCT_NAME: IntelliJ IDEA
 * @PROJECT_NAME: xm-login-background
 * @Date_Time: 2022/10/13 9:24
 */
public interface PhoneInfoService {
    Collection<PhoneInfoResp> selectGoods();
}
