package top.yueqiao.yueblog.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import top.yueqiao.yueblog.domain.entity.Blog;
import top.yueqiao.yueblog.service.BlogService;
import top.yueqiao.yueblog.mapper.BlogMapper;
import org.springframework.stereotype.Service;

/**
 * 针对表【blog(博客表)】的数据库操作Service实现
 *
 * @author yueqiao
 */
@Service
public class BlogServiceImpl extends ServiceImpl<BlogMapper, Blog> implements BlogService {

}




