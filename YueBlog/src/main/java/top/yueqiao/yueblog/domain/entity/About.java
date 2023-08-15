package top.yueqiao.yueblog.domain.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;
import top.yueqiao.yueblog.domain.BaseEntity;

import java.io.Serializable;

/**
 * 关于表
 *
 * @author yueqiao
 * @TableName about
 */
@Data
@Accessors(chain = true)
@TableName(value ="about")
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class About extends BaseEntity implements Serializable {

    /**
     * 关于主键id
     */
    @TableId
    private Integer aboutId;

    /**
     * 关于标题
     */
    private String aboutTitle;

    /**
     * 音乐id
     */
    private String musicId;

    /**
     * 关于正文
     */
    private String aboutContent;

}