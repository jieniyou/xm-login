package com.xiaomin.xmlogin.controller;

import com.xiaomin.xmlogin.resp.CommonResp;
import com.xiaomin.xmlogin.resp.GoodsDetailsResp;
import com.xiaomin.xmlogin.service.GoodsDetailsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Map;

/**
 * @Author: XiaoMin
 * @PRODUCT_NAME: IntelliJ IDEA
 * @PROJECT_NAME: xm-login
 * @Date_Time: 2022/10/2 22:41
 */
@RestController
public class GoodsDetailsController {
    @Resource
    private GoodsDetailsService goodsDetailsService;

    @PostMapping("queryGoodsDetailsId")
    public CommonResp queryGoodsDetailsId(@RequestBody Map<String,Long> map){
        CommonResp resp=new CommonResp();
        Long id = map.get("id");
        GoodsDetailsResp goods = goodsDetailsService.queryGoodsDetailsById(id);
        resp.setSuccess(true);
        resp.setMessage("数据加载成功");
        resp.setContent(goods);
        System.out.println("goods===>"+goods);
        System.out.println("resp===>"+resp.getContent());
        return resp;

    }
}
