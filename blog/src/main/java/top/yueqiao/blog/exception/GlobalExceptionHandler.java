package top.yueqiao.blog.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import top.yueqiao.blog.model.AjaxResult;

/**
 * @author yueqiao
 * @date 2025/03/11/14:41
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public AjaxResult handlerException(Exception e) {
        log.error("全局异常", e);
        return AjaxResult.error(e.getMessage());
    }

    @ExceptionHandler(ServiceException.class)
    public AjaxResult handlerServiceException(ServiceException e) {
        log.error("业务异常", e);
        return AjaxResult.error(e.getCode(), e.getMessage());
    }

}
