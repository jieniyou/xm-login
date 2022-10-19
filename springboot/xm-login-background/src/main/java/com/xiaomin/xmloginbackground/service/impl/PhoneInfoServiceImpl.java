package com.xiaomin.xmloginbackground.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.xiaomin.xmloginbackground.entity.*;
import com.xiaomin.xmloginbackground.mapper.*;
import com.xiaomin.xmloginbackground.resp.PhoneInfoResp;
import com.xiaomin.xmloginbackground.service.PhoneInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @Author: XiaoMin
 * @PRODUCT_NAME: IntelliJ IDEA
 * @PROJECT_NAME: xm-login-background
 * @Date_Time: 2022/10/13 9:25
 */
@Service
public class PhoneInfoServiceImpl implements PhoneInfoService {
    @Override
    public Collection<PhoneInfoResp> selectGoods() {
        PhoneInfoResp phone;
        Collection<PhoneInfoResp> phones =new ArrayList<>();

        for (PhoneEntity p : queryPhone()) {
            System.out.println("p-=-=-=-=-=>"+p);
            CategoryEntity category = queryCategory((int)p.getCategoryId());
            System.out.println("category--->"+category);

            int pcmoid = (int)queryPCMO((int)p.getId()-1).get(0).getId();
            System.out.println("pcmoid---------->"+pcmoid);

            List<ColorEntity> colorEntities = queryColor(pcmoid);

            List<MsEntity> msEntities = queryMs(pcmoid);

            List<OriginEntity> originEntities = queryOrigin(pcmoid);

            phone=new PhoneInfoResp(p,category,colorEntities.get(0),msEntities.get(0),originEntities.get(0));
            phones.add(phone);
            System.out.println("phone=====>"+phone);
        }
        System.out.println("phones=====>"+phones);
        return phones;
    }

    @Resource
    private PhoneMapper phoneMapper;
    /**
     * phone
     */

    public List<PhoneEntity> queryPhone(){
        QueryWrapper<PhoneEntity> wrapper=new QueryWrapper<>();
        return phoneMapper.selectList(wrapper);
    }
    /**
     * category
     */
    @Resource
    private CategoryMapper categoryMapper;
    public CategoryEntity queryCategory(int i){
        QueryWrapper<CategoryEntity> wrapper=new QueryWrapper<>();
        wrapper.lambda().eq(CategoryEntity::getId,queryPhone().get(i-1).getCategoryId());
        CategoryEntity category = categoryMapper.selectList(wrapper).get(0);
        return category;
    }
    /**
     * phone_color_ms_origin
     */
    @Resource
    private PhoneColorMsOriginMapper PCMOMapper;
    public List<PhoneColorMsOriginEntity> queryPCMO(int i){
        QueryWrapper<PhoneColorMsOriginEntity> wrapper=new QueryWrapper<>();
        wrapper.lambda().eq(PhoneColorMsOriginEntity::getPhoneId,queryPhone().get(i).getId());
        List<PhoneColorMsOriginEntity> PCMOs = PCMOMapper.selectList(wrapper);
        return PCMOs;
    }
    /**
     * color
     */
    @Resource
    private ColorMapper colorMapper;
    public List<ColorEntity> queryColor(int i){
        QueryWrapper<ColorEntity> wrapper=new QueryWrapper<>();
        List<ColorEntity> colors;
        PhoneColorMsOriginEntity pcmo = queryPCMO(i-1).get(0);
        wrapper.lambda().eq(ColorEntity::getColorId,pcmo.getColorId());
        colors = colorMapper.selectList(wrapper);
        return colors;
    }
    /**
     * ms
     */
    @Resource
    private MsMapper msMapper;
    public List<MsEntity> queryMs(int i){
        QueryWrapper<MsEntity> wrapper=new QueryWrapper<>();
        List<MsEntity> mss;
        PhoneColorMsOriginEntity pcmo = queryPCMO(i-1).get(0);
        wrapper.lambda().eq(MsEntity::getMsId,pcmo.getMsId());
        mss = msMapper.selectList(wrapper);
        return mss;
    }
    /**
     * origin
     */
    @Resource
    private OriginMapper originMapper;
    public List<OriginEntity> queryOrigin(int i){
        QueryWrapper<OriginEntity> wrapper=new QueryWrapper<>();
        List<OriginEntity> origins;
        PhoneColorMsOriginEntity pcmo = queryPCMO(i-1).get(0);
        wrapper.lambda().eq(OriginEntity::getOriginId,pcmo.getOriginId());
        origins=originMapper.selectList(wrapper);
        return origins;
    }

}
