package top.yueqiao.blog.exception;

import cn.dev33.satoken.util.SaResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author yueqiao
 * @date 2025/03/11/14:41
 */

@RestControllerAdvice
public class GlobalExceptionHandler {

    // 全局异常拦截
    @ExceptionHandler
    public SaResult handlerException(Exception e) {
        e.printStackTrace();
        return SaResult.error(e.getMessage());
    }

}
