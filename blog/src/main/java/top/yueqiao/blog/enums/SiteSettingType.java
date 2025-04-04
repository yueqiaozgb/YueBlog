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

    accountInfo("1", "账户信息"),
    userInfo("2", "用户信息");

    private final String type;
    private final String desc;

}