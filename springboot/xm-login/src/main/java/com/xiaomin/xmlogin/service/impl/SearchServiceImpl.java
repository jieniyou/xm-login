package com.xiaomin.xmlogin.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.ObjectUtils;
import com.xiaomin.xmlogin.entity.PhoneEntity;
import com.xiaomin.xmlogin.mapper.PhoneMapper;
import com.xiaomin.xmlogin.service.SearchService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.List;

/**
 * @Author: XiaoMin
 * @PRODUCT_NAME: IntelliJ IDEA
 * @PROJECT_NAME: xm-login
 * @Date_Time: 2022/10/2 20:04
 */
@Service
public class SearchServiceImpl implements SearchService {
    @Resource
    private PhoneMapper phoneMapper;
    QueryWrapper<PhoneEntity> phoneQueryWrapper;
    @Override
    public Collection<PhoneEntity> queryPhoneByModel(String model) {
        phoneQueryWrapper=new QueryWrapper<>();
        phoneQueryWrapper.lambda().like(PhoneEntity::getPhoneModel,model);
        List<PhoneEntity> phones = phoneMapper.selectList(phoneQueryWrapper);
        System.out.println("queryPhoneByModel==>"+phones);
        System.out.println("model==>"+model);
        if (ObjectUtils.isNotEmpty(phones)) {
            return phones;
        }else {
            return null;
        }
    }

    @Override
    public Collection<PhoneEntity> queryPhoneByCategory(long id) {
        phoneQueryWrapper=new QueryWrapper<>();
        phoneQueryWrapper.lambda().like(PhoneEntity::getCategoryId,id);
        List<PhoneEntity> phones = phoneMapper.selectList(phoneQueryWrapper);
        System.out.println("queryPhoneByCategory==>"+phones);
        System.out.println("id==>"+id);
        if (ObjectUtils.isNotEmpty(phones)) {
            return phones;
        }else {
            return null;
        }
    }
}
