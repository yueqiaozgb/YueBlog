package top.yueqiao.blog.controller;

import cn.dev33.satoken.annotation.SaCheckRole;
import jakarta.annotation.Resource;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import top.yueqiao.blog.constant.RoleConstant;
import top.yueqiao.blog.domain.AjaxResult;
import top.yueqiao.blog.domain.entity.Blog;
import top.yueqiao.blog.interfaces.DeleteGroup;
import top.yueqiao.blog.interfaces.InsertGroup;
import top.yueqiao.blog.interfaces.UpdateGroup;
import top.yueqiao.blog.service.IBlogService;

import java.util.List;

/**
 * @author yueqiao
 * @date 2025/03/13/18:16
 */
@RestController
@RequestMapping("/blog")
public class BlogController extends BaseController {

    @Resource
    private IBlogService blogService;

    @SaCheckRole(RoleConstant.ADMIN)
    @GetMapping("/list")
    public AjaxResult<List<Blog>> list() {
        return success(blogService.list());
    }

    @SaCheckRole(RoleConstant.ADMIN)
    @PostMapping
    public AjaxResult<Void> insert(@Validated(InsertGroup.class) @RequestBody Blog blog) {
        return toAjax(blogService.save(blog));
    }

    @SaCheckRole(RoleConstant.ADMIN)
    @PutMapping
    public AjaxResult<Void> update(@Validated(UpdateGroup.class) @RequestBody Blog blog) {
        return toAjax(blogService.updateById(blog));
    }

    @SaCheckRole(RoleConstant.ADMIN)
    @PostMapping
    public AjaxResult<Void> delete(@Validated(DeleteGroup.class) @RequestBody Blog blog) {
        return toAjax(blogService.removeById(blog));
    }

}
