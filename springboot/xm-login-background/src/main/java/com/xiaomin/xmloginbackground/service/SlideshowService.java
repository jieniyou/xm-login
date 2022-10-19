package com.xiaomin.xmloginbackground.service;

import com.xiaomin.xmloginbackground.entity.SlideshowEntity;
import com.xiaomin.xmloginbackground.req.SlideshowReq;

import java.util.Collection;

/**
 * @Author: XiaoMin
 * @PRODUCT_NAME: IntelliJ IDEA
 * @PROJECT_NAME: xm-login-background
 * @Date_Time: 2022/10/12 10:13
 */
public interface SlideshowService {
    Collection<SlideshowEntity> selectSlideshow();
    int insertSlideshow(SlideshowReq req);
    int delSlideshow(long id);
    int updateSlideshow(long id,byte status);
    int editSlideshow(SlideshowEntity slideshow);
}
