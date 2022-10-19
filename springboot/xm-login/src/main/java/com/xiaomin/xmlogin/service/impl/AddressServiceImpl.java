package com.xiaomin.xmlogin.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.xiaomin.xmlogin.entity.AddressEntity;
import com.xiaomin.xmlogin.mapper.AddressMapper;
import com.xiaomin.xmlogin.service.AddressService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.List;

/**
 * @Author: XiaoMin
 * @PRODUCT_NAME: IntelliJ IDEA
 * @PROJECT_NAME: xm-login
 * @Date_Time: 2022/10/4 10:54
 */
@Service
public class AddressServiceImpl implements AddressService {
    @Resource
    private AddressMapper addressMapper;
    @Override
    public Collection<AddressEntity> queryAddressByUserId(long id) {
        QueryWrapper<AddressEntity> addressQueryWrapper=new QueryWrapper<>();
        addressQueryWrapper.lambda().eq(AddressEntity::getUserId,id);
        List<AddressEntity> addresses = addressMapper.selectList(addressQueryWrapper);
        System.out.println("addresses===>"+addresses);
        return addresses;
    }

    @Override
    public int insertAddress(AddressEntity address) {
        int i = addressMapper.insert(address);
        System.out.println("i====>"+i);
        return i;
    }

    @Override
    public int updateAddressByAddressId(long id) {
        UpdateWrapper<AddressEntity> updateWrapper=new UpdateWrapper<>();
        updateWrapper.lambda().eq(AddressEntity::getAddressId,id).set(AddressEntity::getAddressStatus,0);
        int update = addressMapper.update(null, updateWrapper);
        return update;
    }
}
