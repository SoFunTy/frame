package com.cn.frame.api.service;

import com.cn.frame.api.vo.LoginVO;
import com.cn.frame.api.vo.MemberVO;

/**
 * Create By SoFunTy
 * 2020/11/11 16:08
 */
public interface MemberService {

    /**
     * TODO:手机密码登录
     * @param mobile
     * @param password
     * @return
     */
    MemberVO loginByMobile(String mobile, String password);


    /**
     * TODO:简单登录
     * @param mobile
     * @return
     */
    MemberVO easyLogin(String mobile);

}
