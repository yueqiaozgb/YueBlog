package top.yueqiao.yueblog.domain.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import top.yueqiao.yueblog.domain.BaseEntity;

import java.io.Serializable;

/**
 * 博客标签表
 *
 * @author yueqiao
 * @TableName blog_tag
 */
@Data
@Accessors(chain = true)
@TableName(value ="blog_tag")
@EqualsAndHashCode(callSuper = true)
public class BlogTag extends BaseEntity implements Serializable {

    /**
     * 主键id
     */
    @TableId(type = IdType.AUTO)
    private Long blogTagId;

    /**
     * 博客id
     */
    private Long blogId;

    /**
     * 标签id
     */
    private Long tagId;

}