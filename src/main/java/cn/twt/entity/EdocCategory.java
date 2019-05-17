package cn.twt.entity;

/**
 * 电子文档分类表
 */
public class EdocCategory {
    private Integer id;         //分类编号
    private String name;        //分类名称

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
