package com.xiaomin.xmloginbackground.resp;

import com.xiaomin.xmloginbackground.entity.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;

/**
 * @Author: XiaoMin
 * @PRODUCT_NAME: IntelliJ IDEA
 * @PROJECT_NAME: xm-login-background
 * @Date_Time: 2022/10/13 9:12
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PhoneInfoResp {
    private PhoneEntity phone;
    private CategoryEntity category;
    private ColorEntity colors;
    private MsEntity mss;
    private OriginEntity origins;
}
