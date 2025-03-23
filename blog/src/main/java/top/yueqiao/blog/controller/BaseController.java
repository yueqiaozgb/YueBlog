package top.yueqiao.blog.controller;

import top.yueqiao.blog.domain.AjaxResult;

/**
 * @author : yueqiao
 * @date : 2025/3/11 23:46
 */
public class BaseController {

    public static AjaxResult success(Object data) {
        return AjaxResult.success(data);
    }

    public static AjaxResult success() {
        return AjaxResult.success();
    }

    public static AjaxResult toAjax(int result) {
        return result == 1 ? AjaxResult.success() : AjaxResult.error();
    }

    public static AjaxResult toAjax(boolean result) {
        return result ? AjaxResult.success() : AjaxResult.error();
    }

}
