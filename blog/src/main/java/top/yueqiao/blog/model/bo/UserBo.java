package top.yueqiao.blog.model.bo;

import lombok.Data;
import lombok.EqualsAndHashCode;
import top.yueqiao.blog.entity.User;

import java.util.List;

/**
 * @author yueqiao
 * @date 2025/03/12/10:02
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class UserBo extends User {
    private List<String> roleList;
    private List<String> permissionList;
}
