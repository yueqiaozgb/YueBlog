package top.yueqiao.blog.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author : yueqiao
 * @date : 2025/3/11 23:13
 */
@Data
@TableName("sys_user_role")
@EqualsAndHashCode(callSuper = true)
public class UserRole extends BaseEntity {
    private Integer userId;
    private Integer roleId;
}
