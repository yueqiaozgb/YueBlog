package top.yueqiao.yueblog.domain.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;
import top.yueqiao.yueblog.validate.DeleteGroup;
import top.yueqiao.yueblog.validate.InsertGroup;
import top.yueqiao.yueblog.validate.UpdateGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * 博客Dto对象
 *
 * @author yueqiao
 * @TableName blog
 */
@Data
@NoArgsConstructor
public class BlogDto {

    /**
     * 博客id
     */
    @NotNull(message = "博客id不能为空", groups = {DeleteGroup.class, UpdateGroup.class})
    private Long blogId;

    /**
     * 博客标题
     */
    @NotBlank(message = "博客标题不能为空", groups = {InsertGroup.class, UpdateGroup.class})
    private String blogTitle;

    /**
     * 博客简介
     */
    @NotBlank(message = "博客简介不能为空", groups = {InsertGroup.class, UpdateGroup.class})
    private String blogIntroduction;

    /**
     * 博客封面
     */
    @NotBlank(message = "博客封面不能为空", groups = {InsertGroup.class, UpdateGroup.class})
    private String blogCover;

    /**
     * 博客正文
     */
    @NotBlank(message = "博客正文不能为空", groups = {InsertGroup.class, UpdateGroup.class})
    private String blogContent;

    /**
     * 推荐指数
     */
    @NotNull(message = "推荐指数不能为空", groups = {InsertGroup.class, UpdateGroup.class})
    private Long recommendIndex;

    /**
     * 博客字数
     */
    @NotNull(message = "博客字数不能为空", groups = {InsertGroup.class, UpdateGroup.class})
    private Long blogWords;

    /**
     * 阅读时间
     */
    @NotNull(message = "阅读时间不能为空", groups = {InsertGroup.class, UpdateGroup.class})
    private Long readTime;

    /**
     * 分类
     */
    @NotNull(message = "分类不能为空", groups = {InsertGroup.class, UpdateGroup.class})
    private Long category;

    /**
     * 标签
     */
    @NotNull(message = "标签不能为空", groups = {InsertGroup.class, UpdateGroup.class})
    private List<Long> tagList = new ArrayList<>();

}