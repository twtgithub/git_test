package cn.twt.dao;

import cn.twt.entity.EdocCategory;
import cn.twt.entity.EdocEntry;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EdocEntryMapper {
    public List<EdocEntry> queryEdocEntryPageList(@Param("currPageNo")Integer currPageNo,@Param("pageSize")Integer pageSize,
                                                  @Param("categoryId")Integer categoryId);      //分页查询电子文档
    public int delEdocEntry(@Param("id")Integer id);                                            //按id删除电子文档

    public int EdocEntryCount();                                                                //查询出总数

    public List<EdocCategory> queryEdocCategoryAll();                                            //查询出所有的文档分类
}
