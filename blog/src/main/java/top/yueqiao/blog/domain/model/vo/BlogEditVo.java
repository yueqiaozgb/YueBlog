package top.yueqiao.blog.domain.model.vo;

import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

/**
 * @author yueqiao
 * @date 2025/03/28/17:46
 */
@Data
public class BlogEditVo implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    private Integer id;
    private Integer categoryId;
    private List<Integer> tagIdList;
    private String title;
    private String cover;
    private String description;
    private String content;
    private Integer wordCount;
    private Integer readTime;
}