package top.yueqiao.yueblog.controller.admin;

import cn.dev33.satoken.annotation.SaCheckRole;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import top.yueqiao.yueblog.controller.BaseController;
import top.yueqiao.yueblog.domain.PageInfo;
import top.yueqiao.yueblog.domain.PageQuery;
import top.yueqiao.yueblog.domain.Result;
import top.yueqiao.yueblog.domain.dto.BlogDto;
import top.yueqiao.yueblog.domain.entity.Blog;
import top.yueqiao.yueblog.domain.vo.BlogInfoVo;
import top.yueqiao.yueblog.service.BlogService;
import top.yueqiao.yueblog.validate.InsertGroup;
import top.yueqiao.yueblog.validate.UpdateGroup;

import static top.yueqiao.yueblog.constant.Constants.Role.ROLE_ADMIN;

/**
 * 博客控制器
 *
 * @author yueqiao
 */
@Slf4j
@Validated
@RestController
@RequestMapping("/admin/blog")
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class BlogAdminController extends BaseController {

    private final BlogService blogService;

    @GetMapping("/list")
    public PageInfo<BlogInfoVo> getBlogList(BlogDto blogDto, PageQuery pageQuery) {
        return blogService.selectPageBlogInfoVoList(blogDto, pageQuery);
    }

    @PostMapping
    @SaCheckRole(ROLE_ADMIN)
    public Result<Void> insert(@Validated(InsertGroup.class) @RequestBody BlogDto blogDto) {
        return toAjax(blogService.insertBlog(blogDto));
    }

    @GetMapping("/{id}")
    public Result<Blog> getBlog(@PathVariable @NotNull(message = "博客id不能为空") Long id) {
        return Result.success(blogService.selectBlogByID(id));
    }

    @PutMapping()
    @SaCheckRole(ROLE_ADMIN)
    public Result<Void> updateBlog(@Validated(UpdateGroup.class) @RequestBody BlogDto blogDto) {
        return toAjax(blogService.updateBlog(blogDto));
    }

    @DeleteMapping("/{id}")
    @SaCheckRole(ROLE_ADMIN)
    public Result<Void> deleteBlog(@PathVariable @NotNull(message = "博客id不能为空") Long id) {
        return toAjax(blogService.deleteBlog(id));
    }

}
