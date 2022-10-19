package com.xiaomin.xmlogin.service;

import com.xiaomin.xmlogin.req.WalletReq;
import com.xiaomin.xmlogin.resp.WalletResp;

/**
 * @Author: XiaoMin
 * @PRODUCT_NAME: IntelliJ IDEA
 * @PROJECT_NAME: xm-login
 * @Date_Time: 2022/10/3 12:13
 */
public interface WalletService {
    WalletResp queryBalanceById(long id);
    int updateBalanceById(WalletReq walletReq);
}
