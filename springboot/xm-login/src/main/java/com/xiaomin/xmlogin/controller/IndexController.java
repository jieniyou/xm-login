package com.xiaomin.xmlogin.controller;

import com.xiaomin.xmlogin.entity.CategoryEntity;
import com.xiaomin.xmlogin.entity.PhoneEntity;
import com.xiaomin.xmlogin.entity.SlideshowEntity;
import com.xiaomin.xmlogin.resp.CommonResp;
import com.xiaomin.xmlogin.service.IndexService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.Map;

/**
 * @Author: XiaoMin
 * @PRODUCT_NAME: IntelliJ IDEA
 * @PROJECT_NAME: xm-login
 * @Date_Time: 2022/10/1 15:38
 */
@RestController
public class IndexController {
    @Resource
    private IndexService indexService;

    @PostMapping("queryCategory")
    public CommonResp queryCategory(){
        CommonResp commonResp=new CommonResp();
        Collection<CategoryEntity> categories = indexService.queryCategory();
        commonResp.setSuccess(true);
        commonResp.setContent(categories);
        return commonResp;
    }
    @PostMapping("phone/getAll")
    public CommonResp queryAllPhone(){
        CommonResp resp=new CommonResp();
        Collection<PhoneEntity> phones = indexService.queryAllPhone();
        resp.setSuccess(true);
        resp.setMessage("数据加载成功");
        resp.setContent(phones);
        System.out.println(phones);
        return resp;
    }
    @PostMapping("getSlideshow")
    public CommonResp queryAllSlideshow(){
        CommonResp resp=new CommonResp();
        Collection<SlideshowEntity> slideshows = indexService.queryAllSlideshow();
        resp.setSuccess(true);
        resp.setMessage("轮播图加载成功");
        resp.setContent(slideshows);
        return resp;
    }
}
