package com.xiaomin.xmlogin.service;

import com.xiaomin.xmlogin.entity.CategoryEntity;
import com.xiaomin.xmlogin.entity.PhoneEntity;
import com.xiaomin.xmlogin.entity.SlideshowEntity;

import java.util.Collection;

/**
 * @Author: XiaoMin
 * @PRODUCT_NAME: IntelliJ IDEA
 * @PROJECT_NAME: xm-login
 * @Date_Time: 2022/10/1 15:35
 */
public interface IndexService {
    Collection<CategoryEntity> queryCategory();
    Collection<PhoneEntity> queryAllPhone();
    Collection<SlideshowEntity> queryAllSlideshow();
}
