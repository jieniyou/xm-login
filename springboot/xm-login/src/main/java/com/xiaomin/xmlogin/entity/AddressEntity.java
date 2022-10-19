package com.xiaomin.xmlogin.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;

/**
 * @Author: XiaoMin
 * @PRODUCT_NAME: IntelliJ IDEA
 * @PROJECT_NAME: xm-login
 * @Date_Time: 2022/10/4 10:32
 */
@TableName("tb_address")
public class AddressEntity {
    @TableId
    private long addressId;
    @JsonSerialize(using = ToStringSerializer.class)
    private long userId;
    private String address;
    private String addressStreet;
    private String postalCode;
    private String consigneeName;
    private String addressPhone;
    private byte addressStatus;

    public AddressEntity() {
    }

    public AddressEntity(long addressId, long userId, String address, String addressStreet, String postalCode, String consigneeName, String addressPhone, byte addressStatus) {
        this.addressId = addressId;
        this.userId = userId;
        this.address = address;
        this.addressStreet = addressStreet;
        this.postalCode = postalCode;
        this.consigneeName = consigneeName;
        this.addressPhone = addressPhone;
        this.addressStatus = addressStatus;
    }

    public long getAddressId() {
        return addressId;
    }

    public void setAddressId(long addressId) {
        this.addressId = addressId;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddressStreet() {
        return addressStreet;
    }

    public void setAddressStreet(String addressStreet) {
        this.addressStreet = addressStreet;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getConsigneeName() {
        return consigneeName;
    }

    public void setConsigneeName(String consigneeName) {
        this.consigneeName = consigneeName;
    }

    public String getAddressPhone() {
        return addressPhone;
    }

    public void setAddressPhone(String addressPhone) {
        this.addressPhone = addressPhone;
    }

    public byte getAddressStatus() {
        return addressStatus;
    }

    public void setAddressStatus(byte addressStatus) {
        this.addressStatus = addressStatus;
    }

    @Override
    public String toString() {
        return "AddressEntity{" +
                "addressId=" + addressId +
                ", userId=" + userId +
                ", address='" + address + '\'' +
                ", addressStreet='" + addressStreet + '\'' +
                ", postalCode='" + postalCode + '\'' +
                ", consigneeName='" + consigneeName + '\'' +
                ", addressPhone='" + addressPhone + '\'' +
                ", addressStatus=" + addressStatus +
                '}';
    }
}
