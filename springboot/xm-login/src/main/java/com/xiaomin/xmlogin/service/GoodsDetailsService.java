package com.xiaomin.xmlogin.service;

import com.xiaomin.xmlogin.resp.GoodsDetailsResp;

/**
 * @Author: XiaoMin
 * @PRODUCT_NAME: IntelliJ IDEA
 * @PROJECT_NAME: xm-login
 * @Date_Time: 2022/10/2 22:24
 */
public interface GoodsDetailsService {
    GoodsDetailsResp queryGoodsDetailsById(long id);
}
