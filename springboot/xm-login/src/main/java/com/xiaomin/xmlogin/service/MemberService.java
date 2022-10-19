package com.xiaomin.xmlogin.service;

import com.xiaomin.xmlogin.resp.MemberResp;

/**
 * @Author: XiaoMin
 * @PRODUCT_NAME: IntelliJ IDEA
 * @PROJECT_NAME: xm-login
 * @Date_Time: 2022/10/1 18:12
 */
public interface MemberService {
    MemberResp queryMemberByUserId(long id);
}
