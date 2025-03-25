package top.yueqiao.blog.controller;

import top.yueqiao.blog.domain.AjaxResult;

/**
 * @author : yueqiao
 * @date : 2025/3/11 23:46
 */
public class BaseController {

    public static <T> AjaxResult<T> success(T data) {
        return AjaxResult.success(data);
    }

    public static <T> AjaxResult<T> success() {
        return AjaxResult.success();
    }

    public static <T> AjaxResult<T> toAjax(int result) {
        return result == 1 ? AjaxResult.success() : AjaxResult.error();
    }

    public static <T> AjaxResult<T> toAjax(boolean result) {
        return result ? AjaxResult.success() : AjaxResult.error();
    }

}
