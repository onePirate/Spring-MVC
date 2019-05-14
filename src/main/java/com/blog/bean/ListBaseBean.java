package com.blog.bean;

/**
 * @function:
 * @Author: gaodawei
 * @Date: 2018/1/16 21:37
 */
public class ListBaseBean extends BaseBean{

    private Integer pageIndex;
    private Integer pageSize;

    public Integer getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(Integer pageIndex) {
        this.pageIndex = pageIndex;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }
}
