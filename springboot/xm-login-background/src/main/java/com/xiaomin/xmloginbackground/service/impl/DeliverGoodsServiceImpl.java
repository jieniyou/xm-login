package com.xiaomin.xmloginbackground.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.xiaomin.xmloginbackground.entity.ShoppingCartEntity;
import com.xiaomin.xmloginbackground.mapper.ShoppingCartMapper;
import com.xiaomin.xmloginbackground.resp.DeliverGoodsResp;
import com.xiaomin.xmloginbackground.service.DeliverGoodsService;
import com.xiaomin.xmloginbackground.utils.CopyUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @Author: XiaoMin
 * @PRODUCT_NAME: IntelliJ IDEA
 * @PROJECT_NAME: xm-login-background
 * @Date_Time: 2022/10/13 11:07
 */
@Service
public class DeliverGoodsServiceImpl implements DeliverGoodsService {
    @Resource
    private ShoppingCartMapper mapper;
    @Override
    public Collection<DeliverGoodsResp> queryDeliverGoods() {
        Collection<DeliverGoodsResp> deliverGoods=new ArrayList<>();
        List<ShoppingCartEntity> shoppingCartEntities = mapper.selectList(new QueryWrapper<>());
        for (ShoppingCartEntity shoppingCartEntity : shoppingCartEntities) {
            try {
                DeliverGoodsResp copy = CopyUtil.copy(shoppingCartEntity, DeliverGoodsResp.class);
                deliverGoods.add(copy);

            } catch (Exception e) {

            }
        }
        System.out.println("deliverGoods===>"+deliverGoods);
        return deliverGoods;

    }

    @Override
    public int updateDeliverGoods(long id, byte status) {
        UpdateWrapper<ShoppingCartEntity> wrapper=new UpdateWrapper<>();
        wrapper.lambda().eq(ShoppingCartEntity::getShoppingcartId,id).set(ShoppingCartEntity::getGoodsDeliveryStatus,status);
        int i = mapper.update(null, wrapper);
        return i;
    }
}
