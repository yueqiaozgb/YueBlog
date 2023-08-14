package top.yueqiao.yueblog.domain.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import top.yueqiao.yueblog.domain.BaseEntity;

/**
 * 分类表
 * @author yueqiao
 * @TableName category
 */
@Data
@Accessors(chain = true)
@TableName(value ="category")
@EqualsAndHashCode(callSuper = true)
public class Category extends BaseEntity {

    /**
     * 分类id
     */
    @TableId(type = IdType.AUTO)
    private Integer categoryId;

    /**
     * 分类名称
     */
    private String categoryName;

    /**
     * 分类简介
     */
    private String categoryIntroduction;

}