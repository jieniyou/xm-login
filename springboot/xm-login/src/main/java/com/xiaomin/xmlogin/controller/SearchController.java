package com.xiaomin.xmlogin.controller;

import com.xiaomin.xmlogin.entity.PhoneEntity;
import com.xiaomin.xmlogin.resp.CommonResp;
import com.xiaomin.xmlogin.service.SearchService;
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
 * @Date_Time: 2022/10/2 20:07
 */
@RestController
public class SearchController {
    @Resource
    private SearchService searchService;
    Collection<PhoneEntity> phones = null;

    @PostMapping("queryPhoneByModel")
    public CommonResp queryPhoneByModel(@RequestBody Map<String,String> map){
        CommonResp resp=new CommonResp();
        String model=map.get("model");
        try {
            phones = searchService.queryPhoneByModel(model);
            if (phones != null) {
                resp.setSuccess(true);
                resp.setMessage("搜索成功");
                resp.setContent(phones);
                System.err.println(resp);
            }else {
                resp.setSuccess(false);
                resp.setMessage("搜索结果为空");
            }
        } catch (Exception e) {
            resp.setSuccess(false);
            resp.setMessage("搜索异常");
        }
        return resp;
    }
    @PostMapping("queryPhoneByCategoryId")
    public CommonResp queryPhoneByCategoryId(@RequestBody Map<String,Long> map){
        CommonResp resp=new CommonResp();
        Long id=map.get("categoryId");
        try {
            phones = searchService.queryPhoneByCategory(id);
            if (phones != null) {
                resp.setSuccess(true);
                resp.setMessage("搜索成功");
                resp.setContent(phones);
                System.err.println(resp);
            }else {
                resp.setSuccess(false);
                resp.setMessage("搜索结果为空");
            }
        } catch (Exception e) {
            resp.setSuccess(false);
            resp.setMessage("搜索异常");
        }
        return resp;
    }
}
