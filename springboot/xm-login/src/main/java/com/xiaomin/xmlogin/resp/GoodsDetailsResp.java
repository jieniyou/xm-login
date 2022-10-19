package com.xiaomin.xmlogin.resp;

import com.xiaomin.xmlogin.entity.ColorEntity;
import com.xiaomin.xmlogin.entity.MsEntity;
import com.xiaomin.xmlogin.entity.OriginEntity;
import com.xiaomin.xmlogin.entity.PhoneEntity;

import java.util.Collection;

/**
 * @Author: XiaoMin
 * @PRODUCT_NAME: IntelliJ IDEA
 * @PROJECT_NAME: xm-login
 * @Date_Time: 2022/10/2 22:19
 */
public class GoodsDetailsResp {
    /** phone */
    private PhoneEntity phone;
    /** color */
    private Collection<ColorEntity> colors;
    /** ms */
    private Collection<MsEntity> mss;
    /** origin */
    private Collection<OriginEntity> origins;

    public GoodsDetailsResp() {
    }

    public GoodsDetailsResp(PhoneEntity phone) {
        this.phone = phone;
    }

    public GoodsDetailsResp(PhoneEntity phone, Collection<ColorEntity> colors, Collection<MsEntity> mss, Collection<OriginEntity> origins) {
        this.phone = phone;
        this.colors = colors;
        this.mss = mss;
        this.origins = origins;
    }

    public PhoneEntity getPhone() {
        return phone;
    }

    public void setPhone(PhoneEntity phone) {
        this.phone = phone;
    }

    public Collection<ColorEntity> getColors() {
        return colors;
    }

    public void setColors(Collection<ColorEntity> colors) {
        this.colors = colors;
    }

    public Collection<MsEntity> getMss() {
        return mss;
    }

    public void setMss(Collection<MsEntity> mss) {
        this.mss = mss;
    }

    public Collection<OriginEntity> getOrigins() {
        return origins;
    }

    public void setOrigins(Collection<OriginEntity> origins) {
        this.origins = origins;
    }

    //@Override
    //public String toString() {
    //    return "GoodsDetailsResp_2{" +
    //            "phone=" + phone +
    //            ", colors=" + colors +
    //            ", mss=" + mss +
    //            ", origins=" + origins +
    //            '}';
    //}
    @Override
    public String toString() {
        return "GoodsDetailsResp_2{" +
                phone.toString() +
                "," + colors.toString() +
                "," + mss.toString() +
                "," + origins.toString() +
                '}';
    }
}
