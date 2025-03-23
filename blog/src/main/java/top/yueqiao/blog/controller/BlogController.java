package top.yueqiao.blog.controller;

import cn.dev33.satoken.annotation.SaCheckRole;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.yueqiao.blog.model.AjaxResult;

/**
 * @author yueqiao
 * @date 2025/03/13/18:16
 */
@RestController
@RequestMapping("/blog")
public class BlogController extends BaseController{

    @SaCheckRole("ADMIN")
    @GetMapping()
    public AjaxResult getInfo() {
        return success("1");
    }

}
