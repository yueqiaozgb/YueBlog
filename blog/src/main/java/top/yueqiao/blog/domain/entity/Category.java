package top.yueqiao.blog.domain.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import top.yueqiao.blog.domain.BaseEntity;

import java.io.Serial;

/**
 * @author : yueqiao
 * @date : 2025/3/23 21:18
 */
@Data
@TableName("category")
@EqualsAndHashCode(callSuper = true)
public class Category extends BaseEntity {
    @Serial
    private static final long serialVersionUID = 1L;
    @TableId
    private Integer id;
    private String name;
}
