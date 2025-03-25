package top.yueqiao.blog.controller;

import cn.dev33.satoken.annotation.SaCheckRole;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.yueqiao.blog.constant.RoleConstant;
import top.yueqiao.blog.domain.AjaxResult;
import top.yueqiao.blog.domain.entity.Blog;
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
    public AjaxResult<List<Blog>> getInfo() {
        return success(blogService.list());
    }

}
