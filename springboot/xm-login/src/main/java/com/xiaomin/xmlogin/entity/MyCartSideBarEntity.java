package com.xiaomin.xmlogin.entity;

import com.baomidou.mybatisplus.annotation.TableName;

/**
 * @Author: XiaoMin
 * @PRODUCT_NAME: IntelliJ IDEA
 * @PROJECT_NAME: xm-login
 * @Date_Time: 2022/10/2 14:30
 */
@TableName("tb_mycart_sidebar")
public class MyCartSideBarEntity {
    private long id;
    private String mycartSidebar;
    private String mycartUrl;

    public MyCartSideBarEntity() {
    }

    public MyCartSideBarEntity(long id, String mycartSidebar, String mycartUrl) {
        this.id = id;
        this.mycartSidebar = mycartSidebar;
        this.mycartUrl = mycartUrl;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getMycartSidebar() {
        return mycartSidebar;
    }

    public void setMycartSidebar(String mycartSidebar) {
        this.mycartSidebar = mycartSidebar;
    }

    public String getMycartUrl() {
        return mycartUrl;
    }

    public void setMycartUrl(String mycartUrl) {
        this.mycartUrl = mycartUrl;
    }

    @Override
    public String toString() {
        return "MyCartSideBarEntity{" +
                "id=" + id +
                ", mycartSidebar='" + mycartSidebar + '\'' +
                ", mycartUrl='" + mycartUrl + '\'' +
                '}';
    }
}
