package top.yueqiao.yueblog.constant;

/**
 * 常量
 *
 * @author yueqiao
 */
public class Constants {

    /**
     * 分页常量
     */
    public interface Page {
        int CURRENT_PAGE = 1;
        int PAGE_SIZE = 5;
        int NEW_PAGE_SIZE = 3;
        int RANDOM_LIMIT_SIZE = 5;
    }

    /**
     * 网站常量
     */
    public interface SiteSetting {
        String COPYRIGHT = "copyright";
        String AVATAR = "avatar";
        String NAME = "name";
        String GITHUB = "github";
        String QQ = "qq";
        String BILIBILI = "bilibili";
        String NETEASE = "netease";
        String EMAIL = "email";
        String FAVORITE = "favorite";
        String ROLL_TEXT = "rollText";
    }

    /**
     * 操作常量
     */
    public interface Flag {
        Integer INTEGER_SUCCESS = 1;
        Integer INTEGER_FAIL = 0;
        Boolean BOOLEAN_SUCCESS = true;
        Boolean BOOLEAN_FAIL = false;
    }

    /**
     * 角色常量
     */
    public interface Role {
        String ROLE_ADMIN = "admin";
    }

}
