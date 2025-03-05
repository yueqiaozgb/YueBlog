package top.yueqiao.blog.entity.po;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import top.yueqiao.blog.entity.BaseEntity;

/**
 * @author yueqiao
 * @date 2025/03/05/17:04
 */

@Data
@TableName("blog")
@EqualsAndHashCode(callSuper = true)
public class Blog extends BaseEntity {
    @TableId
    private Integer id;
    private String title;
    private String content;
}
