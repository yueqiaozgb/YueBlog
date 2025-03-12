package top.yueqiao.blog.controller;

import cn.dev33.satoken.stp.StpUtil;
import jakarta.annotation.Resource;
import jakarta.validation.constraints.NotBlank;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import top.yueqiao.blog.model.AjaxResult;
import top.yueqiao.blog.service.ILoginService;

/**
 * @author : yueqiao
 * @date : 2025/3/8 23:32
 */
@RestController
@RequestMapping("/user")
public class UserController extends BaseController {

    @Resource
    private ILoginService loginService;

    // 用户登录，浏览器访问： http://localhost:8080/user/login
    @RequestMapping("/login")
    public AjaxResult doLogin(@NotBlank(message = "用户名不能为空") @RequestParam String username,
                              @NotBlank(message = "密码不能为空") @RequestParam String password) {
        return success(loginService.login(username, password));
    }

    // 退出登录，浏览器访问： http://localhost:8080/user/logout
    @RequestMapping("/logout")
    public AjaxResult logout() {
        StpUtil.logout();
        return success();
    }

}
