package top.yueqiao.blog.domain.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import top.yueqiao.blog.domain.BaseEntity;

import java.io.Serial;

/**
 * @author yueqiao
 * @date 2025/03/11/18:53
 */
@Data
@TableName("sys_role")
@EqualsAndHashCode(callSuper = true)
public class Role extends BaseEntity {
    @Serial
    private static final long serialVersionUID = 1L;
    @TableId
    private Integer id;
    private String roleName;
    private String roleKey;
}
