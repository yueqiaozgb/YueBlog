package top.yueqiao.yueblog.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import top.yueqiao.yueblog.domain.entity.BlogCollection;
import top.yueqiao.yueblog.service.BlogCollectionService;
import top.yueqiao.yueblog.mapper.BlogCollectionMapper;
import org.springframework.stereotype.Service;

/**
* @author yueqiao
* @description 针对表【blog_collection(博客合集表)】的数据库操作Service实现
* @createDate 2023-08-15 00:20:12
*/
@Service
public class BlogCollectionServiceImpl extends ServiceImpl<BlogCollectionMapper, BlogCollection>
    implements BlogCollectionService{

}




