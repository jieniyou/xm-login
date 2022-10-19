package com.xiaomin.xmlogin.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.xiaomin.xmlogin.entity.MyCartSideBarEntity;
import com.xiaomin.xmlogin.mapper.MyCartSideBarMapper;
import com.xiaomin.xmlogin.service.MyCartSideBarService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.List;

/**
 * @Author: XiaoMin
 * @PRODUCT_NAME: IntelliJ IDEA
 * @PROJECT_NAME: xm-login
 * @Date_Time: 2022/10/2 14:35
 */
@Service
public class MyCartSideBarServiceImpl implements MyCartSideBarService {
    @Resource
    private MyCartSideBarMapper cartMapper;
    @Override
    public Collection<MyCartSideBarEntity> queryAllCart() {
        List<MyCartSideBarEntity> carts = cartMapper.selectList(new QueryWrapper<>());
        System.out.println(carts);
        return carts;
    }
}
