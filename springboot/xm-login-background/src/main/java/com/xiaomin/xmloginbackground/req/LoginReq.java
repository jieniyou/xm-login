package com.xiaomin.xmloginbackground.req;

/**
 * @Author: XiaoMin
 * @PRODUCT_NAME: IntelliJ IDEA
 * @PROJECT_NAME: xm-login-background
 * @Date_Time: 2022/10/11 9:52
 */
public class LoginReq {
    private String account;
    private String password;

    public LoginReq() {
    }

    public LoginReq(String account, String password) {
        this.account = account;
        this.password = password;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "LoginReq{" +
                "account='" + account + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
