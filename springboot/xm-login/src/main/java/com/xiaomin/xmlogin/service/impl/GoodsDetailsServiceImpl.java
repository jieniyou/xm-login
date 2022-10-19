package com.xiaomin.xmlogin.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.xiaomin.xmlogin.entity.*;
import com.xiaomin.xmlogin.mapper.*;
import com.xiaomin.xmlogin.resp.GoodsDetailsResp;
import com.xiaomin.xmlogin.service.GoodsDetailsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: XiaoMin
 * @PRODUCT_NAME: IntelliJ IDEA
 * @PROJECT_NAME: xm-login
 * @Date_Time: 2022/10/2 22:24
 */
@Service
public class GoodsDetailsServiceImpl implements GoodsDetailsService {
    @Resource
    private PhoneMapper phoneMapper;
    @Resource
    private PhoneColorMsOriginMapper PCMOMapper;
    @Resource
    private ColorMapper colorMapper;
    @Resource
    private MsMapper msMapper;
    @Resource
    private OriginMapper originMapper;

    @Override
    public GoodsDetailsResp queryGoodsDetailsById(long id) {

        System.out.println("id===>"+id);
        PhoneEntity phone = queryPhone(id);
        List<PhoneColorMsOriginEntity> PCMOs = queryPhoneColorMsOrigin(phone.getId());
        List<ColorEntity> colors = queryColor(id);
        List<MsEntity> mss = queryMs(id);
        List<OriginEntity> origins = queryOrigin(id);

        GoodsDetailsResp goods=new GoodsDetailsResp(phone,colors,mss,origins);

        return goods;
    }
    /**
     * phone
     */
    public PhoneEntity queryPhone(long id) {
        QueryWrapper<PhoneEntity> phoneQueryWrapper = new QueryWrapper<>();
        phoneQueryWrapper.lambda().eq(PhoneEntity::getId, id);
        List<PhoneEntity> phones = phoneMapper.selectList(phoneQueryWrapper);
        System.out.println("phones===>" + phones);
        return phones.get(0);
    }
    /**
     * phone-color-ms-origin
     */
    public List<PhoneColorMsOriginEntity> queryPhoneColorMsOrigin(long id) {
        QueryWrapper<PhoneColorMsOriginEntity> PCMOQueryWrapper = new QueryWrapper<>();
        PCMOQueryWrapper.lambda().eq(PhoneColorMsOriginEntity::getPhoneId, id);
        List<PhoneColorMsOriginEntity> PCMOs = PCMOMapper.selectList(PCMOQueryWrapper);
        System.out.println("PCMOs===>" + PCMOs);
        return PCMOs;
    }
    /**
     * color
     */
    public List<ColorEntity> queryColor(long id) {
        List<ColorEntity> colors=new ArrayList<>();
        QueryWrapper<ColorEntity> colorQueryWrapper = new QueryWrapper<>();
        for (PhoneColorMsOriginEntity PCMO : queryPhoneColorMsOrigin(id)) {
        colorQueryWrapper.lambda().eq(ColorEntity::getColorId, PCMO.getColorId());
            for (ColorEntity color : colorMapper.selectList(colorQueryWrapper)) {
                colors.add(color);
            }
            System.out.println("colors===>" + colors);
        }
        return colors;
    }
    /**
     * ms
     */
    public List<MsEntity> queryMs(long id) {
        List<MsEntity> mss=new ArrayList<>();
        QueryWrapper<MsEntity> msQueryWrapper = new QueryWrapper<>();
        for (PhoneColorMsOriginEntity PCMO : queryPhoneColorMsOrigin(id)) {
            msQueryWrapper.lambda().eq(MsEntity::getMsId, PCMO.getMsId());
            for (MsEntity ms : msMapper.selectList(msQueryWrapper)) {
                mss.add(ms);
            }
            System.out.println("mss===>" + mss);
        }
        return mss;
    }
    /**
     * origin
     */
    public List<OriginEntity> queryOrigin(long id) {
        List<OriginEntity> origins=new ArrayList<>();
        QueryWrapper<OriginEntity> originQueryWrapper = new QueryWrapper<>();
        for (PhoneColorMsOriginEntity PCMO : queryPhoneColorMsOrigin(id)) {
            originQueryWrapper.lambda().eq(OriginEntity::getOriginId,PCMO.getOriginId() );
            for (OriginEntity origin : originMapper.selectList(originQueryWrapper)) {
                    origins.add(origin);
            }
            System.out.println("origins===>" + origins);
        }
        return origins;
    }
}
