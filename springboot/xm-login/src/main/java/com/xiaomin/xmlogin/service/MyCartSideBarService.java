package com.xiaomin.xmlogin.service;

import com.xiaomin.xmlogin.entity.MyCartSideBarEntity;

import java.util.Collection;

/**
 * @Author: XiaoMin
 * @PRODUCT_NAME: IntelliJ IDEA
 * @PROJECT_NAME: xm-login
 * @Date_Time: 2022/10/2 14:35
 */
public interface MyCartSideBarService {
    Collection<MyCartSideBarEntity> queryAllCart();
}
