package top.yueqiao.yueblog.controller;

import top.yueqiao.yueblog.domain.Result;

/**
 * @author yueqiao
 */
public class BaseController {

    /**
     * 返回成功
     */
    public Result<Void> success() {
        return Result.success();
    }

    /**
     * 返回失败消息
     */
    public Result<Void> error() {
        return Result.error();
    }

    /**
     * 返回成功消息
     */
    public Result<Void> success(String message) {
        return Result.success(message);
    }

    /**
     * 返回失败消息
     */
    public Result<Void> error(String message) {
        return Result.error(message);
    }

    /**
     * 响应返回结果
     *
     * @param rows 影响行数
     * @return 操作结果
     */
    protected Result<Void> toAjax(int rows) {
        return rows > 0 ? Result.success() : Result.error();
    }

    /**
     * 响应返回结果
     *
     * @param result 结果
     * @return 操作结果
     */
    protected Result<Void> toAjax(boolean result) {
        return result ? success() : error();
    }

}
