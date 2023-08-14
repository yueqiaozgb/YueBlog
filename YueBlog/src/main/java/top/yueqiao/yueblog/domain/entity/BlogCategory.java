package top.yueqiao.yueblog.domain.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import top.yueqiao.yueblog.domain.BaseEntity;

/**
 * 博客分类表
 *
 * @author yueqiao
 * @TableName blog_category
 */
@Data
@Accessors(chain = true)
@TableName(value ="blog_category")
@EqualsAndHashCode(callSuper = true)
public class BlogCategory extends BaseEntity {

    /**
     * 主键id
     */
    @TableId(type = IdType.AUTO)
    private Long blogCategoryId;

    /**
     * 博客id
     */
    private Long blogId;

    /**
     * 分类id
     */
    private Long categoryId;

}