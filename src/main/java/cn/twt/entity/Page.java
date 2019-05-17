package cn.twt.entity;

/**
 * 分页类
 */
public class Page {
    private Integer currPageNo;       //当前页
    private Integer pageSize = 2;         //每页显示数
    private Integer totaPageCount;   //总页数
    private Integer totaCount;        //总数

    public Integer getCurrPageNo() {
        return currPageNo;
    }

    public void setCurrPageNo(Integer currPageNo) {
        this.currPageNo = currPageNo;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getTotaPageCount() {
        return totaPageCount;
    }

    public void setTotaPageCount(Integer totaPageCount) {
        this.totaPageCount = totaPageCount;
    }

    public Integer getTotaCount() {
        return totaCount;
    }

    public void setTotaCount(Integer totaCount) {
        if (totaCount>0){
            this.totaCount = totaCount;
            this.totaPageCount = this.totaCount % this.pageSize == 0 ?
                    this.totaCount / this.pageSize : this.totaCount / this.pageSize + 1;
        }
    }
}
