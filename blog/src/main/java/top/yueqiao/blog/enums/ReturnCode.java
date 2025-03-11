package top.yueqiao.blog.enums;

import lombok.Getter;

/**
 * @author : yueqiao
 * @date : 2025/3/11 23:25
 */
@Getter
public enum ReturnCode {

    RC200(200, "ok"),
    RC400(400, "请求失败,参数错误,请检查后重试"),
    RC404(404, "未找到您请求的资源"),
    RC405(405, "请求方式错误,请检查后重试"),
    RC500(500, "操作失败,服务器繁忙或服务器错误,请稍后再试"),
    RC4001(4001, "业务异常");

    private final int code;

    private final String msg;

    ReturnCode(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

}
