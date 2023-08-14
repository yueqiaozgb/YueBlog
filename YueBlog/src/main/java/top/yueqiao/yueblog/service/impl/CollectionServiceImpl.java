package top.yueqiao.yueblog.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import top.yueqiao.yueblog.domain.entity.Collection;
import top.yueqiao.yueblog.service.CollectionService;
import top.yueqiao.yueblog.mapper.CollectionMapper;
import org.springframework.stereotype.Service;

/**
* @author yueqiao
* @description 针对表【collection(合集表)】的数据库操作Service实现
* @createDate 2023-08-15 00:20:22
*/
@Service
public class CollectionServiceImpl extends ServiceImpl<CollectionMapper, Collection>
    implements CollectionService{

}




