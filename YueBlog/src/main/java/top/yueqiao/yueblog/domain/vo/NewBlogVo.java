package top.yueqiao.yueblog.domain.vo;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author yueqiao
 */
@Data
@NoArgsConstructor
public class NewBlogVo {

    /**
     * 博客id
     */
    private Long blogId;

    /**
     * 博客标题
     */
    private String blogTitle;

}
