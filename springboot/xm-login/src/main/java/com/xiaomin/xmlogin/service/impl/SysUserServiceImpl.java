package com.xiaomin.xmlogin.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xiaomin.xmlogin.entity.SysUserEntity;
import com.xiaomin.xmlogin.mapper.SysUserMapper;
import com.xiaomin.xmlogin.req.SysUserLoginReq;
import com.xiaomin.xmlogin.req.SysUserSaveReq;
import com.xiaomin.xmlogin.resp.EmailResp;
import com.xiaomin.xmlogin.resp.SysUserLoginResp;
import com.xiaomin.xmlogin.service.SysUserService;
import com.xiaomin.xmlogin.utils.CopyUtil;
import com.xiaomin.xmlogin.utils.SnowFlow;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;

import javax.annotation.Resource;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

/**
 * @Author: XiaoMin
 * @PRODUCT_NAME: IntelliJ IDEA
 * @PROJECT_NAME: xm-login
 * @Date_Time: 2022/9/20 18:18
 */
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUserEntity> implements SysUserService {
    @Resource
    private SysUserMapper sysUserMapper;
    @Resource
    private SnowFlow snowFlow;
    @Resource
    private RedisTemplate redisTemplate;

    @Override
    public int register(SysUserSaveReq req) {
        SysUserEntity user;
        int i = 0;
        try {
            user = CopyUtil.copy(req, SysUserEntity.class);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (NoSuchFieldException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        }
        String email= (String) redisTemplate.opsForValue().get("email");
        String codeValue= (String) redisTemplate.opsForValue().get("code");

        System.out.println("code::"+req.getCode());
        System.out.println("codeValue::"+codeValue);
        System.out.println("email::"+email);

        if (email.equals(req.getEmail())&&req.getCode().equals(codeValue)){
            if (ObjectUtils.isEmpty(req.getId())){
                SysUserEntity userDb = selectByUserName(req.getUserName());
                if (ObjectUtils.isEmpty(userDb)){
                    user.setId(snowFlow.nextId());
                    sysUserMapper.insert(user);
                    redisTemplate.delete("email");
                    redisTemplate.delete("code");
                    i=1;
                } else {
                    i = 0;
                }
            }
        }else {
            i=2;
        }

        System.out.println("i的值为:"+i);
        //System.out.println("1::"+code+"2::"+emailResp.getCode());
        System.out.println("code::"+req.getCode());
        System.out.println("codeValue::"+codeValue);
        System.out.println("email::"+email);
        return i;
    }

    @Override
    public SysUserLoginResp login(SysUserLoginReq req) {
        SysUserEntity userDb = selectByUserNameAndPassword(req.getUserName(),req.getPassword());
        if (ObjectUtils.isEmpty(userDb)){
            //用户名或密码错误
            return null;
        }else {
            //登陆成功
            SysUserLoginResp userLoginResp;
            try {
                userLoginResp = CopyUtil.copy(userDb, SysUserLoginResp.class);
            } catch (NoSuchMethodException e) {
                throw new RuntimeException(e);
            } catch (InvocationTargetException e) {
                throw new RuntimeException(e);
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            } catch (NoSuchFieldException e) {
                throw new RuntimeException(e);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            } catch (InstantiationException e) {
                throw new RuntimeException(e);
            }
            return userLoginResp;
        }
    }

    //查询userName是否被注册
    public SysUserEntity selectByUserName(String userName){
        QueryWrapper<SysUserEntity> wrapper = new QueryWrapper<>();
        wrapper.lambda().eq(SysUserEntity::getUserName,userName);
        List<SysUserEntity> userEntityList = sysUserMapper.selectList(wrapper);
        if (CollectionUtils.isEmpty(userEntityList)){
            return null;
        }else {
            return userEntityList.get(0);
        }
    }
    public SysUserEntity selectByUserNameAndPassword(String userName,String password){
        QueryWrapper<SysUserEntity> wrapper = new QueryWrapper<>();
        wrapper.lambda().eq(SysUserEntity::getUserName,userName);
        wrapper.lambda().eq(SysUserEntity::getPassword,password);
        List<SysUserEntity> userEntityList = sysUserMapper.selectList(wrapper);
        if (CollectionUtils.isEmpty(userEntityList)){
            return null;
        }else {
            return userEntityList.get(0);
        }
    }
}
