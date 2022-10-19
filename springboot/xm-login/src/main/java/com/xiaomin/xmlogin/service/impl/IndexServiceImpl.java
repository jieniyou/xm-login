package com.xiaomin.xmlogin.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.ObjectUtils;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.xiaomin.xmlogin.entity.CategoryEntity;
import com.xiaomin.xmlogin.entity.PhoneEntity;
import com.xiaomin.xmlogin.entity.SlideshowEntity;
import com.xiaomin.xmlogin.mapper.CategoryMapper;
import com.xiaomin.xmlogin.mapper.PhoneMapper;
import com.xiaomin.xmlogin.mapper.SlideshowMapper;
import com.xiaomin.xmlogin.service.IndexService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.List;

/**
 * @Author: XiaoMin
 * @PRODUCT_NAME: IntelliJ IDEA
 * @PROJECT_NAME: xm-login
 * @Date_Time: 2022/10/1 15:36
 */
@Service
public class IndexServiceImpl implements IndexService {
    @Resource
    private CategoryMapper categoryMapper;
    @Override
    public Collection<CategoryEntity> queryCategory() {
        return categoryMapper.selectList(new QueryWrapper<>());
    }
    @Resource
    private PhoneMapper phoneMapper;
    @Override
    public Collection<PhoneEntity> queryAllPhone() {
        return phoneMapper.selectList(new QueryWrapper<>());
    }
    @Resource
    private SlideshowMapper slideshowMapper;
    @Override
    public Collection<SlideshowEntity> queryAllSlideshow() {
        return slideshowMapper.selectList(new QueryWrapper<>());
    }
}
