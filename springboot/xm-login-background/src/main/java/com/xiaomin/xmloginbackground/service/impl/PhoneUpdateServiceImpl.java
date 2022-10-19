package com.xiaomin.xmloginbackground.service.impl;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.xiaomin.xmloginbackground.entity.PhoneEntity;
import com.xiaomin.xmloginbackground.mapper.PhoneMapper;
import com.xiaomin.xmloginbackground.service.PhoneUpdateService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Author: XiaoMin
 * @PRODUCT_NAME: IntelliJ IDEA
 * @PROJECT_NAME: xm-login-background
 * @Date_Time: 2022/10/13 18:40
 */
@Service
public class PhoneUpdateServiceImpl implements PhoneUpdateService {
    @Resource
    private PhoneMapper mapper;
    @Override
    public int editGoods(PhoneEntity phone) {
        UpdateWrapper<PhoneEntity> wrapper=new UpdateWrapper<>();
        wrapper.lambda().eq(PhoneEntity::getId,phone.getId())
                .set(PhoneEntity::getPhoneCpu,phone.getPhoneCpu())
                .set(PhoneEntity::getPhonePrice,phone.getPhonePrice())
                .set(PhoneEntity::getPhoneImg,phone.getPhoneImg())
                .set(PhoneEntity::getPhoneDescription,phone.getPhoneDescription());
        return mapper.update(null,wrapper);
    }
}
