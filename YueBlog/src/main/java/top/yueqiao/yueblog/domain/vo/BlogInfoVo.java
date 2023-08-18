package top.yueqiao.yueblog.domain.vo;

import lombok.Data;
import lombok.NoArgsConstructor;
import top.yueqiao.yueblog.domain.entity.Category;
import top.yueqiao.yueblog.domain.entity.Tag;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author yueqiao
 */
@Data
@NoArgsConstructor
public class BlogInfoVo {

    /**
     * 博客id
     */
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
    private Category category;

    /**
     * 标签
     */
    private List<Tag> tags = new ArrayList<>();

    /**
     * 创建时间
     */
    private Date createTime;

}
