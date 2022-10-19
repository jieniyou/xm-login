package com.xiaomin.xmlogin.controller;

import com.xiaomin.xmlogin.resp.CommonResp;
import com.xiaomin.xmlogin.resp.MemberResp;
import com.xiaomin.xmlogin.service.MemberService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Map;

/**
 * @Author: XiaoMin
 * @PRODUCT_NAME: IntelliJ IDEA
 * @PROJECT_NAME: xm-login
 * @Date_Time: 2022/10/1 18:45
 */
@RestController
public class MemberController {
    @Resource
    private MemberService memberService;

    @PostMapping("getMember")
    public CommonResp queryMemberByUserId(@RequestBody Map<String,Long> map){
        CommonResp resp=new CommonResp();
        Long id = map.get("id");
        System.out.println(id);
        try{
            MemberResp memberResp = memberService.queryMemberByUserId(id);
            resp.setSuccess(true);
            resp.setMessage("会员信息加载成功");
            resp.setContent(memberResp);
        }catch (Exception e){
            resp.setSuccess(false);
            resp.setMessage("会员信息加载失败");
        }
        return resp;
    }
}
