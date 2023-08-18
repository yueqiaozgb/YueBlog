package top.yueqiao.yueblog.domain.vo;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author yueqiao
 */
@Data
@NoArgsConstructor
public class BlogArchiveVo {

    /**
     * 博客id
     */
    private Long blogId;

    /**
     * 博客标题
     */
    private String blogTitle;

    /**
     * 年月信息
     */
    private String yearMonth;

    /**
     * 日期信息
     */
    private String day;

}
