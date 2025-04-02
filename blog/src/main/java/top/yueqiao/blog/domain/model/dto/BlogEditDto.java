package top.yueqiao.blog.domain.model.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import top.yueqiao.blog.interfaces.InsertGroup;
import top.yueqiao.blog.interfaces.UpdateGroup;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

/**
 * @author yueqiao
 * @date 2025/04/02/16:32
 */
@Data
public class BlogEditDto implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    @NotNull(message = "id不能为空", groups = {UpdateGroup.class})
    private Integer id;
    @NotNull(message = "分类不能为空", groups = {InsertGroup.class, UpdateGroup.class})
    private Integer categoryId;
    @NotNull(message = "标签不能为空", groups = {InsertGroup.class, UpdateGroup.class})
    private List<Integer> tagIdList;
    @NotBlank(message = "标题不能为空", groups = {InsertGroup.class, UpdateGroup.class})
    private String title;
    @NotNull(message = "封面不能为空", groups = {InsertGroup.class, UpdateGroup.class})
    private String cover;
    @NotBlank(message = "摘要不能为空", groups = {InsertGroup.class, UpdateGroup.class})
    private String description;
    @NotBlank(message = "内容不能为空", groups = {InsertGroup.class, UpdateGroup.class})
    private String content;
    private Integer wordCount;
    private Integer readTime;
}
