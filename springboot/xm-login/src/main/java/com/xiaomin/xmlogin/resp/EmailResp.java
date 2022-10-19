package com.xiaomin.xmlogin.resp;

/**
 * @Author: XiaoMin
 * @PRODUCT_NAME: IntelliJ IDEA
 * @PROJECT_NAME: xm-login
 * @Date_Time: 2022/9/23 18:22
 */
public class EmailResp {
    private String emailAddress;
    private String code;

    public EmailResp() {
    }

    public EmailResp(String emailAddress, String code) {
        this.emailAddress = emailAddress;
        this.code = code;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "EmailResp{" +
                "emailAddress='" + emailAddress + '\'' +
                ", code='" + code + '\'' +
                '}';
    }
}
