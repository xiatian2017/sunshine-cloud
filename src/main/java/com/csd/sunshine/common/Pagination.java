package com.csd.sunshine.common;

import io.swagger.annotations.ApiModel;

/**
 * @Description: sunshine
 * @EnglishName LuKe
 * @authod liuqi
 * @date 2019/5/16 19:14
 */
@ApiModel( value = "分页信息" )
public class Pagination {
    private Integer page;
    private Integer pageSize;
    private Long total;

    public Integer getPage() { return page; }

    public void setPage( Integer page ) { this.page = page; }

    public Integer getPageSize() { return pageSize; }

    public void setPageSize( Integer pageSize ) { this.pageSize = pageSize; }

    public Long getTotal() { return total; }

    public void setTotal( Long total ) { this.total = total; }

    public Pagination( Integer page, Integer pageSize, Long total ) {
        this.page = page;
        this.pageSize = pageSize;
        this.total = total;
    }

    public static Integer getDefaultPage() { return Constants.PAGE_DEF_START; }

    public static Integer getDefaultPageSize() { return Constants.PAGE_DEF_SIZE; }
}
