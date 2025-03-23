package top.yueqiao.blog.domain;

import lombok.Data;
import top.yueqiao.blog.enums.ReturnCode;

/**
 * @author : yueqiao
 * @date : 2025/3/11 23:31
 */
@Data
public class AjaxResult {
    private Integer code;
    private String msg;
    private Object data;

    public AjaxResult(Integer code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public AjaxResult(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public static AjaxResult success(Object data) {
        return new AjaxResult(ReturnCode.RC200.getCode(), ReturnCode.RC200.getMsg(), data);
    }

    public static AjaxResult success() {
        return new AjaxResult(ReturnCode.RC200.getCode(), ReturnCode.RC200.getMsg());
    }

    public static AjaxResult error(Integer code, String msg) {
        return new AjaxResult(code, msg);
    }

    public static AjaxResult error(String msg) {
        return new AjaxResult(ReturnCode.RC500.getCode(), msg);
    }

    public static AjaxResult error() {
        return new AjaxResult(ReturnCode.RC4001.getCode(), ReturnCode.RC4001.getMsg());
    }

}
