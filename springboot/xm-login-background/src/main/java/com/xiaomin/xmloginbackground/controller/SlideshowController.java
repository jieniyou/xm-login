package com.xiaomin.xmloginbackground.controller;

import com.xiaomin.xmloginbackground.entity.SlideshowEntity;
import com.xiaomin.xmloginbackground.req.SlideshowReq;
import com.xiaomin.xmloginbackground.service.SlideshowService;
import com.xiaomin.xmloginbackground.utils.Result;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.Map;

/**
 * @Author: XiaoMin
 * @PRODUCT_NAME: IntelliJ IDEA
 * @PROJECT_NAME: xm-login-background
 * @Date_Time: 2022/10/12 10:16
 */
@RestController
@RequestMapping("admin")
public class SlideshowController {
    @Resource
    private SlideshowService service;

    @PostMapping("selectSlideshow")
    public Result querySlideshow(){
        Collection<SlideshowEntity> slideshow = service.selectSlideshow();
        if (ObjectUtils.isEmpty(slideshow)) {
            return Result.no();
        }else {
            return Result.ok(slideshow);
        }
    }
    @PostMapping("insertSlideshow")
    public Result addSlideshow(@RequestBody SlideshowReq req){
        int i = service.insertSlideshow(req);
        if (i<=0){
            return Result.no("添加失败");
        }else {
            return Result.ok("添加成功");
        }

    }
    @PostMapping("delSlideshow")
    public Result removeSlideshow(@RequestBody Map<String,Long> map){
        Long id = map.get("id");
        int i = service.delSlideshow(id);
        if (i<=0){
            return Result.no("删除失败");
        }else {
            return Result.ok("删除成功");
        }
    }
    @PostMapping("updateSlideshow")
    public Result changeSlideshow(@RequestBody Map<String,Long> map){
        Long id = map.get("id");
        Byte slideshowStatus =Byte.parseByte(String.valueOf(map.get("slideshowStatus")));
        int i = service.updateSlideshow(id, slideshowStatus);
        if (i<=0){
            return Result.no("操作失败");
        }else {
            return Result.ok("操作成功");
        }
    }
    @PostMapping("editSlideshow")
    public Result updateSlideshow(@RequestBody SlideshowEntity slideshow){
        int i = service.editSlideshow(slideshow);
        if (i<=0){
            return Result.no("更新失败");
        }else {
            return Result.ok("更新成功");
        }

    }
}
