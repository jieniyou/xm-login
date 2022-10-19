package com.xiaomin.xmloginbackground.controller;

import com.xiaomin.xmloginbackground.resp.DeliverGoodsResp;
import com.xiaomin.xmloginbackground.service.DeliverGoodsService;
import com.xiaomin.xmloginbackground.utils.Result;
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
 * @Date_Time: 2022/10/13 11:08
 */
@RestController
@RequestMapping("admin")
public class DeliverGoodsController {
    @Resource
    private DeliverGoodsService service;
    @PostMapping("selectDeliverGoods")
    public Result queryDeliverGoods(){
        Collection<DeliverGoodsResp> deliverGoods = service.queryDeliverGoods();
        return Result.ok(deliverGoods);
    }
    @PostMapping("updateDeliverGoods")
    public Result changeDeliverGoodsStatus(@RequestBody Map<String,Long> map){
        Long id = map.get("shoppingcartId");
        Byte status = Byte.parseByte(String.valueOf(map.get("goodsDeliveryStatus")));
        System.out.println("id=====>"+id);
        System.out.println("status=====>"+status);
        int i = service.updateDeliverGoods(id, status);
        if (i<=0){
            return Result.no("发货失败");
        }else {
            return Result.ok("发货成功");
        }
    }
}
