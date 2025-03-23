package top.yueqiao.blog.domain.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import top.yueqiao.blog.domain.BaseEntity;

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
    private Integer id;
    private String title;
    private String content;
}
