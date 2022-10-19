package com.xiaomin.xmlogin.controller;

import com.xiaomin.xmlogin.entity.ShoppingCartEntity;
import com.xiaomin.xmlogin.req.WalletReq;
import com.xiaomin.xmlogin.resp.CommonResp;
import com.xiaomin.xmlogin.service.ShoppingCartService;
import com.xiaomin.xmlogin.service.WalletService;
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
 * @Date_Time: 2022/10/4 22:55
 */
@RestController
public class ShoppingCartController {
    @Resource
    private ShoppingCartService service;
    @PostMapping("getShoppingCartByUserId")
    public CommonResp queryShoppingCartByUserId(@RequestBody Map<String,Long> map) {
        CommonResp resp = new CommonResp();
        Long id = map.get("id");
        Collection<ShoppingCartEntity> list = service.queryShoppingCartByUserId(id);
        resp.setSuccess(true);
        resp.setMessage("数据加载成功");
        resp.setContent(list);
        return resp;
    }
    @PostMapping("addShoppingCart")
    public CommonResp insertShoppingCart(@RequestBody ShoppingCartEntity shoppingCart){
        CommonResp resp=new CommonResp();
        int i = service.addShoppingCart(shoppingCart);
        if (i<=0){
            resp.setSuccess(false);
            resp.setMessage("购买失败");
        }else {
            resp.setSuccess(true);
            resp.setMessage("购买成功");
        }
        return resp;
    }
    @PostMapping("settlementById")
    public CommonResp settlementById(@RequestBody Map<String,Long> map){
        CommonResp resp=new CommonResp();
        Long id = map.get("shoppingcartId");
        int i = service.updateShoppingCartById(id);
        if (i<=0){
            resp.setSuccess(false);
            resp.setMessage("结算失败");
        }else {
            resp.setSuccess(true);
            resp.setMessage("结算成功");
        }
        return resp;
    }

    @PostMapping("gotoPay")
    public CommonResp gotoPay(@RequestBody WalletReq req){
        System.out.println("WalletReq gotoPay===>"+req);
        CommonResp resp=new CommonResp();
        int i = service.updateBalanceById(req);
        if (i<=0){
            resp.setSuccess(false);
            resp.setMessage("购买失败");
        }else {
            resp.setSuccess(true);
            resp.setMessage("购买成功");
        }
        return resp;
    }

    @PostMapping("delShoppingcartById")
    public CommonResp delShoppingcartById(@RequestBody Map<String,Long> map){
        CommonResp resp=new CommonResp();
        Long id = map.get("shoppingcartId");
        int i = service.deleteShoppingCartById(id);
        if (i<=0){
            resp.setSuccess(false);
            resp.setMessage("删除失败");
        }else {
            resp.setSuccess(true);
            resp.setMessage("删除成功");
        }
        return resp;
    }

    @PostMapping("updateTakeStatus")
    public CommonResp updateTakeStatusById(@RequestBody Map<String,Long> map){
        CommonResp resp=new CommonResp();
        Long id = map.get("shoppingcartId");
        int i = service.updateTakeStatusById(id);
        if (i<=0){
            resp.setSuccess(false);
            resp.setMessage("收货失败");
        }else {
            resp.setSuccess(true);
            resp.setMessage("收货成功");
        }
        return resp;
    }
}
