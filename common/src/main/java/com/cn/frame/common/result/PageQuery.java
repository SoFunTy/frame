package com.cn.frame.common.result;

import cn.hutool.core.util.ObjectUtil;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;

/**
 * Create By SoFunTy
 * 2020/10/12 14:23
 */
@Data
@ApiModel(value = "分页内容")
public class PageQuery implements Serializable {

    private static final long serialVersionUID = 1868812352562982645L;

    @ApiModelProperty(value = "排序降序", hidden = true)
    public static final String ORDER_TYPE_DESC = "desc";

    @ApiModelProperty(value = "排序升序", hidden = true)
    public static final String ORDER_TYPE_ASC = "asc";

    @ApiModelProperty(value = "当前页,第一页默认1", required = true, dataType = "int")
    private int currPage = 1;

    @ApiModelProperty(value = "每页的数量", required = true, dataType = "int")
    private int pageSize = 10;

    @ApiModelProperty(value = "排序字段【,】分隔", allowEmptyValue = true, dataType = "String")
    private String orderField = "";

    @ApiModelProperty(value = "默认降序", allowEmptyValue = true, dataType = "String")
    private String orderType = ORDER_TYPE_DESC;

    @ApiModelProperty(value = "排序拼接", hidden = true)
    private String orderby = "";

    public String getOrderby() {
        if (StringUtils.isNotBlank(orderField) && StringUtils.isNotBlank(orderType)) {
            return orderField + " " + orderType;
        }
        return "";
    }

    public int getCurrPage() {
        if (currPage == 0) {
            return 1;
        }
        return currPage;
    }

    public int getPageSize() {
        if (pageSize == 0) {
            return 20;
        }
        return pageSize;
    }
}
