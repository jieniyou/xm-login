package com.xiaomin.xmlogin.resp;

/**
 * @Author: XiaoMin
 * @PRODUCT_NAME: IntelliJ IDEA
 * @PROJECT_NAME: xm-login
 * @Date_Time: 2022/10/1 18:13
 */
public class MemberResp {
    private long id;
    private long memberId;
    private long memberLevel;
    private long levelId;
    private String memberName;
    private double memberDiscount;

    public MemberResp() {
    }

    public MemberResp(long id, long memberId, long memberLevel, long levelId, String memberName, double memberDiscount) {
        this.id = id;
        this.memberId = memberId;
        this.memberLevel = memberLevel;
        this.levelId = levelId;
        this.memberName = memberName;
        this.memberDiscount = memberDiscount;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getMemberId() {
        return memberId;
    }

    public void setMemberId(long memberId) {
        this.memberId = memberId;
    }

    public long getMemberLevel() {
        return memberLevel;
    }

    public void setMemberLevel(long memberLevel) {
        this.memberLevel = memberLevel;
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
        return "MemberResp{" +
                "id=" + id +
                ", memberId=" + memberId +
                ", memberLevel=" + memberLevel +
                ", levelId=" + levelId +
                ", memberName='" + memberName + '\'' +
                ", memberDiscount=" + memberDiscount +
                '}';
    }
}
