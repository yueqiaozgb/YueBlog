package top.yueqiao.yueblog.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import top.yueqiao.yueblog.domain.entity.Tag;
import top.yueqiao.yueblog.service.TagService;
import top.yueqiao.yueblog.mapper.TagMapper;
import org.springframework.stereotype.Service;

/**
* @author yueqiao
* @description 针对表【tag(标签表)】的数据库操作Service实现
* @createDate 2023-08-15 00:20:24
*/
@Service
public class TagServiceImpl extends ServiceImpl<TagMapper, Tag>
    implements TagService{

}




