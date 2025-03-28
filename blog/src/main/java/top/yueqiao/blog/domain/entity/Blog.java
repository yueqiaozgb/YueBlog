package top.yueqiao.blog.domain.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;
import top.yueqiao.blog.domain.BaseEntity;
import top.yueqiao.blog.interfaces.InsertGroup;
import top.yueqiao.blog.interfaces.UpdateGroup;

import java.io.Serial;

/**
 * @author yueqiao
 * @date 2025/03/05/17:04
 */

@Data
@TableName("blog")
@EqualsAndHashCode(callSuper = true)
public class Blog extends BaseEntity {
    @Serial
    private static final long serialVersionUID = 1L;
    @TableId
    @NotNull(message = "id不能为空", groups = {UpdateGroup.class})
    private Integer id;
    @NotNull(message = "分类不能为空", groups = {InsertGroup.class, UpdateGroup.class})
    private Integer categoryId;
    @NotBlank(message = "标题不能为空", groups = {InsertGroup.class, UpdateGroup.class})
    private String title;
    private String cover;
    @NotBlank(message = "摘要不能为空", groups = {InsertGroup.class, UpdateGroup.class})
    private String description;
    @NotBlank(message = "内容不能为空", groups = {InsertGroup.class, UpdateGroup.class})
    private String content;
    private Integer wordCount;
    private Integer readTime;
}
