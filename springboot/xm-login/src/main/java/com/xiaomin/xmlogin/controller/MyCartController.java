package com.xiaomin.xmlogin.controller;

import com.xiaomin.xmlogin.entity.MyCartSideBarEntity;
import com.xiaomin.xmlogin.resp.CommonResp;
import com.xiaomin.xmlogin.service.MyCartSideBarService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Collection;

/**
 * @Author: XiaoMin
 * @PRODUCT_NAME: IntelliJ IDEA
 * @PROJECT_NAME: xm-login
 * @Date_Time: 2022/10/2 14:39
 */
@RestController
public class MyCartController {
    @Resource
    private MyCartSideBarService cartsService;
    @PostMapping("queryAllCart")
    public CommonResp queryAllCart(){
        CommonResp resp=new CommonResp();
        Collection<MyCartSideBarEntity> carts = cartsService.queryAllCart();
        resp.setSuccess(true);
        resp.setMessage("初心侧边栏数据加载成功");
        resp.setContent(carts);
        return resp;
    }
}
