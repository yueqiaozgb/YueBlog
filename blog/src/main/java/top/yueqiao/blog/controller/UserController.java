package top.yueqiao.blog.controller;

import cn.dev33.satoken.stp.StpUtil;
import cn.dev33.satoken.util.SaResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : yueqiao
 * @date : 2025/3/8 23:32
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @GetMapping("/login")
    public SaResult login(String username, String password) {
        if ("admin".equals(username) && "123456".equals(password)) {
            // 登录认证
            StpUtil.login(100000);
            // 生成token，token 信息自动存入redis，在yml里配置 sa-token 相关信息
            String token = StpUtil.getTokenValue();
            System.out.println(token);
            // 将用户信息存入 redis
            return SaResult.ok("登录成功");
        }
        return SaResult.error("登录失败");
    }

    @GetMapping("/logout")
    public SaResult logout() {
        StpUtil.logout();
        return SaResult.ok("退出成功");
    }

}
