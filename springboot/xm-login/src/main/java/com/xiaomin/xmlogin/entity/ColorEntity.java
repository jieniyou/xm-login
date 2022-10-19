package com.xiaomin.xmlogin.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 * @Author: XiaoMin
 * @PRODUCT_NAME: IntelliJ IDEA
 * @PROJECT_NAME: xm-login
 * @Date_Time: 2022/10/2 22:05
 */
@TableName("tb_color")
public class ColorEntity {
    @TableId
    private long colorId;
    private String phoneColor;

    public ColorEntity() {
    }

    public ColorEntity(long colorId, String phoneColor) {
        this.colorId = colorId;
        this.phoneColor = phoneColor;
    }

    public long getColorId() {
        return colorId;
    }

    public void setColorId(long colorId) {
        this.colorId = colorId;
    }

    public String getPhoneColor() {
        return phoneColor;
    }

    public void setPhoneColor(String phoneColor) {
        this.phoneColor = phoneColor;
    }

    @Override
    public String toString() {
        return "ColorEntity{" +
                "colorId=" + colorId +
                ", phoneColor='" + phoneColor + '\'' +
                '}';
    }
}
