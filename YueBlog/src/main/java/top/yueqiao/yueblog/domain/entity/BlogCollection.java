package top.yueqiao.yueblog.domain.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import top.yueqiao.yueblog.domain.BaseEntity;

/**
 * 博客合集表
 *
 * @author yueqiao
 * @TableName blog_collection
 */

@Data
@Accessors(chain = true)
@TableName(value ="blog_collection")
@EqualsAndHashCode(callSuper = true)
public class BlogCollection extends BaseEntity {

    /**
     * 主键id
     */
    @TableId(type = IdType.AUTO)
    private Long blogCollectionId;

    /**
     * 博客id
     */
    private Long blogId;

    /**
     * 合集id
     */
    private Long collectionId;

}