package com.xiaomin.xmlogin.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.xiaomin.xmlogin.entity.MemberEntity;
import com.xiaomin.xmlogin.entity.MemberLevelEntity;
import com.xiaomin.xmlogin.mapper.MemberLevelMapper;
import com.xiaomin.xmlogin.mapper.MemberMapper;
import com.xiaomin.xmlogin.resp.MemberResp;
import com.xiaomin.xmlogin.service.MemberService;
import com.xiaomin.xmlogin.utils.CopyUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: XiaoMin
 * @PRODUCT_NAME: IntelliJ IDEA
 * @PROJECT_NAME: xm-login
 * @Date_Time: 2022/10/1 18:22
 */
@Service
public class MemberServiceImpl implements MemberService {
    @Resource
    private MemberMapper memberMapper;
    @Resource
    private MemberLevelMapper memberLevelMapper;
    @Override
    public MemberResp queryMemberByUserId(long id) {
        System.out.println("id===>"+id);
        QueryWrapper<MemberEntity> memberQueryWrapper=new QueryWrapper<>();
        memberQueryWrapper.lambda().eq(MemberEntity::getMemberId,id);
        MemberEntity member = memberMapper.selectOne(memberQueryWrapper);
        System.out.println("member=>"+member);

        QueryWrapper<MemberLevelEntity> memberLevelQueryWrapper=new QueryWrapper<>();
        String memberLevel= String.valueOf(member.getMemberLevel());
        memberLevelQueryWrapper.lambda().eq(MemberLevelEntity::getLevelId,memberLevel);
        MemberLevelEntity memberLevelEntity = memberLevelMapper.selectOne(memberLevelQueryWrapper);

        MemberResp memberResp;

        try {
            MemberResp copy = CopyUtil.copy(memberLevelEntity, MemberResp.class);
            memberResp = CopyUtil.copy(member, copy);
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
        System.out.println(memberResp);
        return memberResp;
    }
}
