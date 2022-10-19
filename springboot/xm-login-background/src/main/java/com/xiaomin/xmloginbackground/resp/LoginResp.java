package com.xiaomin.xmloginbackground.resp;

/**
 * @Author: XiaoMin
 * @PRODUCT_NAME: IntelliJ IDEA
 * @PROJECT_NAME: xm-login-background
 * @Date_Time: 2022/10/11 9:52
 */
public class LoginResp {
    private String account;
    private String password;
    private byte identity;

    private String token;

    public LoginResp() {
    }

    public LoginResp(String account, String password, byte identity, String token) {
        this.account = account;
        this.password = password;
        this.identity = identity;
        this.token = token;
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

    public byte getIdentity() {
        return identity;
    }
    public void setIdentity(byte identity) {
        this.identity = identity;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public String toString() {
        return "LoginResp{" +
                "account='" + account + '\'' +
                ", password='" + password + '\'' +
                ", identity=" + identity +
                ", token='" + token + '\'' +
                '}';
    }


}
