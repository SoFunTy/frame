package com.cn.frame.api.vo;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 用户表
 * </p>
 *
 * @author SoFunTy
 * @since 2020-11-11
 */
@Data
@ApiModel(value="用户对象")
public class MemberVO implements Serializable {

    private static final long serialVersionUID = -8246012537000010815L;
    @ApiModelProperty(value = "token")
    private String token;

    @ApiModelProperty(value = "主键编号")
    private Integer id;

    @ApiModelProperty(value = "手机号码")
    private String mobile;

    @ApiModelProperty(value = "昵称")
    private String nickName;

    @ApiModelProperty(value = "头像")
    private String headImg;

    @ApiModelProperty(value = "真实名称")
    private String realName;

    @ApiModelProperty(value = "备注信息")
    private String remarks;

    @ApiModelProperty(value = "创建者")
    private Integer createBy;

    @JsonIgnore
    @ApiModelProperty(value = "创建时间")
    private LocalDateTime createDate;

    @ApiModelProperty(value = "最后更新者")
    private Integer updateBy;

    @JsonIgnore
    @ApiModelProperty(value = "更新时间")
    private LocalDateTime updateDate;

    @ApiModelProperty(value = "删除标记（0：正常；1：删除）")
    private Integer delFlag;


}
