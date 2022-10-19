package com.xiaomin.xmlogin.service;

import com.xiaomin.xmlogin.entity.AddressEntity;

import java.util.Collection;

/**
 * @Author: XiaoMin
 * @PRODUCT_NAME: IntelliJ IDEA
 * @PROJECT_NAME: xm-login
 * @Date_Time: 2022/10/4 10:51
 */
public interface AddressService {
    Collection<AddressEntity> queryAddressByUserId(long id);
    int insertAddress(AddressEntity address);
    int updateAddressByAddressId(long id);
}
