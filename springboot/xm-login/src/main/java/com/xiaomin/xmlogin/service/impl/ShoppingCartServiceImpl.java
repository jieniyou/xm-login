package com.xiaomin.xmlogin.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.xiaomin.xmlogin.entity.ShoppingCartEntity;
import com.xiaomin.xmlogin.entity.WalletEntity;
import com.xiaomin.xmlogin.mapper.ShoppingCartMapper;
import com.xiaomin.xmlogin.mapper.WalletMapper;
import com.xiaomin.xmlogin.req.WalletReq;
import com.xiaomin.xmlogin.service.ShoppingCartService;
import com.xiaomin.xmlogin.utils.CopyUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.lang.reflect.InvocationTargetException;
import java.util.Collection;
import java.util.List;

/**
 * @Author: XiaoMin
 * @PRODUCT_NAME: IntelliJ IDEA
 * @PROJECT_NAME: xm-login
 * @Date_Time: 2022/10/4 22:40
 */
@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {
    @Resource
    private ShoppingCartMapper shoppingCartMapper;
    @Override
    public Collection<ShoppingCartEntity> queryShoppingCartByUserId(long id) {
        QueryWrapper<ShoppingCartEntity> queryWrapper=new QueryWrapper<>();
        queryWrapper.lambda().eq(ShoppingCartEntity::getUserId,id);
        List<ShoppingCartEntity> list = shoppingCartMapper.selectList(queryWrapper);
        System.out.println("shoppingCarts===>list::"+list);
        return list;
    }

    @Override
    public int addShoppingCart(ShoppingCartEntity shoppingCartEntity) {
        int insert = shoppingCartMapper.insert(shoppingCartEntity);
        System.out.println("addShoppingCart::insert==>"+insert);
        return insert;
    }
    @Override
    public int updateShoppingCartById(long id) {
        UpdateWrapper<ShoppingCartEntity> wrapper=new UpdateWrapper<>();
        wrapper.lambda().eq(ShoppingCartEntity::getShoppingcartId,id)
                .set(ShoppingCartEntity::getGoodsPayStatus,1);
        int update = shoppingCartMapper.update(null, wrapper);
        System.out.println("updateShoppingCartById===>"+update);
        return update;
    }

    @Override
    public int deleteShoppingCartById(long id) {
        int i = shoppingCartMapper.deleteById(id);
        System.out.println("deleteShoppingCartById===>"+i);
        return i;
    }

    @Override
    public int updateTakeStatusById(long id) {
        UpdateWrapper<ShoppingCartEntity> wrapper=new UpdateWrapper<>();
        wrapper.lambda().eq(ShoppingCartEntity::getShoppingcartId,id).set(ShoppingCartEntity::getGoodsTakeStatus,1);
        int update = shoppingCartMapper.update(null, wrapper);
        System.out.println("updateTakeStatusById====>"+update);
        return update;
    }

    @Resource
    private WalletMapper walletMapper;
    @Override
    public int updateBalanceById(WalletReq walletReq) {
        WalletEntity walletEntity;
        int i=0;
        try {
            walletEntity = CopyUtil.copy(walletReq, WalletEntity.class);
            i = walletMapper.updateById(walletEntity);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (NoSuchFieldException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        }

        return i;
    }
}
