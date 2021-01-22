package com.cn.frame.api.model;

import com.cn.frame.common.model.MemberModel;
import lombok.Data;

import java.io.Serializable;

/**
 * Create By SoFunTy
 * 2020/11/18  15:53
 */
@Data
public class CacheMemberModel extends MemberModel implements Serializable {

    private static final long serialVersionUID = -7564615352734240423L;

    /****************用户当前id******************/
    private String ip;
}
