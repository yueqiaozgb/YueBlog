package top.yueqiao.yueblog.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yueqiao
 */
@RestController
public class HelloWorldController {

    @GetMapping
    public String helloWorld(){
        return "hello world";
    }

}
