package top.yueqiao.yueblog.domain.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;
import top.yueqiao.yueblog.domain.BaseEntity;

import java.util.ArrayList;
import java.util.List;

/**
 * 博客表
 *
 * @author yueqiao
 * @TableName blog
 */
@Data
@Accessors(chain = true)
@TableName(value ="blog")
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class Blog extends BaseEntity {

    /**
     * 博客id
     */
    @TableId(type = IdType.AUTO)
    private Long blogId;

    /**
     * 博客标题
     */
    private String blogTitle;

    /**
     * 博客简介
     */
    private String blogIntroduction;

    /**
     * 博客封面
     */
    private String blogCover;

    /**
     * 博客正文
     */
    private String blogContent;

    /**
     * 推荐指数
     */
    private Long recommendIndex;

    /**
     * 博客字数
     */
    private Long blogWords;

    /**
     * 阅读时间
     */
    private Long readTime;

    /**
     * 分类
     */
    @TableField(exist = false)
    private Category category;

    /**
     * 标签
     */
    @TableField(exist = false)
    private List<Tag> tags = new ArrayList<>();

}