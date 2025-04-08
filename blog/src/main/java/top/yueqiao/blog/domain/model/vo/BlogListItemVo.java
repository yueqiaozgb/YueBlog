package top.yueqiao.blog.domain.model.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author yueqiao
 * @date 2025/03/28/17:19
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BlogListItemVo implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    private Integer id;
    private Integer categoryId;
    private String title;
    private Integer wordCount;
    private Integer readTime;
    private LocalDateTime createTime;
}
