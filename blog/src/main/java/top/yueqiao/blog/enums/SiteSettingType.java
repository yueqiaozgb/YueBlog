package top.yueqiao.blog.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author : yueqiao
 * @date : 2025/4/4 22:52
 */
@Getter
@AllArgsConstructor
public enum SiteSettingType {

    accountInfo("账户信息", "1"),
    userInfo("用户信息", "2");

    private final String label;
    private final String value;

}