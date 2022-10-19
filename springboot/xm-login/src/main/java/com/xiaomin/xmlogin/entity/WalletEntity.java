package com.xiaomin.xmlogin.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;

import java.math.BigDecimal;

/**
 * @Author: XiaoMin
 * @PRODUCT_NAME: IntelliJ IDEA
 * @PROJECT_NAME: xm-login
 * @Date_Time: 2022/10/3 11:35
 */
@TableName("tb_wallet")
public class WalletEntity {
    @TableId
    private long walletId;
    @JsonSerialize(using = ToStringSerializer.class)
    //private BigDecimal balance;
    private double balance;

    public WalletEntity() {
    }

    public WalletEntity(long walletId, double balance) {
        this.walletId = walletId;
        this.balance = balance;
    }

    public long getWalletId() {
        return walletId;
    }

    public void setWalletId(long walletId) {
        this.walletId = walletId;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "WalletEntity{" +
                "walletId=" + walletId +
                ", balance=" + balance +
                '}';
    }
}
