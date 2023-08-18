package top.yueqiao.yueblog.controller.admin;

import cn.dev33.satoken.stp.StpUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.yueqiao.yueblog.controller.BaseController;
import top.yueqiao.yueblog.domain.Result;
import top.yueqiao.yueblog.domain.dto.LoginDto;
import top.yueqiao.yueblog.service.UserService;

import java.util.Map;

/**
 * @author yueqiao
 */
@Slf4j
@Validated
@RestController
@RequestMapping("/admin/user")
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class UserController extends BaseController {

    private final UserService userService;

    @PostMapping("login")
    public Result<Map<String, Object>> login(@Validated @RequestBody LoginDto loginDto) {
        return Result.success("登录成功", userService.login(loginDto));
    }

    @RequestMapping("isLogin")
    public String isLogin() {
        log.info("当前会话ID:" + StpUtil.getLoginId());
        return "当前会话是否登录：" + StpUtil.isLogin();
    }

}

