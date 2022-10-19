package com.xiaomin.xmlogin.entity;

import com.baomidou.mybatisplus.annotation.TableName;

/**
 * @Author: XiaoMin
 * @PRODUCT_NAME: IntelliJ IDEA
 * @PROJECT_NAME: xm-login
 * @Date_Time: 2022/10/2 22:12
 */
@TableName("tb_phone_color_ms_origin")
public class PhoneColorMsOriginEntity {
    private long id;
    private long phoneId;
    private long colorId;
    private long msId;
    private long originId;

    public PhoneColorMsOriginEntity() {
    }

    public PhoneColorMsOriginEntity(long id, long phoneId, long colorId, long msId, long originId) {
        this.id = id;
        this.phoneId = phoneId;
        this.colorId = colorId;
        this.msId = msId;
        this.originId = originId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getPhoneId() {
        return phoneId;
    }

    public void setPhoneId(long phoneId) {
        this.phoneId = phoneId;
    }

    public long getColorId() {
        return colorId;
    }

    public void setColorId(long colorId) {
        this.colorId = colorId;
    }

    public long getMsId() {
        return msId;
    }

    public void setMsId(long msId) {
        this.msId = msId;
    }

    public long getOriginId() {
        return originId;
    }

    public void setOriginId(long originId) {
        this.originId = originId;
    }

    @Override
    public String toString() {
        return "PhoneColorMsOriginEntity{" +
                "id=" + id +
                ", phoneId=" + phoneId +
                ", colorId=" + colorId +
                ", msId=" + msId +
                ", originId=" + originId +
                '}';
    }
}
