package top.yueqiao.yueblog.handler;

import cn.dev33.satoken.exception.NotLoginException;
import cn.dev33.satoken.exception.NotRoleException;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.http.HttpStatus;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import top.yueqiao.yueblog.domain.Result;
import top.yueqiao.yueblog.exception.ServiceException;
import top.yueqiao.yueblog.exception.UtilException;

/**
 * 全局异常拦截
 *
 * @author yueqiao
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * 权限校验异常
     */
    @ExceptionHandler(NotRoleException.class)
    public Result<Void> handleAccessDeniedException(NotRoleException e, HttpServletRequest request) {
        String requestUri = request.getRequestURI();
        log.error("请求地址'{}',权限校验失败'{}'", requestUri, e.getMessage());
        return Result.error(HttpStatus.HTTP_FORBIDDEN, "游客模式，无权限访问");
    }

    /**
     * 认证失败
     */
    @ExceptionHandler(NotLoginException.class)
    public Result<Void> handleAccessDeniedException(NotLoginException e, HttpServletRequest request) {
        String requestUri = request.getRequestURI();
        log.error("请求地址'{}',认证失败'{}',无法访问系统资源", requestUri, e.getMessage());
        return Result.error(HttpStatus.HTTP_UNAUTHORIZED, StrUtil.format("请求地址'{}',认证失败'{}',无法访问系统资源", requestUri, e.getMessage()));
    }

    /**
     * 业务异常
     */
    @ExceptionHandler(ServiceException.class)
    public Result<Void> handleServiceException(ServiceException e, HttpServletRequest request) {
        String requestUri = request.getRequestURI();
        log.error("请求地址'{}',业务异常'{}'", requestUri, e.getMessage());
        Integer code = e.getCode();
        return ObjectUtil.isNotNull(code) ? Result.error(code, e.getMessage()) : Result.error(e.getMessage());
    }

    @ExceptionHandler(UtilException.class)
    public Result<Void> handleUtilException(UtilException e, HttpServletRequest request) {
        String requestUri = request.getRequestURI();
        log.error("请求地址'{}',业务异常'{}'", requestUri, e.getMessage());
        return Result.error(e.getMessage());
    }

    /**
     * 请求方式不支持
     */
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public Result<Void> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException e, HttpServletRequest request) {
        String requestUri = request.getRequestURI();
        log.error("请求地址'{}',不支持'{}'请求", requestUri, e.getMethod());
        return Result.error(e.getMessage());
    }

    /**
     * 拦截未知的运行时异常
     */
    @ExceptionHandler(RuntimeException.class)
    public Result<Void> handleRuntimeException(RuntimeException e, HttpServletRequest request) {
        String requestUri = request.getRequestURI();
        log.error("请求地址'{}',发生未知异常.", requestUri, e);
        return Result.error(e.getMessage());
    }

    /**
     * 系统异常
     */
    @ExceptionHandler(Exception.class)
    public Result<Void> handleException(Exception e, HttpServletRequest request) {
        String requestUri = request.getRequestURI();
        log.error("请求地址'{}',发生系统异常.", requestUri, e);
        return Result.error(e.getMessage());
    }

}
