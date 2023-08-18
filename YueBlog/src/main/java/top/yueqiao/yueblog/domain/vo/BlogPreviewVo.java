package top.yueqiao.yueblog.domain.vo;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author yueqiao
 */
@Data
@NoArgsConstructor
public class BlogPreviewVo {

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
     * 博客封面
     */
    private String blogCover;

    /**
     * 创建时间
     */
    private Date createTime;

}
