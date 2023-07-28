package top.yueqiao.yueblog.domain.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import top.yueqiao.yueblog.domain.BaseEntity;

/**
 * 系统角色菜单表
 *
 * @author yueqiao
 */
@EqualsAndHashCode(callSuper = true)
@TableName(value = "sys_role_menu")
@Data
public class SysRoleMenu extends BaseEntity {
    /**
     * 主键id
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 角色id
     */
    private Long roleId;

    /**
     * 菜单id
     */
    private Long menuId;

    /**
     * 状态
     */
    private String status;

    /**
     * 备注
     */
    private String remark;

}