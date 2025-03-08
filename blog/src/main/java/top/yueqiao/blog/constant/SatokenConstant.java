package top.yueqiao.blog.constant;

/**
 * @author : yueqiao
 * @date : 2025/3/8 23:26
 */
public class SatokenConstant {

    public static final String TOKEN= "X-Token";
    public static final String USER_PASSWORD= "123456";
    public static final int TOKEN_INVALID_CODE = 20001;
    public static final String TOKEN_INVALID_MSG = "Token无效，请重新登录";
    public static final int USERNAME_OCCUPIED_CODE = 20002;
    public static final String USERNAME_OCCUPIED_MSG = "用户名被占用，请重新输入";
    public static final int USERNAME_OR_PASSWORD_ERROR_CODE = 20003;
    public static final String USERNAME_OR_PASSWORD_ERROR_MSG = "用户名或密码输入错误";
    public static final int MISSING_NECESSARY_PARAMETERS_CODE = 20004;
    public static final String MISSING_NECESSARY_PARAMETERS_MSG = "缺少必要的参数";
    public static final int ORIGINAL_PASSWORD_ERROR_CODE = 20005;
    public static final String ORIGINAL_PASSWORD_ERROR_MSG = "原密码输入错误";
    public static final int PASSWORD_INCONSISTENCY_CODE = 20006;
    public static final String PASSWORD_INCONSISTENCY_MSG = "两次输入的新密码不一致";

    //  请求白名单，请求会放行
    public static final String[] WHITE_LIST = {
            "/user/login",
            "/user/logout"
    };

}
