package com.xiaomin.xmloginbackground.service;

import com.xiaomin.xmloginbackground.resp.DeliverGoodsResp;

import java.util.Collection;

/**
 * @Author: XiaoMin
 * @PRODUCT_NAME: IntelliJ IDEA
 * @PROJECT_NAME: xm-login-background
 * @Date_Time: 2022/10/13 11:07
 */
public interface DeliverGoodsService {
    Collection<DeliverGoodsResp> queryDeliverGoods();
    int updateDeliverGoods(long id,byte status);
}
