package top.yueqiao.yueblog.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.yueqiao.yueblog.domain.PageInfo;
import top.yueqiao.yueblog.domain.PageQuery;
import top.yueqiao.yueblog.domain.entity.BlogCategory;
import top.yueqiao.yueblog.domain.entity.Category;
import top.yueqiao.yueblog.exception.ServiceException;
import top.yueqiao.yueblog.mapper.BlogCategoryMapper;
import top.yueqiao.yueblog.mapper.CategoryMapper;
import top.yueqiao.yueblog.service.CategoryService;

/**
* @author yueqiao
* @description 针对表【category(分类表)】的数据库操作Service实现
* @createDate 2023-08-15 00:20:19
*/
@Service
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category> implements CategoryService{

    @Autowired
    private BlogCategoryMapper blogCategoryMapper;

    @Override
    public PageInfo<Category> selectPageCategoryList(PageQuery pageQuery) {
        IPage<Category> categoryPage = baseMapper.selectPage(pageQuery.build(), null);
        return PageInfo.build(categoryPage);
    }

    @Override
    public int deleteCategory(Long categoryId) {
        LambdaQueryWrapper<BlogCategory> lqw = new LambdaQueryWrapper<BlogCategory>()
                .eq(BlogCategory::getCategoryId, categoryId);
        boolean exists = blogCategoryMapper.exists(lqw);
        if (exists) {
            throw new ServiceException("该分类下存在博客，不能删除");
        }
        return baseMapper.deleteById(categoryId);
    }

}




