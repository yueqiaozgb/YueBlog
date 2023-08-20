package top.yueqiao.yueblog.util;

import cn.hutool.core.util.StrUtil;
import cn.hutool.crypto.SecureUtil;

/**
 * @author yueqiao
 */
public class SecurityUtils {

    /**
     * 生成BCryptPasswordEncoder密码
     *
     * @param password 密码
     * @return 加密字符串
     */
    public static String encryptPassword(String password) {
        return SecureUtil.md5(password);
    }

    /**
     * 判断密码是否相同
     *
     * @param rawPassword     真实密码
     * @param encodedPassword 加密后字符
     * @return 结果
     */
    public static boolean matchesPassword(String rawPassword, String encodedPassword) {
        return StrUtil.equals(SecureUtil.md5(rawPassword), encodedPassword);
    }

    public static void main(String[] args) {
        System.out.println(encryptPassword(""));
    }

}
