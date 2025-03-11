package top.yueqiao.blog.entity.model;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import top.yueqiao.blog.entity.BaseEntity;

/**
 * @author yueqiao
 * @date 2025/03/11/18:53
 */
@Data
@TableName("sys_role")
@EqualsAndHashCode(callSuper = true)
public class Role extends BaseEntity {
    @TableId
    private Integer id;
    private String roleName;
    private String roleKey;
}
