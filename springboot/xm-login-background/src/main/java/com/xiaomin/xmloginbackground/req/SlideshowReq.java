package com.xiaomin.xmloginbackground.req;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: XiaoMin
 * @PRODUCT_NAME: IntelliJ IDEA
 * @PROJECT_NAME: xm-login-background
 * @Date_Time: 2022/10/12 15:12
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SlideshowReq {
    private String slideshowName;
    private String slideshowAddress;
    private byte slideshowStatus;
}
