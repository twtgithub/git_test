package cn.twt.entity;

import java.util.Date;

/**
 * 电子文档条目表
 */
public class EdocEntry {
    private Integer id;                     //文档编号
    private EdocCategory edocCategory;     //电子文档分类表
    private Integer categoryId;            //分类编号
    private String title;                   //文档名称
    private String summary;                 //摘要
    private String uploaduser;              //上传人
    private Date createDate;                //创建时间

    public EdocCategory getEdocCategory() {
        return edocCategory;
    }

    public void setEdocCategory(EdocCategory edocCategory) {
        this.edocCategory = edocCategory;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getUploaduser() {
        return uploaduser;
    }

    public void setUploaduser(String uploaduser) {
        this.uploaduser = uploaduser;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}
