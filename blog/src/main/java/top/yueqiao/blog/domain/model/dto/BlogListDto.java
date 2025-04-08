package top.yueqiao.blog.domain.model.dto;

import com.baomidou.mybatisplus.annotation.TableId;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import top.yueqiao.blog.interfaces.InsertGroup;
import top.yueqiao.blog.interfaces.UpdateGroup;

import java.io.Serial;
import java.io.Serializable;

/**
 * @author : yueqiao
 * @date : 2025/4/8 22:35
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BlogListDto implements Serializable {
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
