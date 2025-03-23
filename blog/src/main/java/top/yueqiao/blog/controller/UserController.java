package top.yueqiao.blog.controller;

import cn.dev33.satoken.stp.StpUtil;
import jakarta.annotation.Resource;
import jakarta.validation.constraints.NotBlank;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import top.yueqiao.blog.domain.AjaxResult;
import top.yueqiao.blog.service.ILoginService;

/**
 * @author : yueqiao
 * @date : 2025/3/8 23:32
 */
@Slf4j
@RestController
@RequestMapping("/user")
public class UserController extends BaseController {

    @Resource
    private ILoginService loginService;

    // 用户登录，浏览器访问： http://localhost:8080/user/login?username=admin&password=123456
    @PostMapping("/login")
    public AjaxResult login(@NotBlank(message = "用户名不能为空") @RequestParam String username,
                              @NotBlank(message = "密码不能为空") @RequestParam String password) {
        return success(loginService.login(username, password));
    }

    // 退出登录，浏览器访问： http://localhost:8080/user/logout
    @PostMapping("/logout")
    public AjaxResult logout() {
        log.info("退出登录,用户 id: {}", StpUtil.getLoginId());
        StpUtil.logout();
        return success();
    }

}
