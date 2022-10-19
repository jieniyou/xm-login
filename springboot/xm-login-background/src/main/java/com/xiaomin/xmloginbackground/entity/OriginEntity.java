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
 * @Date_Time: 2022/10/13 8:59
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("tb_origin")
public class OriginEntity {
    @TableId
    @JsonSerialize(using = ToStringSerializer.class)
    private long originId;
    private String categoryOrigin;
}
