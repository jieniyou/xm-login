package com.xiaomin.xmloginbackground.controller;

import com.xiaomin.xmloginbackground.entity.PhoneEntity;
import com.xiaomin.xmloginbackground.resp.PhoneInfoResp;
import com.xiaomin.xmloginbackground.service.PhoneInfoService;
import com.xiaomin.xmloginbackground.service.PhoneUpdateService;
import com.xiaomin.xmloginbackground.utils.Result;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Collection;

/**
 * @Author: XiaoMin
 * @PRODUCT_NAME: IntelliJ IDEA
 * @PROJECT_NAME: xm-login-background
 * @Date_Time: 2022/10/13 10:13
 */
@RestController
@RequestMapping("admin")
public class PhoneInfoController {
    @Resource
    private PhoneInfoService service;
    @PostMapping("selectGoods")
    public Result queryGoods(){
        Collection<PhoneInfoResp> phones = service.selectGoods();
        return Result.ok(phones);
    }
    @Resource
    private PhoneUpdateService phoneUpdateService;
    @PostMapping("editGoods")
    public Result updatePhone(@RequestBody PhoneEntity phone){
        int i = phoneUpdateService.editGoods(phone);
        if (i<=0){
            return Result.no("更新失败");
        }else {
            return Result.ok("更新成功");
        }
    }
}
