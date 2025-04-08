package top.yueqiao.blog.controller.admin;

import cn.dev33.satoken.annotation.SaCheckRole;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import top.yueqiao.blog.constant.RoleConstant;
import top.yueqiao.blog.controller.BaseController;
import top.yueqiao.blog.domain.AjaxResult;
import top.yueqiao.blog.domain.PageQuery;
import top.yueqiao.blog.domain.PageResult;
import top.yueqiao.blog.domain.model.dto.BlogEditDto;
import top.yueqiao.blog.domain.model.dto.BlogListDto;
import top.yueqiao.blog.domain.model.vo.BlogEditVo;
import top.yueqiao.blog.domain.model.vo.BlogListItemVo;
import top.yueqiao.blog.interfaces.InsertGroup;
import top.yueqiao.blog.interfaces.UpdateGroup;
import top.yueqiao.blog.service.IBlogService;

/**
 * @author yueqiao
 * @date 2025/03/13/18:16
 */
@RestController
@RequestMapping("/blog")
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class BlogController extends BaseController {

    private final IBlogService blogService;

    @SaCheckRole(RoleConstant.ADMIN)
    @GetMapping("/list")
    public PageResult<BlogListItemVo> list(BlogListDto blogListDto, PageQuery pageQuery) {
        return blogService.selectPageBlogList(blogListDto, pageQuery);
    }

    @SaCheckRole(RoleConstant.ADMIN)
    @GetMapping("/{id}")
    public AjaxResult<BlogEditVo> select(@NotNull(message = "id不能为空") @PathVariable Integer id) {
        return AjaxResult.success(blogService.selectBlogById(id));
    }

    @SaCheckRole(RoleConstant.ADMIN)
    @PostMapping
    public AjaxResult<Integer> insert(@Validated(InsertGroup.class) @RequestBody BlogEditDto blog) {
        return AjaxResult.success(blogService.insertBlog(blog));
    }

    @SaCheckRole(RoleConstant.ADMIN)
    @PutMapping
    public AjaxResult<Void> update(@Validated(UpdateGroup.class) @RequestBody BlogEditDto blog) {
        return toAjax(blogService.updateBlog(blog));
    }

    @SaCheckRole(RoleConstant.ADMIN)
    @DeleteMapping("/{ids}")
    public AjaxResult<Void> delete(@NotEmpty(message = "id不能为空") @PathVariable Integer[] ids) {
        return toAjax(blogService.deleteBlogByIds(ids));
    }

}
