package top.yueqiao.yueblog.util;

import cn.dev33.satoken.stp.StpUtil;
import top.yueqiao.yueblog.domain.entity.User;

/**
 * 登录工具类
 *
 * @author yueqiao
 */
public class LoginUtils {

    private final static String LOGIN_USER_KEY = "loginUser";

    /**
     * 获取用户
     **/
    public static User getLoginUser() {
        return (User) StpUtil.getTokenSession().get(LOGIN_USER_KEY);
    }

    /**
     * 设置用户数据
     */
    public static void setLoginUser(User user) {
        StpUtil.getTokenSession().set(LOGIN_USER_KEY, user);
    }

}
