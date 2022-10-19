package com.xiaomin.xmlogin.entity;

import com.baomidou.mybatisplus.annotation.TableName;

/**
 * @Author: XiaoMin
 * @PRODUCT_NAME: IntelliJ IDEA
 * @PROJECT_NAME: xm-login
 * @Date_Time: 2022/9/30 22:32
 */
@TableName("tb_information")
public class PhoneEntity {
    private long id;
    private long categoryId;
    private String phoneModel;
    private String phoneCpu;
    private double phonePrice;
    private String phoneImg;
    private String phoneDescription;

    public PhoneEntity() {
    }

    public PhoneEntity(long id, long categoryId, String phoneModel, String phoneCpu, double phonePrice, String phoneImg, String phoneDescription) {
        this.id = id;
        this.categoryId = categoryId;
        this.phoneModel = phoneModel;
        this.phoneCpu = phoneCpu;
        this.phonePrice = phonePrice;
        this.phoneImg = phoneImg;
        this.phoneDescription = phoneDescription;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(long categoryId) {
        this.categoryId = categoryId;
    }

    public String getPhoneModel() {
        return phoneModel;
    }

    public void setPhoneModel(String phoneModel) {
        this.phoneModel = phoneModel;
    }

    public String getPhoneCpu() {
        return phoneCpu;
    }

    public void setPhoneCpu(String phoneCpu) {
        this.phoneCpu = phoneCpu;
    }

    public double getPhonePrice() {
        return phonePrice;
    }

    public void setPhonePrice(double phonePrice) {
        this.phonePrice = phonePrice;
    }

    public String getPhoneImg() {
        return phoneImg;
    }

    public void setPhoneImg(String phoneImg) {
        this.phoneImg = phoneImg;
    }

    public String getPhoneDescription() {
        return phoneDescription;
    }

    public void setPhoneDescription(String phoneDescription) {
        this.phoneDescription = phoneDescription;
    }

    @Override
    public String toString() {
        return "PhoneEntity{" +
                "id=" + id +
                ", categoryId=" + categoryId +
                ", phoneModel='" + phoneModel + '\'' +
                ", phoneCpu='" + phoneCpu + '\'' +
                ", phonePrice=" + phonePrice +
                ", phoneImg='" + phoneImg + '\'' +
                ", phoneDescription='" + phoneDescription + '\'' +
                '}';
    }
}
