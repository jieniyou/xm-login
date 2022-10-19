package com.xiaomin.xmlogin.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 * @Author: XiaoMin
 * @PRODUCT_NAME: IntelliJ IDEA
 * @PROJECT_NAME: xm-login
 * @Date_Time: 2022/10/2 22:10
 */
@TableName("tb_origin")
public class OriginEntity {
    @TableId
    private long originId;
    private String categoryOrigin;

    public OriginEntity() {
    }

    public OriginEntity(long originId, String categoryOrigin) {
        this.originId = originId;
        this.categoryOrigin = categoryOrigin;
    }

    public long getOriginId() {
        return originId;
    }

    public void setOriginId(long originId) {
        this.originId = originId;
    }

    public String getCategoryOrigin() {
        return categoryOrigin;
    }

    public void setCategoryOrigin(String categoryOrigin) {
        this.categoryOrigin = categoryOrigin;
    }

    @Override
    public String toString() {
        return "OriginEntity{" +
                "originId=" + originId +
                ", categoryOrigin='" + categoryOrigin + '\'' +
                '}';
    }
}
