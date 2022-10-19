package com.xiaomin.xmlogin.entity;

import com.baomidou.mybatisplus.annotation.TableName;

/**
 * @Author: XiaoMin
 * @PRODUCT_NAME: IntelliJ IDEA
 * @PROJECT_NAME: xm-login
 * @Date_Time: 2022/10/1 15:31
 */
@TableName("tb_slideshow")
public class SlideshowEntity {
    private long id;
    private String slideshowName;
    private String slideshowAddress;
    private byte slideshowStatus;

    public SlideshowEntity() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getSlideshowName() {
        return slideshowName;
    }

    public void setSlideshowName(String slideshowName) {
        this.slideshowName = slideshowName;
    }

    public String getSlideshowAddress() {
        return slideshowAddress;
    }

    public void setSlideshowAddress(String slideshowAddress) {
        this.slideshowAddress = slideshowAddress;
    }

    public byte getSlideshowStatus() {
        return slideshowStatus;
    }

    public void setSlideshowStatus(byte slideshowStatus) {
        this.slideshowStatus = slideshowStatus;
    }

    public SlideshowEntity(long id, String slideshowName, String slideshowAddress, byte slideshowStatus) {
        this.id = id;
        this.slideshowName = slideshowName;
        this.slideshowAddress = slideshowAddress;
        this.slideshowStatus = slideshowStatus;
    }

    @Override
    public String toString() {
        return "SlideshowEntity{" +
                "id=" + id +
                ", slideshowName='" + slideshowName + '\'' +
                ", slideshowAddress='" + slideshowAddress + '\'' +
                ", slideshowStatus=" + slideshowStatus +
                '}';
    }
}
