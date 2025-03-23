package top.yueqiao.blog.domain.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import top.yueqiao.blog.domain.BaseEntity;

import java.io.Serial;

/**
 * @author : yueqiao
 * @date : 2025/3/11 23:13
 */
@Data
@TableName("sys_user_role")
@EqualsAndHashCode(callSuper = true)
public class UserRole extends BaseEntity {
    @Serial
    private static final long serialVersionUID = 1L;
    private Integer userId;
    private Integer roleId;
}
