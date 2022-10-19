package com.xiaomin.xmlogin.controller;

import com.xiaomin.xmlogin.req.WalletReq;
import com.xiaomin.xmlogin.resp.CommonResp;
import com.xiaomin.xmlogin.resp.WalletResp;
import com.xiaomin.xmlogin.service.WalletService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Map;

/**
 * @Author: XiaoMin
 * @PRODUCT_NAME: IntelliJ IDEA
 * @PROJECT_NAME: xm-login
 * @Date_Time: 2022/10/3 12:26
 */
@RestController
public class WalletController {
    @Resource
    private WalletService walletService;
    @PostMapping("queryBalanceById")
    public CommonResp queryBalanceById(@RequestBody Map<String,Long> map){
        CommonResp resp=new CommonResp();
        Long id = map.get("id");
        WalletResp walletResp = walletService.queryBalanceById(id);
        System.out.println("walletResp====>>>"+walletResp);
        resp.setSuccess(true);
        resp.setMessage("钱包加载成功");
        resp.setContent(walletResp);
        return resp;
    }
    @PostMapping("shopping")
    public CommonResp shopping(@RequestBody WalletReq req){
        CommonResp resp=new CommonResp();
        int i = walletService.updateBalanceById(req);
        if (i<=0){
            resp.setSuccess(false);
            resp.setMessage("购买失败");
        }else {
            resp.setSuccess(true);
            resp.setMessage("购买成功");
        }
        return resp;
    }
}
