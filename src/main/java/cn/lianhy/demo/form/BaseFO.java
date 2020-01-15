package cn.lianhy.demo.form;

import java.io.Serializable;

public class BaseFO implements Serializable{

    private Integer pageIndex;

    private Integer limitBegin;

    private Integer pageSize;

    public Integer getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(Integer pageIndex) {
        this.pageIndex = pageIndex;
    }

    public Integer getLimitBegin() {
        return limitBegin;
    }

    public void setLimitBegin(Integer limitBegin) {
        this.limitBegin = limitBegin;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }
}
