package top.yueqiao.yueblog.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import top.yueqiao.yueblog.domain.entity.BlogTag;
import top.yueqiao.yueblog.service.BlogTagService;
import top.yueqiao.yueblog.mapper.BlogTagMapper;
import org.springframework.stereotype.Service;

/**
* @author yueqiao
* @description 针对表【blog_tag(博客标签表)】的数据库操作Service实现
* @createDate 2023-08-15 00:20:16
*/
@Service
public class BlogTagServiceImpl extends ServiceImpl<BlogTagMapper, BlogTag>
    implements BlogTagService{

}




