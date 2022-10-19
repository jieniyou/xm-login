package com.xiaomin.xmlogin.service;

import com.xiaomin.xmlogin.entity.PhoneEntity;

import java.util.Collection;

/**
 * @Author: XiaoMin
 * @PRODUCT_NAME: IntelliJ IDEA
 * @PROJECT_NAME: xm-login
 * @Date_Time: 2022/10/2 20:03
 */
public interface SearchService {
    Collection<PhoneEntity> queryPhoneByModel(String model);
    Collection<PhoneEntity> queryPhoneByCategory(long id);
}
