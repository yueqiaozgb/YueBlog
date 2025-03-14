package top.yueqiao.blog.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author yueqiao
 * @date 2025/03/11/18:43
 */

@Data
@TableName("sys_user")
@EqualsAndHashCode(callSuper = true)
public class User extends BaseEntity {
    @TableId
    private Integer id;
    private String username;
    private String password;
    private String nickname;
    private String email;
    private String github;
    private String avatar;
}
