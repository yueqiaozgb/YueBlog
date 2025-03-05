package top.yueqiao.blog.entity;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author yueqiao
 * @date 2025/03/05/16:44
 */
@Data
public class BaseEntity {
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
}
