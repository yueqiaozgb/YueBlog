package top.yueqiao.yueblog.controller;

import cn.dev33.satoken.annotation.SaCheckLogin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yueqiao
 */
@RestController
public class HelloWorldController {

    @SaCheckLogin
    @GetMapping
    public String helloWorld() {
        return "hello world";
    }

}
