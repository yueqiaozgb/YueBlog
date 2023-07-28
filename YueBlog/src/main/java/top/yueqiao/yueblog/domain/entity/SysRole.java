package top.yueqiao.yueblog.domain.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import top.yueqiao.yueblog.domain.BaseEntity;

/**
 * 系统角色表
 *
 * @author yueqiao
 */
@EqualsAndHashCode(callSuper = true)
@TableName(value = "sys_role")
@Data
public class SysRole extends BaseEntity {
    /**
     * 主键id
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 角色名称
     */
    private String roleName;

    /**
     * 角色权限
     */
    private String roleKey;

    /**
     * 状态
     */
    private String status;

    /**
     * 删除标志
     */
    @TableLogic
    private String delFlag;

    /**
     * 备注
     */
    private String remark;

}