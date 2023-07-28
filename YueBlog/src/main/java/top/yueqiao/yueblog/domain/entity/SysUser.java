package top.yueqiao.yueblog.domain.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import top.yueqiao.yueblog.domain.BaseEntity;

/**
 * 系统用户表
 *
 * @author yueqiao
 */
@EqualsAndHashCode(callSuper = true)
@TableName(value ="sys_user")
@Data
public class SysUser extends BaseEntity {
    /**
     * 主键id
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 用户名
     */
    private String username;

    /**
     * 昵称
     */
    private String nickname;

    /**
     * 电话
     */
    private String phone;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 性别
     */
    private String sex;

    /**
     * 密码
     */
    private String password;

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