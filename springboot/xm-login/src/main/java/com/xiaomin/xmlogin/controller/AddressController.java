package com.xiaomin.xmlogin.controller;

import com.xiaomin.xmlogin.entity.AddressEntity;
import com.xiaomin.xmlogin.resp.CommonResp;
import com.xiaomin.xmlogin.service.AddressService;
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
 * @Date_Time: 2022/10/4 11:08
 */
@RestController
public class AddressController {
    @Resource
    private AddressService addressService;
    @PostMapping("getAddressByUserId")
    public CommonResp queryAddressByUserId(@RequestBody Map<String,Long> map){
        CommonResp resp=new CommonResp();
        Long id = map.get("id");
        Collection<AddressEntity> addresses = addressService.queryAddressByUserId(id);
        resp.setSuccess(true);
        resp.setMessage("地址信息加载成功");
        resp.setContent(addresses);
        return resp;
    }
    @PostMapping("addAddress")
    public CommonResp insertAddress(@RequestBody AddressEntity address){
        CommonResp resp=new CommonResp();
        int i = addressService.insertAddress(address);
        if (i<=0) {
            resp.setSuccess(false);
            resp.setMessage("地址信息添加失败");
        }else{
            resp.setSuccess(true);
            resp.setMessage("地址信息添加成功");
        }
        return resp;
    }
    @PostMapping("delAddressByUserId")
    public CommonResp updateAddressByAddressId(@RequestBody Map<String,Long> map){
        CommonResp resp=new CommonResp();
        long id = map.get("addressId");
        int i = addressService.updateAddressByAddressId(id);
        resp.setSuccess(true);
        resp.setMessage("地址信息删除成功");
        return resp;
    }
}
