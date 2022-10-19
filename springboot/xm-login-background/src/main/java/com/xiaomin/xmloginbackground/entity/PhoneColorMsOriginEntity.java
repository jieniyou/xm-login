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
 * @Date_Time: 2022/10/13 9:06
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("tb_phone_color_ms_origin")
public class PhoneColorMsOriginEntity {
    @TableId
    @JsonSerialize(using = ToStringSerializer.class)
    private long id;
    private long phoneId;
    private long colorId;
    private long msId;
    private long originId;
}
