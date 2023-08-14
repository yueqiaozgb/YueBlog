package top.yueqiao.yueblog.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import top.yueqiao.yueblog.domain.entity.BlogCategory;
import top.yueqiao.yueblog.service.BlogCategoryService;
import top.yueqiao.yueblog.mapper.BlogCategoryMapper;
import org.springframework.stereotype.Service;

/**
* @author yueqiao
* @description 针对表【blog_category(博客分类表)】的数据库操作Service实现
* @createDate 2023-08-15 00:20:06
*/
@Service
public class BlogCategoryServiceImpl extends ServiceImpl<BlogCategoryMapper, BlogCategory>
    implements BlogCategoryService{

}




