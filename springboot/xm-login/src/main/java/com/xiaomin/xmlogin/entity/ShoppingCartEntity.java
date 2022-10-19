package com.xiaomin.xmlogin.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;

/**
 * @Author: XiaoMin
 * @PRODUCT_NAME: IntelliJ IDEA
 * @PROJECT_NAME: xm-login
 * @Date_Time: 2022/10/4 22:31
 */
@TableName("tb_shopping_cart")
public class ShoppingCartEntity {
    @TableId
    @JsonSerialize(using = ToStringSerializer.class)
    private long shoppingcartId;
    @JsonSerialize(using = ToStringSerializer.class)
    private long userId;
    @JsonSerialize(using = ToStringSerializer.class)
    private long goodsId;
    @JsonSerialize(using = ToStringSerializer.class)
    private long addressId;
    private String goodsImg;
    private String goodsName;
    private double goodsPrice;
    private int goodsNumber;
    private double goodsTotalPrice;
    private long goodsPayStatus;
    private long goodsTakeStatus;
    private long goodsDeliveryStatus;

    public ShoppingCartEntity() {
    }

    public ShoppingCartEntity(long shoppingcartId, long userId, long goodsId, long addressId, String goodsImg, String goodsName, double goodsPrice, int goodsNumber, double goodsTotalPrice, long goodsPayStatus, long goodsTakeStatus, long goodsDeliveryStatus) {
        this.shoppingcartId = shoppingcartId;
        this.userId = userId;
        this.goodsId = goodsId;
        this.addressId = addressId;
        this.goodsImg = goodsImg;
        this.goodsName = goodsName;
        this.goodsPrice = goodsPrice;
        this.goodsNumber = goodsNumber;
        this.goodsTotalPrice = goodsTotalPrice;
        this.goodsPayStatus = goodsPayStatus;
        this.goodsTakeStatus = goodsTakeStatus;
        this.goodsDeliveryStatus = goodsDeliveryStatus;
    }

    public long getShoppingcartId() {
        return shoppingcartId;
    }

    public void setShoppingcartId(long shoppingcartId) {
        this.shoppingcartId = shoppingcartId;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public long getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(long goodsId) {
        this.goodsId = goodsId;
    }

    public long getAddressId() {
        return addressId;
    }

    public void setAddressId(long addressId) {
        this.addressId = addressId;
    }

    public String getGoodsImg() {
        return goodsImg;
    }

    public void setGoodsImg(String goodsImg) {
        this.goodsImg = goodsImg;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public double getGoodsPrice() {
        return goodsPrice;
    }

    public void setGoodsPrice(double goodsPrice) {
        this.goodsPrice = goodsPrice;
    }

    public int getGoodsNumber() {
        return goodsNumber;
    }

    public void setGoodsNumber(int goodsNumber) {
        this.goodsNumber = goodsNumber;
    }

    public double getGoodsTotalPrice() {
        return goodsTotalPrice;
    }

    public void setGoodsTotalPrice(double goodsTotalPrice) {
        this.goodsTotalPrice = goodsTotalPrice;
    }

    public long getGoodsPayStatus() {
        return goodsPayStatus;
    }

    public void setGoodsPayStatus(long goodsPayStatus) {
        this.goodsPayStatus = goodsPayStatus;
    }

    public long getGoodsTakeStatus() {
        return goodsTakeStatus;
    }

    public void setGoodsTakeStatus(long goodsTakeStatus) {
        this.goodsTakeStatus = goodsTakeStatus;
    }

    public long getGoodsDeliveryStatus() {
        return goodsDeliveryStatus;
    }

    public void setGoodsDeliveryStatus(long goodsDeliveryStatus) {
        this.goodsDeliveryStatus = goodsDeliveryStatus;
    }

    @Override
    public String toString() {
        return "ShoppingCartEntity{" +
                "shoppingcartId=" + shoppingcartId +
                ", userId=" + userId +
                ", goodsId=" + goodsId +
                ", addressId=" + addressId +
                ", goodsImg='" + goodsImg + '\'' +
                ", goodsName='" + goodsName + '\'' +
                ", goodsPrice=" + goodsPrice +
                ", goodsNumber=" + goodsNumber +
                ", goodsTotalPrice=" + goodsTotalPrice +
                ", goodsPayStatus=" + goodsPayStatus +
                ", goodsTakeStatus=" + goodsTakeStatus +
                ", goodsDeliveryStatus=" + goodsDeliveryStatus +
                '}';
    }
}
