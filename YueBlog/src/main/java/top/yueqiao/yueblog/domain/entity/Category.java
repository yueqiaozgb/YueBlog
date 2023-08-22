package top.yueqiao.yueblog.domain.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import top.yueqiao.yueblog.domain.BaseEntity;
import top.yueqiao.yueblog.validate.InsertGroup;
import top.yueqiao.yueblog.validate.UpdateGroup;

/**
 * 分类表
 *
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
    @NotNull(message = "分类id不能为空", groups = {UpdateGroup.class})
    private Integer categoryId;

    /**
     * 分类名称
     */
    @NotBlank(message = "分类名称不能为空", groups = {InsertGroup.class, UpdateGroup.class})
    private String categoryName;

    /**
     * 分类简介
     */
    private String categoryIntroduction;

}