package top.yueqiao.blog.domain.model.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;

/**
 * @author yueqiao
 * @date 2025/04/15/11:40
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BlogArchiveVo implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    /**
     * 博客id
     */
    private Integer id;
    /**
     * 博客标题
     */
    private String title;
    /**
     * 发表年月
     */
    private String yearMonth;
    /**
     * 发表日期
     */
    private String day;
}
