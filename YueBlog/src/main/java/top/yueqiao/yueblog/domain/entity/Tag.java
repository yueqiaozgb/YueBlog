package top.yueqiao.yueblog.domain.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import top.yueqiao.yueblog.domain.BaseEntity;

/**
 * 标签表
 *
 * @author yueqiao
 * @TableName tag
 */
@Data
@Accessors(chain = true)
@TableName(value ="tag")
@EqualsAndHashCode(callSuper = true)
public class Tag extends BaseEntity {

    /**
     * 标签id
     */
    @TableId(type = IdType.AUTO)
    private Integer tagId;

    /**
     * 标签名称
     */
    private String tagName;

    /**
     * 标签简介
     */
    private String tagIntroduction;

    /**
     * 标签颜色
     */
    private String tagColor;

}