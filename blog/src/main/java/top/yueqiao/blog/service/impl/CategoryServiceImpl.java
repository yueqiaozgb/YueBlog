package top.yueqiao.blog.service.impl;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import top.yueqiao.blog.domain.PageQuery;
import top.yueqiao.blog.domain.PageResult;
import top.yueqiao.blog.domain.entity.Category;
import top.yueqiao.blog.mapper.CategoryMapper;
import top.yueqiao.blog.service.ICategoryService;

/**
 * @author yueqiao
 * @date 2025/03/31/16:49
 */
@Service
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category> implements ICategoryService {


    @Override
    public PageResult<Category> selectPageCategoryList(Category category, PageQuery pageQuery) {
        LambdaQueryWrapper<Category> lqw = new LambdaQueryWrapper<Category>()
                .like(StrUtil.isNotBlank(category.getName()), Category::getName, category.getName());
        Page<Category> page = page(pageQuery.build(), lqw);
        return PageResult.build(page);
    }

    @Override
    public Category selectCategoryById(Integer id) {
        return getById(id);
    }

    @Override
    public int insertCategory(Category category) {
        return baseMapper.insert(category);
    }

    @Override
    public int updateCategory(Category category) {
        return baseMapper.updateById(category);
    }

    @Override
    public int deleteCategoryByIds(Integer[] ids) {
        return baseMapper.deleteByIds(CollUtil.toList(ids));
    }

}
