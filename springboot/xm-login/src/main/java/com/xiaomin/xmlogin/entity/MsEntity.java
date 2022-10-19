package com.xiaomin.xmlogin.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 * @Author: XiaoMin
 * @PRODUCT_NAME: IntelliJ IDEA
 * @PROJECT_NAME: xm-login
 * @Date_Time: 2022/10/2 22:08
 */
@TableName("tb_ms")
public class MsEntity {
    @TableId
    private long msId;
    private String msMemory;
    private String msSignals;

    public MsEntity() {
    }

    public MsEntity(long msId, String msMemory, String msSignals) {
        this.msId = msId;
        this.msMemory = msMemory;
        this.msSignals = msSignals;
    }

    public long getMsId() {
        return msId;
    }

    public void setMsId(long msId) {
        this.msId = msId;
    }

    public String getMsMemory() {
        return msMemory;
    }

    public void setMsMemory(String msMemory) {
        this.msMemory = msMemory;
    }

    public String getMsSignals() {
        return msSignals;
    }

    public void setMsSignals(String msSignals) {
        this.msSignals = msSignals;
    }

    @Override
    public String toString() {
        return "MsEntity{" +
                "msId=" + msId +
                ", msMemory='" + msMemory + '\'' +
                ", msSignals='" + msSignals + '\'' +
                '}';
    }
}
