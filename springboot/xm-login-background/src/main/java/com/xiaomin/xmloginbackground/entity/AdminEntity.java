package com.xiaomin.xmloginbackground.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;

/**
 * @Author: XiaoMin
 * @PRODUCT_NAME: IntelliJ IDEA
 * @PROJECT_NAME: xm-login-background
 * @Date_Time: 2022/10/10 17:46
 */
@TableName("tb_admin")
public class AdminEntity {
    /**
     * @JsonSerialize 防止精度丢失
     */
    @JsonSerialize(using = ToStringSerializer.class)
    @TableId
    private long id;
    private String account;
    private String password;
    private byte identity;

    public AdminEntity() {
    }

    public AdminEntity(long id, String account, String password, byte identity) {
        this.id = id;
        this.account = account;
        this.password = password;
        this.identity = identity;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public byte getIdentity() {
        return identity;
    }

    public void setIdentity(byte identity) {
        this.identity = identity;
    }

    @Override
    public String toString() {
        return "AdminEntity{" +
                "id=" + id +
                ", account='" + account + '\'' +
                ", password='" + password + '\'' +
                ", identity=" + identity +
                '}';
    }
}
