package top.yueqiao.blog.controller.view;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.yueqiao.blog.controller.BaseController;
import top.yueqiao.blog.domain.PageQuery;
import top.yueqiao.blog.domain.PageResult;
import top.yueqiao.blog.domain.entity.Category;
import top.yueqiao.blog.service.ICategoryService;

/**
 * @author : yueqiao
 * @date : 2025/4/3 21:50
 */
@RestController
@RequestMapping("/view/category")
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class ViewCategoryController extends BaseController {

    private final ICategoryService categoryService;

    @GetMapping("/list")
    public PageResult<Category> list(Category category, PageQuery pageQuery) {
        return categoryService.selectPageCategoryList(category, pageQuery);
    }

}
