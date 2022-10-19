package com.xiaomin.xmloginbackground.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.xiaomin.xmloginbackground.entity.SlideshowEntity;
import com.xiaomin.xmloginbackground.mapper.SlideshowMapper;
import com.xiaomin.xmloginbackground.req.SlideshowReq;
import com.xiaomin.xmloginbackground.service.SlideshowService;
import com.xiaomin.xmloginbackground.utils.CopyUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.lang.reflect.InvocationTargetException;
import java.util.Collection;

/**
 * @Author: XiaoMin
 * @PRODUCT_NAME: IntelliJ IDEA
 * @PROJECT_NAME: xm-login-background
 * @Date_Time: 2022/10/12 10:13
 */
@Service
public class SlideshowServiceImpl implements SlideshowService {
    @Resource
    private SlideshowMapper mapper;
    @Override
    public Collection<SlideshowEntity> selectSlideshow() {
        return mapper.selectList(new QueryWrapper<>());
    }

    @Override
    public int insertSlideshow(SlideshowReq req) {
        SlideshowEntity slideshow;
        int i=0;
        try {
            slideshow=CopyUtil.copy(req,SlideshowEntity.class);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        i = mapper.insert(slideshow);
        return i;
    }

    @Override
    public int delSlideshow(long id) {
        int i = mapper.deleteById(id);
        return i;
    }

    @Override
    public int updateSlideshow(long id, byte status) {
        UpdateWrapper<SlideshowEntity> wrapper=new UpdateWrapper<>();
        wrapper.lambda().eq(SlideshowEntity::getId,id).set(SlideshowEntity::getSlideshowStatus,status);
        int i = mapper.update(null, wrapper);
        return i;
    }

    @Override
    public int editSlideshow(SlideshowEntity slideshow) {
        int i = mapper.updateById(slideshow);
        return i;
    }
}
