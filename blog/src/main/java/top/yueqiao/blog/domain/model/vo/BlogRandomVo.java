package top.yueqiao.blog.domain.model.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;

/**
 * @author : yueqiao
 * @date : 2025/4/5 23:15
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BlogRandomVo implements Serializable {
    @Serial
    private final static long serialVersionUID = 1L;
    private Integer id;
    private String cover;
    private String title;
    private String createTime;
}
