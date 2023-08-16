package top.yueqiao.yueblog.domain.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import top.yueqiao.yueblog.domain.BaseEntity;

/**
 * 网站配置表
 *
 * @author yueqiao
 * @TableName site_setting
 */
@Data
@Accessors(chain = true)
@TableName(value ="site_setting")
@EqualsAndHashCode(callSuper = true)
public class SiteSetting extends BaseEntity {

    /**
     * 主键id
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 配置key
     */
    private String settingKey;

    /**
     * 配置介绍
     */
    private String settingIntroduction;

    /**
     * 配置value
     */
    private String value;

    /**
     * 1基础设置，2页脚徽标，3资料卡，4友链信息
     */
    private Integer type;

}