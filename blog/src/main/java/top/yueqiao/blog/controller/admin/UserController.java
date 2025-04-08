package top.yueqiao.blog.controller.admin;

import cn.dev33.satoken.stp.StpUtil;
import jakarta.validation.constraints.NotBlank;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import top.yueqiao.blog.controller.BaseController;
import top.yueqiao.blog.domain.AjaxResult;
import top.yueqiao.blog.service.ILoginService;

/**
 * @author : yueqiao
 * @date : 2025/3/8 23:32
 */
@RestController
@RequestMapping("/user")
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class UserController extends BaseController {

    private final ILoginService loginService;

    @PostMapping("/login")
    public AjaxResult<String> login(@NotBlank(message = "用户名不能为空") @RequestParam String username,
                              @NotBlank(message = "密码不能为空") @RequestParam String password) {
        return success(loginService.login(username, password));
    }

    @PostMapping("/logout")
    public AjaxResult<Void> logout() {
        StpUtil.logout();
        return success();
    }

}
