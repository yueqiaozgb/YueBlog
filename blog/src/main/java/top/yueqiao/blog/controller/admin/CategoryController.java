package top.yueqiao.blog.controller.admin;

import cn.dev33.satoken.annotation.SaCheckRole;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import top.yueqiao.blog.constant.RoleConstant;
import top.yueqiao.blog.controller.BaseController;
import top.yueqiao.blog.domain.AjaxResult;
import top.yueqiao.blog.domain.PageQuery;
import top.yueqiao.blog.domain.PageResult;
import top.yueqiao.blog.domain.entity.Category;
import top.yueqiao.blog.service.ICategoryService;

/**
 * @author yueqiao
 * @date 2025/03/31/16:51
 */
@RestController
@RequestMapping("/category")
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class CategoryController extends BaseController {

    private final ICategoryService categoryService;

    @SaCheckRole(RoleConstant.ADMIN)
    @GetMapping("/list")
    public PageResult<Category> list(Category category, PageQuery pageQuery) {
        return categoryService.selectPageCategoryList(category, pageQuery);
    }

    @GetMapping("/{id}")
    public AjaxResult<Category> select(@NotNull(message = "id不能为空") @PathVariable Integer id) {
        return AjaxResult.success(categoryService.selectCategoryById(id));
    }

    @PostMapping
    public AjaxResult<Void> insert(@RequestBody Category category) {
        return toAjax(categoryService.insertCategory(category));
    }

    @PutMapping
    public AjaxResult<Void> update(@RequestBody Category category) {
        return toAjax(categoryService.updateCategory(category));
    }

    @DeleteMapping("/{ids}")
    public AjaxResult<Void> delete(@PathVariable Integer[] ids) {
        return toAjax(categoryService.deleteCategoryByIds(ids));
    }

}
