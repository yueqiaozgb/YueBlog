package top.yueqiao.yueblog.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import top.yueqiao.yueblog.domain.entity.Tag;
import top.yueqiao.yueblog.mapper.TagMapper;
import top.yueqiao.yueblog.service.TagService;

import java.util.List;

/**
* @author yueqiao
* @description 针对表【tag(标签表)】的数据库操作Service实现
* @createDate 2023-08-15 00:20:24
*/
@Service
public class TagServiceImpl extends ServiceImpl<TagMapper, Tag> implements TagService{

    @Override
    public List<Tag> selectTagList() {
        return baseMapper.selectList(null);
    }

}




