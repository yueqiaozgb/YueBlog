package top.yueqiao.blog.domain.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import top.yueqiao.blog.domain.BaseEntity;

import java.io.Serial;

/**
 * @author : yueqiao
 * @date : 2025/4/4 22:40
 */
@Data
@TableName("site_setting")
@EqualsAndHashCode(callSuper = true)
public class SiteSetting extends BaseEntity {
    @Serial
    private static final long serialVersionUID = 1L;
    @TableId
    private Integer id;
    private String name;
    private String type;
    @TableField(value = "`key`")
    private String key;
    private String value;
}
