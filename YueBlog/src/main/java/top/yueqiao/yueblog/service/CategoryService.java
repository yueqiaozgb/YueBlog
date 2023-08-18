package top.yueqiao.yueblog.service;

import com.baomidou.mybatisplus.extension.service.IService;
import top.yueqiao.yueblog.domain.PageInfo;
import top.yueqiao.yueblog.domain.PageQuery;
import top.yueqiao.yueblog.domain.entity.Category;

/**
* @author yueqiao
* @description 针对表【category(分类表)】的数据库操作Service
* @createDate 2023-08-15 00:20:19
*/
public interface CategoryService extends IService<Category> {

    PageInfo<Category> selectPageCategoryList(PageQuery pageQuery);

    int deleteCategory(Long categoryId);

}
