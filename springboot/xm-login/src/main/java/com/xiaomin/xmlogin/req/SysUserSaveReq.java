package com.xiaomin.xmlogin.req;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;

import java.util.Date;

/**
 * @Author: XiaoMin
 * @PRODUCT_NAME: IntelliJ IDEA
 * @PROJECT_NAME: xm-login
 * @Date_Time: 2022/9/20 17:59
 */
public class SysUserSaveReq {
    @JsonSerialize(using = ToStringSerializer.class)
    private Long id;
    private String userName;
    private String netName;
    private String password;
    private String email;
    private Date createdDate;
    private String code;

    public SysUserSaveReq() {
    }

    public SysUserSaveReq(Long id, String userName, String netName, String password, String email, Date createdDate, String code) {
        this.id = id;
        this.userName = userName;
        this.netName = netName;
        this.password = password;
        this.email = email;
        this.createdDate = createdDate;
        this.code = code;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getNetName() {
        return netName;
    }

    public void setNetName(String netName) {
        this.netName = netName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "SysUserSaveReq{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", netName='" + netName + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", createdDate=" + createdDate +
                ", code='" + code + '\'' +
                '}';
    }
}
