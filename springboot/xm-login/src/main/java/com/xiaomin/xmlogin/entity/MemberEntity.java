package com.xiaomin.xmlogin.entity;

import com.baomidou.mybatisplus.annotation.TableName;

/**
 * @Author: XiaoMin
 * @PRODUCT_NAME: IntelliJ IDEA
 * @PROJECT_NAME: xm-login
 * @Date_Time: 2022/10/1 18:04
 */
@TableName("tb_member")
public class MemberEntity {
    private long id;
    private long memberId;
    private long memberLevel;

    public MemberEntity() {
    }

    public MemberEntity(long id, long memberId, long memberLevel) {
        this.id = id;
        this.memberId = memberId;
        this.memberLevel = memberLevel;
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

    @Override
    public String toString() {
        return "MemberEntity{" +
                "id=" + id +
                ", memberId=" + memberId +
                ", memberLevel=" + memberLevel +
                '}';
    }
}
