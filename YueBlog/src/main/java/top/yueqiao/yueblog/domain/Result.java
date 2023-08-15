package top.yueqiao.yueblog.domain;

import cn.hutool.http.HttpStatus;

import java.io.Serial;
import java.io.Serializable;

/**
 * 封装消息返回
 *
 * @author yueqiao
 */
public record Result<T>(Integer code, String msg, T data) implements Serializable {

    @Serial
    private final static long serialVersionUID = 1L;

    /**
     * 返回成功消息
     *
     * @return 成功消息
     */
    public static Result<Void> success() {
        return Result.success("操作成功");
    }

    /**
     * 返回成功数据
     *
     * @return 成功消息
     */
    public static <T> Result<T> success(T data) {
        return Result.success("操作成功", data);
    }

    /**
     * 返回成功消息
     *
     * @param msg 返回内容
     * @return 成功消息
     */
    public static Result<Void> success(String msg) {
        return Result.success(msg, null);
    }

    /**
     * 返回成功消息
     *
     * @param msg  返回内容
     * @param data 数据对象
     * @return 成功消息
     */
    public static <T> Result<T> success(String msg, T data) {
        return new Result<>(HttpStatus.HTTP_OK, msg, data);
    }

    /**
     * 返回错误消息
     *
     * @return 警告消息
     */
    public static Result<Void> error() {
        return Result.error("操作失败");
    }

    /**
     * 返回错误消息
     *
     * @param msg 返回内容
     * @return 警告消息
     */
    public static Result<Void> error(String msg) {
        return Result.error(msg, null);
    }

    /**
     * 返回错误消息
     *
     * @param msg  返回内容
     * @param data 数据对象
     * @return 警告消息
     */
    public static <T> Result<T> error(String msg, T data) {
        return new Result<>(HttpStatus.HTTP_INTERNAL_ERROR, msg, data);
    }

    /**
     * 返回错误消息
     *
     * @param code 状态码
     * @param msg  返回内容
     * @return 警告消息
     */
    public static Result<Void> error(int code, String msg) {
        return new Result<>(code, msg, null);
    }


}
