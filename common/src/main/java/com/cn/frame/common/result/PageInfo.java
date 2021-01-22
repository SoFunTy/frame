package com.cn.frame.common.result;

import com.github.pagehelper.Page;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.beans.BeanUtils;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Create By SoFunTy
 * 2020/10/12 14:21
 */
@Data
public class PageInfo<K>  implements Serializable {

    private static final long serialVersionUID = 4186009534625569990L;
    @ApiModelProperty(value = "总数", required = true)
    private long totalCount = 0;

    @ApiModelProperty(value = "总页数", required = true)
    private int totalPage = 0;

    @ApiModelProperty(value = "每页条数", required = true)
    private int pageSize = 20;

    @ApiModelProperty(value = "当前页,第一页默认1", required = true)
    private int currPage = 1;

    @ApiModelProperty(value = "查询结果")
    private List<K> dataList = new ArrayList<>();

    @ApiModelProperty(value = "是否为第一页", required = true)
    private boolean isFirstPage = true;

    @ApiModelProperty(value = "是否为最后一页", required = true)
    private boolean isLastPage = true;


    public PageInfo() {
    }

    /**
     * 包装Page对象
     *
     * @param page
     */
    public <T> PageInfo(com.github.pagehelper.PageInfo<T> page, Class<K> targetClass) {
        if (page == null) {
            return;
        }
        this.currPage = page.getPageNum();
        this.pageSize = page.getPageSize();
        this.totalPage = page.getPages();
        this.totalCount = page.getTotal();
        this.isFirstPage = page.isIsFirstPage();
        this.isLastPage = page.isIsLastPage();

        if (page.getList() != null && page.getList().size() > 0) {
            dataList = new ArrayList<>(page.getList().size());
            for (T source : page.getList()) {
                K target = null;
                if (source == null) {
                    continue;
                }
                try {
                    target = targetClass.newInstance();
                } catch (InstantiationException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                BeanUtils.copyProperties(source, target);
                if (target != null) {
                    dataList.add(target);
                }
            }
        }
    }

    public <T> PageInfo(com.github.pagehelper.PageInfo<T> page, List<T> list, Class<K> targetClass) {
        this.totalCount = page.getTotal();
        this.pageSize = page.getPageSize();
        this.currPage = page.getPageNum();
        this.totalPage = page.getPages();

        this.isFirstPage = page.isIsFirstPage();
        this.isLastPage = page.isIsLastPage();

        if ( list != null && list.size() > 0) {
            dataList = new ArrayList<>(list.size());
            for (T source : list) {
                K target = null;
                if (source == null) {
                    continue;
                }
                try {
                    target = targetClass.newInstance();
                } catch (InstantiationException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                BeanUtils.copyProperties(source, target);
                if (target != null) {
                    dataList.add(target);
                }
            }
        }
    }
}
