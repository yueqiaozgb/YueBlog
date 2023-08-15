package top.yueqiao.yueblog.domain.vo;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author yueqiao
 */
@Data
@NoArgsConstructor
public class BlogDetailVo {

    /**
     * 博客id
     */
    private Long blogId;

    /**
     * 博客标题
     */
    private String blogTitle;

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
    private BlogCategoryVo category;

    /**
     * 标签
     */
    private List<BlogTagVo> tags = new ArrayList<>();

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

}
