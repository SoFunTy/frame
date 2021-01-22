package com.cn.frame.api.controller;

import com.cn.frame.api.service.MemberService;
import com.cn.frame.api.vo.LoginVO;
import com.cn.frame.api.vo.MemberVO;
import com.cn.frame.common.result.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

/**
 * Create By SoFunTy
 * 2020/11/11 15:15
 */
@Slf4j
@Api(tags = {"用户相关接口"})
@RestController
public class MemberController {

    @Autowired
    private MemberService memberService;

    @ApiIgnore
    @ApiOperation(value = "手机号密码登录", notes = "手机号密码登录")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "version", allowableValues = "1.0.0", value = "接口版本号", required = true, defaultValue = "1.0.0", dataType = "String", paramType = "header"),
            @ApiImplicitParam(name = "mobile", value = "mobile", required = true, defaultValue = "0", dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "password", value = "password", required = true, defaultValue = "0", dataType = "String", paramType = "query")
    })
    @RequestMapping(value = "/member/loginByMobile", method = RequestMethod.POST)
    public R<MemberVO> loginByMobile(String mobile, String password) {
        return R.ok(memberService.loginByMobile(mobile,password));
    }

    @ApiIgnore
    @ApiOperation(value = "简单登录", notes = "简单登录")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "version", allowableValues = "1.0.0", value = "接口版本号", required = true, defaultValue = "1.0.0", dataType = "String", paramType = "header"),
            @ApiImplicitParam(name = "mobile", value = "mobile", required = true, defaultValue = "0", dataType = "String", paramType = "query")
    })
    @RequestMapping(value = "/member/easyLogin", method = RequestMethod.POST)
    public R<MemberVO> easyLogin(String mobile) {
        return R.ok(memberService.easyLogin(mobile));
    }

}
