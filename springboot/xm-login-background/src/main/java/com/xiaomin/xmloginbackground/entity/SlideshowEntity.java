package com.xiaomin.xmloginbackground.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: XiaoMin
 * @PRODUCT_NAME: IntelliJ IDEA
 * @PROJECT_NAME: xm-login-background
 * @Date_Time: 2022/10/12 10:08
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("tb_slideshow")
public class SlideshowEntity {
    /**
     * @JsonSerialize 防止精度丢失
     */
    @TableId
    @JsonSerialize(using = ToStringSerializer.class)
    private long id;
    private String slideshowName;
    private String slideshowAddress;
    private byte slideshowStatus;
}
