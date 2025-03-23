package top.yueqiao.blog.domain.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import top.yueqiao.blog.domain.BaseEntity;

/**
 * @author : yueqiao
 * @date : 2025/3/23 21:21
 */
@Data
@TableName("blog_tag")
@EqualsAndHashCode(callSuper = true)
public class BlogTag extends BaseEntity {
    private Integer blogId;
    private Integer tagId;
}
