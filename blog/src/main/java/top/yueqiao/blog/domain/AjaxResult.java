package top.yueqiao.blog.domain;

import lombok.Data;
import top.yueqiao.blog.enums.ReturnCode;

import java.io.Serial;
import java.io.Serializable;

/**
 * @author : yueqiao
 * @date : 2025/3/11 23:31
 */
@Data
public class AjaxResult<T> implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private Integer code;

    private String msg;

    private T data;

    public AjaxResult(Integer code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public AjaxResult(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public static <T> AjaxResult<T> success(T data) {
        return new AjaxResult<>(ReturnCode.RC200.getCode(), ReturnCode.RC200.getMsg(), data);
    }

    public static <T> AjaxResult<T> success() {
        return new AjaxResult<>(ReturnCode.RC200.getCode(), ReturnCode.RC200.getMsg());
    }

    public static <T> AjaxResult<T> error(Integer code, String msg) {
        return new AjaxResult<>(code, msg);
    }

    public static <T> AjaxResult<T> error(String msg) {
        return new AjaxResult<>(ReturnCode.RC500.getCode(), msg);
    }

    public static <T> AjaxResult<T> error() {
        return new AjaxResult<>(ReturnCode.RC4001.getCode(), ReturnCode.RC4001.getMsg());
    }

}
