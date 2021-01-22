package com.cn.frame.api.controller;

import com.cn.frame.api.annotation.CurrentUser;
import com.cn.frame.api.model.CacheMemberModel;
import com.cn.frame.api.service.CacheService;
import com.cn.frame.common.result.R;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

/**
 * Create By SoFunTy
 * 2020/11/16  16:13
 */
@RestController
public class IndexController {


    @RequestMapping(value = "/",method = RequestMethod.GET)
    public String index(){
        return "Wellcome!";
    }


    @ApiOperation(value = "获取用户信息", notes = "获取用户信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "version", allowableValues = "1.0.0", value = "接口版本号", required = true, defaultValue = "1.0.0", dataType = "String", paramType = "header")
    })
    @RequestMapping(value = "/getUserInfo", method = RequestMethod.GET)
    public R<CacheMemberModel> getChopFormShareLinks(@ApiIgnore @CurrentUser CacheMemberModel memberModel) {
        return R.ok(memberModel);
    }
}
