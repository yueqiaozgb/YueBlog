package top.yueqiao.blog.domain.model.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;
import top.yueqiao.blog.domain.entity.Blog;
import top.yueqiao.blog.domain.entity.Tag;

import java.util.List;

/**
 * @author yueqiao
 * @date 2025/03/28/17:46
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class BlogEditVo extends Blog {
    private List<Tag> tagList;
}
