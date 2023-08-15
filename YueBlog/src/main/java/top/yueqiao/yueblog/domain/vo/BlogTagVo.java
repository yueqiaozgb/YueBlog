package top.yueqiao.yueblog.domain.vo;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author yueqiao
 */
@Data
@NoArgsConstructor
public class BlogTagVo {

    /**
     * 标签名称
     */
    private String tagName;

    /**
     * 标签颜色
     */
    private String tagColor;

}
