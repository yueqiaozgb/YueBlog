package top.yueqiao.blog.entity.model;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import top.yueqiao.blog.entity.BaseEntity;

/**
 * @author yueqiao
 * @date 2025/03/11/18:43
 */

@Data
@TableName("sys_user")
@EqualsAndHashCode(callSuper = true)
public class User extends BaseEntity {
    private Integer id;
    private String username;
    private String password;
    private String nickname;
    private String email;
    private String github;
    private String avatar;
}
