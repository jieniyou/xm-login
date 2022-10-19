package com.xiaomin.xmlogin.service;

import com.xiaomin.xmlogin.entity.ShoppingCartEntity;
import com.xiaomin.xmlogin.entity.WalletEntity;
import com.xiaomin.xmlogin.req.WalletReq;

import java.util.Collection;

/**
 * @Author: XiaoMin
 * @PRODUCT_NAME: IntelliJ IDEA
 * @PROJECT_NAME: xm-login
 * @Date_Time: 2022/10/4 22:39
 */
public interface ShoppingCartService {
    Collection<ShoppingCartEntity> queryShoppingCartByUserId(long id);
    int addShoppingCart(ShoppingCartEntity shoppingCartEntity);
    int updateShoppingCartById(long id);
    int deleteShoppingCartById(long id);
    //收货
    int updateTakeStatusById(long id);

    int updateBalanceById(WalletReq walletReq);
}
