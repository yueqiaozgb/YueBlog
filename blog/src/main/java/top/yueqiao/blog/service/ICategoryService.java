package top.yueqiao.blog.service;

import com.baomidou.mybatisplus.extension.service.IService;
import top.yueqiao.blog.domain.PageQuery;
import top.yueqiao.blog.domain.PageResult;
import top.yueqiao.blog.domain.entity.Category;

/**
 * @author yueqiao
 * @date 2025/03/31/16:49
 */
public interface ICategoryService extends IService<Category> {

    PageResult<Category> selectPageCategoryList(Category category, PageQuery pageQuery);

    Category selectCategoryById(Integer id);

    int insertCategory(Category category);

    int updateCategory(Category category);

    int deleteCategoryByIds(Integer[] ids);

}
