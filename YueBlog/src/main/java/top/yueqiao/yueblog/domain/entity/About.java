package top.yueqiao.yueblog.domain.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;
import top.yueqiao.yueblog.domain.BaseEntity;
import top.yueqiao.yueblog.validate.UpdateGroup;

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
    @NotNull(message = "关于主键id不能为空", groups = {UpdateGroup.class})
    private Integer aboutId;

    /**
     * 关于标题
     */
    @NotBlank(message = "关于标题不能为空", groups = {UpdateGroup.class})
    private String aboutTitle;

    /**
     * 音乐id
     */
    @NotBlank(message = "音乐id不能为空", groups = {UpdateGroup.class})
    private String musicId;

    /**
     * 关于正文
     */
    @NotBlank(message = "关于正文不能为空", groups = {UpdateGroup.class})
    private String aboutContent;

}