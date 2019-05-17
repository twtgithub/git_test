package cn.twt.service;
import cn.twt.dao.EdocEntryMapper;
import cn.twt.entity.EdocCategory;
import cn.twt.entity.EdocEntry;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;

@Service
public class EdocEntryServiceImpl implements EdocEntryService {
    @Resource
    private EdocEntryMapper edocEntryMapper;

    @Override
    public List<EdocEntry> queryEdocEntryPageList(Integer currPageNo, Integer pageSize, Integer categoryId) {
        return edocEntryMapper.queryEdocEntryPageList(currPageNo,pageSize,categoryId);
    }

    @Override
    public int delEdocEntry(Integer id) {
        return edocEntryMapper.delEdocEntry(id);
    }

    @Override
    public int EdocEntryCount() {
        return edocEntryMapper.EdocEntryCount();
    }

    @Override
    public List<EdocCategory> queryEdocCategoryAll() {
        return edocEntryMapper.queryEdocCategoryAll();
    }
}
