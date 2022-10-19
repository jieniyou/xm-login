package com.xiaomin.xmloginbackground.entity;


import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("tb_shopping_cart")
public class ShoppingCartEntity {
    //购物id
    @JsonSerialize(using = ToStringSerializer.class)
    @TableId
    private Long shoppingcartId;
    //用户id
    private Long userId;
    //物品id
    private Long goodsId;
    //地址id
    private Long addressId;
    //物品图片
    private String goodsImg;
    //物品名称
    private String goodsName;
    //物品单价
    private Double goodsPrice;
    //物品数量
    private Long goodsNumber;
    //总价格
    private Double goodsTotalPrice;
    //是否付款0未1已
    private byte goodsPayStatus;
    //是否取货
    private byte goodsTakeStatus;
    //是否发货
    private byte goodsDeliveryStatus;

    }

