package com.xiaomin.xmlogin.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.xiaomin.xmlogin.entity.WalletEntity;
import com.xiaomin.xmlogin.mapper.WalletMapper;
import com.xiaomin.xmlogin.req.WalletReq;
import com.xiaomin.xmlogin.resp.WalletResp;
import com.xiaomin.xmlogin.service.WalletService;
import com.xiaomin.xmlogin.utils.CopyUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

/**
 * @Author: XiaoMin
 * @PRODUCT_NAME: IntelliJ IDEA
 * @PROJECT_NAME: xm-login
 * @Date_Time: 2022/10/3 12:13
 */
@Service
public class WalletServiceImpl implements WalletService {
    @Resource
    private WalletMapper walletMapper;
    @Override
    public WalletResp queryBalanceById(long id) {
        System.out.println("id------>"+id);
        QueryWrapper<WalletEntity> walletQueryWrapper=new QueryWrapper<>();
        walletQueryWrapper.lambda().eq(WalletEntity::getWalletId,id);
        WalletEntity walletEntity = walletMapper.selectOne(walletQueryWrapper);
        System.out.println("walletEntity====>"+walletEntity);
        WalletResp walletResp=null;
        try {
            if (walletEntity != null) {
                walletResp= CopyUtil.copy(walletEntity, WalletResp.class);
            }else {
                walletResp=new WalletResp(id,0);
            }
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
        System.out.println("walletResp===>"+walletResp);
        return walletResp;
    }

    @Override
    public int updateBalanceById(WalletReq walletReq) {
        WalletEntity walletEntity;
        double balance=queryBalanceById(walletReq.getWalletId()).getBalance();
        System.out.println("balance========>"+balance);
        int i=0;
        try {
            if (walletReq.getBalance()<=balance){
                balance -= walletReq.getBalance();
                walletReq.setBalance(balance);
                System.out.println("您现在的余额为==>"+walletReq.getBalance());
                walletEntity = CopyUtil.copy(walletReq, WalletEntity.class);
                System.out.println("walletEntity==>"+walletEntity);
                i = walletMapper.updateById(walletEntity);
                System.out.println("i===>"+i);
            }else {
                i=0;
            }

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
