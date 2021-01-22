package com.cn.frame.api.service.impl;

import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.cn.frame.api.common.CacheNameSpaceEnum;
import com.cn.frame.api.model.CacheMemberModel;
import com.cn.frame.api.service.CacheService;
import com.cn.frame.api.service.MemberService;
import com.cn.frame.api.vo.MemberVO;
import com.cn.frame.common.exception.FrServerException;
import com.cn.frame.api.mapper.MemberMapper;
import com.cn.frame.common.model.MemberModel;
import com.cn.frame.common.util.BeanConvertUtils;
import com.cn.frame.common.util.TokenUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Create By SoFunTy
 * 2020/11/11 16:08
 */
@Slf4j
@Service
public class MemberServiceImpl implements MemberService {

    @Autowired
    private MemberMapper memberMapper;

    @Autowired
    private CacheService cacheService;
    
    @Override
    public MemberVO loginByMobile(String mobile, String password) {

        log.info("loginByMobile By mobile:{}",mobile);

        if (StringUtils.isAnyBlank(mobile,password)){ throw new FrServerException("手机号/密码必须填写！"); }

        MemberModel memberModel = memberMapper.selectOne(new QueryWrapper<MemberModel>().eq("mobile",mobile));

        if (ObjectUtil.isNull(memberModel)) { throw new FrServerException("用户不存在！"); }

        if (!password.equals(memberModel.getPassword())){ throw new FrServerException("手机号或密码错误！"); }

        MemberVO result = BeanConvertUtils.convert(memberModel,MemberVO.class);
        
        result.setToken(TokenUtil.createToken(2));

        log.info("用户登录{},记入缓存",result);
        
        cacheService.putCache(CacheNameSpaceEnum.TOKEN_MEMBER_CACHE,result.getToken(),BeanConvertUtils.convert(memberModel, CacheMemberModel.class));

        cacheService.putCache(CacheNameSpaceEnum.MEMBERID_TOKEN_CACHE,result.getId().toString(),result.getToken());

        return result;
    }

    /**
     * TODO:简单登录
     * @param mobile
     * @return
     */
    @Override
    public MemberVO easyLogin(String mobile) {

        log.info("easyLogin By mobile:{}",mobile);

        MemberModel memberModel = memberMapper.selectOne(new QueryWrapper<MemberModel>().eq("mobile",mobile));

        memberModel = ObjectUtil.isEmpty(memberModel) ? memberMapper.selectById(4) : memberModel;

        MemberVO result = BeanConvertUtils.convert(memberModel,MemberVO.class);

        result.setToken(TokenUtil.createToken(2));

        log.info("用户登录{},记入缓存",result);

        cacheService.putCache(CacheNameSpaceEnum.TOKEN_MEMBER_CACHE,result.getToken(),BeanConvertUtils.convert(memberModel, CacheMemberModel.class));

        cacheService.putCache(CacheNameSpaceEnum.MEMBERID_TOKEN_CACHE,result.getId().toString(),result.getToken());

        return result;
    }

}
