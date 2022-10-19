package com.xiaomin.xmloginbackground.resp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: XiaoMin
 * @PRODUCT_NAME: IntelliJ IDEA
 * @PROJECT_NAME: xm-login-background
 * @Date_Time: 2022/10/13 11:06
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DeliverGoodsResp {
    //id
    private Long shoppingcartId;
    //物品id
    private Long goodsId;
    //物品名称
    private String goodsName;
    //物品单价
    private Double goodsPrice;
    //物品数量
    private Long goodsNumber;
    //总价格
    private Double goodsTotalPrice;
    //是否发货
    private byte goodsDeliveryStatus;
}
