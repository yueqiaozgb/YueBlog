package top.yueqiao.yueblog.domain.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import top.yueqiao.yueblog.domain.BaseEntity;

/**
 * 系统菜单表
 *
 * @author yueqiao
 */
@EqualsAndHashCode(callSuper = true)
@TableName(value = "sys_menu")
@Data
public class SysMenu extends BaseEntity {

    /**
     * 主键id
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 父菜单id
     */
    private Long parentId;

    /**
     * 菜单名称
     */
    private String menuName;

    /**
     * 菜单图标
     */
    private String menuIcon;

    /**
     * 菜单类型
     */
    private String menuCategory;

    /**
     * 菜单权限
     */
    private String menuPerms;

    /**
     * 显示顺序
     */
    private Integer orderNum;

    /**
     * 路由
     */
    private String path;

    /**
     * 组件路径
     */
    private String component;

    /**
     * 是否外链
     */
    private String isFrame;

    /**
     * 是否缓存
     */
    private String isCache;

    /**
     * 是否可见
     */
    private String isVisible;

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