package top.yueqiao.yueblog.controller.admin;

import cn.dev33.satoken.annotation.SaCheckRole;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import top.yueqiao.yueblog.controller.BaseController;
import top.yueqiao.yueblog.domain.PageInfo;
import top.yueqiao.yueblog.domain.PageQuery;
import top.yueqiao.yueblog.domain.Result;
import top.yueqiao.yueblog.domain.entity.Category;
import top.yueqiao.yueblog.service.CategoryService;
import top.yueqiao.yueblog.validate.InsertGroup;
import top.yueqiao.yueblog.validate.UpdateGroup;

import java.util.List;

import static top.yueqiao.yueblog.constant.Constants.Role.ROLE_ADMIN;

/**
 * @author yueqiao
 */
@Slf4j
@Validated
@RestController
@RequestMapping("/admin/category")
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class CategoryAdminController extends BaseController {

    private final CategoryService categoryService;

    @GetMapping("/list")
    public Result<List<Category>> list() {
        return Result.success(categoryService.list());
    }

    @GetMapping("/listByQuery")
    public PageInfo<Category> listByQuery(PageQuery pageQuery) {
        return categoryService.selectPageCategoryList(pageQuery);
    }

    @PostMapping
    @SaCheckRole(ROLE_ADMIN)
    public Result<Void> insert(@Validated(InsertGroup.class) @RequestBody Category category) {
        return toAjax(categoryService.save(category));
    }

    @PutMapping
    @SaCheckRole(ROLE_ADMIN)
    public Result<Void> updateCategory(@Validated(UpdateGroup.class) @RequestBody Category category) {
        return toAjax(categoryService.updateById(category));
    }

    @DeleteMapping("/{id}")
    @SaCheckRole(ROLE_ADMIN)
    public Result<Void> deleteCategory(@PathVariable Long id) {
        return toAjax(categoryService.deleteCategory(id));
    }

}
