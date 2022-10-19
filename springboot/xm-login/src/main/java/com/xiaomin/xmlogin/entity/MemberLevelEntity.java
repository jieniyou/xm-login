package com.xiaomin.xmlogin.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 * @Author: XiaoMin
 * @PRODUCT_NAME: IntelliJ IDEA
 * @PROJECT_NAME: xm-login
 * @Date_Time: 2022/10/1 18:05
 */
@TableName("tb_member_level")
public class MemberLevelEntity {
    @TableId
    private long levelId;
    private String memberName;
    private double memberDiscount;

    public MemberLevelEntity() {
    }

    public MemberLevelEntity(long levelId, String memberName, double memberDiscount) {
        this.levelId = levelId;
        this.memberName = memberName;
        this.memberDiscount = memberDiscount;
    }

    public long getLevelId() {
        return levelId;
    }

    public void setLevelId(long levelId) {
        this.levelId = levelId;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public double getMemberDiscount() {
        return memberDiscount;
    }

    public void setMemberDiscount(double memberDiscount) {
        this.memberDiscount = memberDiscount;
    }

    @Override
    public String toString() {
        return "MemberLevelEntity{" +
                "levelId=" + levelId +
                ", memberName='" + memberName + '\'' +
                ", memberDiscount=" + memberDiscount +
                '}';
    }
}
