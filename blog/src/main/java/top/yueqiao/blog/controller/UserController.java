package top.yueqiao.blog.controller;

import cn.dev33.satoken.stp.StpUtil;
import jakarta.annotation.Resource;
import jakarta.validation.constraints.NotBlank;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import top.yueqiao.blog.entity.AjaxResult;
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

    @RequestMapping("doLogin")
    public AjaxResult doLogin(@NotBlank(message = "用户名不能为空") @RequestParam String username,
                              @NotBlank(message = "密码不能为空") @RequestParam String password) {
        return toAjax(loginService.login(username, password));
    }

    // 查询登录状态，浏览器访问： http://localhost:8080/user/isLogin
    @RequestMapping("isLogin")
    public String isLogin() {
        return "当前会话是否登录：" + StpUtil.isLogin();
    }

    // 退出登录，浏览器访问： http://localhost:8080/user/logout
    @RequestMapping("logout")
    public String logout() {
        StpUtil.logout();
        return "退出登录";
    }

}
