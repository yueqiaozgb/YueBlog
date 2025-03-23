package top.yueqiao.blog.exception;

import cn.dev33.satoken.exception.NotLoginException;
import cn.dev33.satoken.exception.NotRoleException;
import cn.hutool.http.HttpStatus;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import top.yueqiao.blog.domain.AjaxResult;

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

    @ExceptionHandler(NotRoleException.class)
    public AjaxResult handleAccessDeniedException(NotRoleException e, HttpServletRequest request) {
        String requestUri = request.getRequestURI();
        log.error("请求地址'{}',角色校验失败'{}'", requestUri, e.getMessage());
        return AjaxResult.error(HttpStatus.HTTP_FORBIDDEN, "没有角色，请联系管理员授权");
    }

    @ExceptionHandler(NotLoginException.class)
    public AjaxResult handleNotLoginException(NotLoginException e, HttpServletRequest request) {
        String requestUri = request.getRequestURI();
        log.error("请求地址'{}',登录校验失败'{}'", requestUri, e.getMessage());
        return AjaxResult.error(HttpStatus.HTTP_FORBIDDEN, "未登录，请先登录");
    }

}
