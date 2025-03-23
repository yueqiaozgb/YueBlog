package top.yueqiao.blog.domain;

import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author yueqiao
 * @date 2025/03/05/16:44
 */
@Data
public class BaseEntity implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
}
