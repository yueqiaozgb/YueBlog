package top.yueqiao.blog.domain.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import top.yueqiao.blog.domain.BaseEntity;

/**
 * @author : yueqiao
 * @date : 2025/3/23 21:21
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("blog_tag")
@EqualsAndHashCode(callSuper = true)
public class BlogTag extends BaseEntity {
    private Integer blogId;
    private Integer tagId;
}
