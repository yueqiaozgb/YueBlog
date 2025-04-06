package top.yueqiao.blog.domain.model.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import top.yueqiao.blog.domain.entity.Category;
import top.yueqiao.blog.domain.entity.Tag;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @author : yueqiao
 * @date : 2025/4/6 1:47
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BlogInfoVo implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    private Integer id;
    private String title;
    private String cover;
    private String description;
    private Integer wordCount;
    private Integer readTime;
    private LocalDateTime createTime;
    private Category category;
    private List<Tag> tagList;
}
