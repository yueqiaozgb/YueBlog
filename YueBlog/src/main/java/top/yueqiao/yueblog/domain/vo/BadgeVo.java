package top.yueqiao.yueblog.domain.vo;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author yueqiao
 */
@Data
@NoArgsConstructor
public class BadgeVo {

    private String title;
    private String url;
    private String subject;
    private String value;
    private String color;

}
